package br.com.sbs.sisgeconapi.client;

import br.com.sbs.sisgeconapi.client.dto.ClientView;
import br.com.sbs.sisgeconapi.client.dto.NewClientForm;
import br.com.sbs.sisgeconapi.client.dto.UpdateClientForm;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientController {

    private final ClientService clientService;
    private final NewClientFormValidator newClientFormValidator;
    private final UpdateClientFormValidator updateClientFormValidator;

    public ClientController(ClientService clientService, NewClientFormValidator newClientFormValidator, UpdateClientFormValidator updateClientFormValidator) {
        this.clientService = clientService;
        this.newClientFormValidator = newClientFormValidator;
        this.updateClientFormValidator = updateClientFormValidator;
    }

    @InitBinder("newClientForm")
    void initBinderNewClientForm(WebDataBinder webDataBinder){
        webDataBinder.addValidators(newClientFormValidator);
    }

    @InitBinder("updateClientForm")
    void initBinderUpdateClientForm(WebDataBinder webDataBinder){
        webDataBinder.addValidators(updateClientFormValidator);
    }

    @PostMapping
    ResponseEntity<ClientView> create(@Valid @RequestBody NewClientForm newClientForm) {
        ClientView clientView = clientService.save(newClientForm);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(clientView.id()).toUri();

        return ResponseEntity.created(uri).body(clientView);
    }

    @GetMapping
    ResponseEntity<List<ClientView>> findAll() {
        List<ClientView> clients = clientService.findAll();

        return ResponseEntity.ok(clients);
    }

    @GetMapping("/{id}")
    ResponseEntity<ClientView> findById(@PathVariable Long id) {
        ClientView client = clientService.findById(id);

        return ResponseEntity.ok(client);
    }

    @PutMapping("/{id}")
    ResponseEntity<ClientView> update(@PathVariable Long id, @Valid @RequestBody UpdateClientForm updateClientForm) {
        ClientView clientView = clientService.update(id, updateClientForm);

        return ResponseEntity.ok(clientView);
    }
}
