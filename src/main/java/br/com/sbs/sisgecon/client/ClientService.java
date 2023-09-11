package br.com.sbs.sisgecon.client;

import br.com.sbs.sisgecon.client.dto.ClientView;
import br.com.sbs.sisgecon.client.dto.NewClientForm;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public ClientView save(NewClientForm newClientForm) {
        Client client = clientRepository.save(newClientForm.toEntity());

        return new ClientView(client);
    }
}
