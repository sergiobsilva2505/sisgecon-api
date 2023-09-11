package br.com.sbs.sisgecon.client;

import br.com.sbs.sisgecon.client.dto.ClientView;
import br.com.sbs.sisgecon.client.dto.NewClientForm;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
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

    public ClientController(ClientService clientService, NewClientFormValidator newClientFormValidator) {
        this.clientService = clientService;
        this.newClientFormValidator = newClientFormValidator;
    }

    @InitBinder("newClientForm")
    void initBinderNewClientForm(WebDataBinder webDataBinder){
        webDataBinder.addValidators(newClientFormValidator);
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
}
