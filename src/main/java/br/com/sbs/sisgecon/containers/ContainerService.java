package br.com.sbs.sisgecon.containers;

import br.com.sbs.sisgecon.client.ClientRepository;
import br.com.sbs.sisgecon.client.ClientService;
import org.springframework.stereotype.Service;

@Service
public class ContainerService {

    private final ContainerRepository containerRepository;
    private final  ClientService clientService;

    public ContainerService(ContainerRepository containerRepository, ClientService clientService) {
        this.containerRepository = containerRepository;
        this.clientService = clientService;
    }
}
