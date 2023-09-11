package br.com.sbs.sisgecon.client;

import br.com.sbs.sisgecon.client.dto.ClientView;
import br.com.sbs.sisgecon.client.dto.NewClientForm;
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
}
