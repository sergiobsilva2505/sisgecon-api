package br.com.sbs.sisgecon.containers;

import br.com.sbs.sisgecon.client.Client;
import br.com.sbs.sisgecon.client.ClientRepository;
import br.com.sbs.sisgecon.containers.dto.ContainerView;
import br.com.sbs.sisgecon.containers.dto.NewContainerForm;
import br.com.sbs.sisgecon.containers.dto.UpdateContainerForm;
import br.com.sbs.sisgecon.exception.ControllerNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ContainerService {

    private final ContainerRepository containerRepository;
    private final ClientRepository clientRepository;

    public ContainerService(ContainerRepository containerRepository, ClientRepository clientRepository) {
        this.containerRepository = containerRepository;
        this.clientRepository = clientRepository;
    }

    @Transactional
    public ContainerView save(NewContainerForm newContainerForm) {
        Client client = clientRepository.findById(newContainerForm.clientId())
                .orElseThrow(() -> new ControllerNotFoundException("Cliente não encontrado, id:%d".formatted(newContainerForm.clientId())));

        Container container = newContainerForm.toEntity(client);
        container = containerRepository.save(container);

        return new ContainerView(container);
    }

    @Transactional(readOnly = true)
    public List<ContainerView> findAll() {
        List<Container> containers = containerRepository.findAll();

        return containers.stream().map(ContainerView::new).toList();
    }

    @Transactional(readOnly = true)
    public ContainerView findById(Long id) {
        Container container = containerRepository.findById(id)
                .orElseThrow(() -> new ControllerNotFoundException("Container não encontrado, id:%d".formatted(id)));

        return new ContainerView(container);
    }

    @Transactional
    public ContainerView update(Long id, UpdateContainerForm updateContainerForm) {
        Container container = containerRepository.findById(id)
                .orElseThrow(() -> new ControllerNotFoundException("Container não encontrado, id:%d".formatted(id)));
        container.toMerge(updateContainerForm);

        return new ContainerView(container);
    }
}
