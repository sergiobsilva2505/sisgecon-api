package br.com.sbs.sisgeconapi.client.service;

import br.com.sbs.sisgeconapi.client.domain.Client;
import br.com.sbs.sisgeconapi.client.domain.ClientRepository;
import br.com.sbs.sisgeconapi.client.dto.ClientView;
import br.com.sbs.sisgeconapi.client.dto.NewClientForm;
import br.com.sbs.sisgeconapi.client.dto.UpdateClientForm;
import br.com.sbs.sisgeconapi.exception.ControllerNotFoundException;
import br.com.sbs.sisgeconapi.exception.DatabaseException;
import br.com.sbs.sisgeconapi.exception.ServiceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClientService {

    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Transactional
    public ClientView save(NewClientForm newClientForm) {
        Client client = clientRepository.save(newClientForm.toEntity());

        return new ClientView(client);
    }

    public List<ClientView> findAll() {
        List<Client> clients = clientRepository.findAll();

        return clients.stream().map(ClientView::new).toList();
    }

    public ClientView findById(Long id) {
        Client client = clientRepository.findById(id).orElseThrow(() -> new ControllerNotFoundException("Cliente não encontrado, id:%d".formatted(id)));
        return new ClientView(client);
    }

    @Transactional
    public ClientView update(Long id, UpdateClientForm updateClientForm) {
        Client client = clientRepository.findById(id).orElseThrow(() -> new ControllerNotFoundException("Cliente não encontrado, id:%d".formatted(id)));
        client.merge(updateClientForm);

        return new ClientView(client);
    }

    public void delete(Long id) {
        try {
            clientRepository.deleteById(id);
        } catch (EntityNotFoundException exception) {
            throw new ServiceNotFoundException("Cliente não existe, id:%d".formatted(id));
        } catch (DataIntegrityViolationException exception) {
            throw new DatabaseException("Violação de integridade da base");
        }
    }
}
