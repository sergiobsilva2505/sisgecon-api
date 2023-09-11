package br.com.sbs.sisgecon.client;

import br.com.sbs.sisgecon.client.dto.ClientView;
import br.com.sbs.sisgecon.client.dto.NewClientForm;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/clients")
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping
    ResponseEntity<ClientView> create(@Valid @RequestBody NewClientForm newClientForm) {
        ClientView clientView = clientService.save(newClientForm);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(clientView.id()).toUri();

        return ResponseEntity.created(uri).body(clientView);
    }
}
