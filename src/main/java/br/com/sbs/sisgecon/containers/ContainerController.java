package br.com.sbs.sisgecon.containers;

import br.com.sbs.sisgecon.containers.dto.ContainerView;
import br.com.sbs.sisgecon.containers.dto.ContainerWithMovementsView;
import br.com.sbs.sisgecon.containers.dto.NewContainerForm;
import br.com.sbs.sisgecon.containers.dto.UpdateContainerForm;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/containers")
public class ContainerController {

    private final ContainerService containerService;
    private final NewContainerFormValidator newContainerFormValidator;
    private final UpdateContainerFormValidator updateContainerFormValidator;

    public ContainerController(ContainerService containerService, NewContainerFormValidator newContainerFormValidator, UpdateContainerFormValidator updateContainerFormValidator) {
        this.containerService = containerService;
        this.newContainerFormValidator = newContainerFormValidator;
        this.updateContainerFormValidator = updateContainerFormValidator;
    }

    @InitBinder("newContainerForm")
    void initBinderNewContainerForm(WebDataBinder webDataBinder){
        webDataBinder.addValidators(newContainerFormValidator);
    }

    @InitBinder("updateContainerForm")
    void initBinderUpdateContainerForm(WebDataBinder webDataBinder){
        webDataBinder.addValidators(updateContainerFormValidator);
    }

    @PostMapping
    ResponseEntity<ContainerView> create(@Valid @RequestBody NewContainerForm newContainerForm) {
        ContainerView containerView = containerService.save(newContainerForm);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(containerView.id()).toUri();

        return ResponseEntity.created(uri).body(containerView);
    }

    @RequestMapping
    ResponseEntity<Page<ContainerView>> getAll(
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "size", defaultValue = "2") Integer size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        Page<ContainerView> containerView = containerService.findAll(pageRequest);

        return ResponseEntity.ok(containerView);
    }

    @RequestMapping("/{id}")
    ResponseEntity<ContainerView> getById(@PathVariable Long id) {
        ContainerView containerView = containerService.findById(id);

        return ResponseEntity.ok(containerView);
    }

    @PutMapping("/{id}")
    ResponseEntity<ContainerView> edit(@PathVariable Long id, @Valid @RequestBody UpdateContainerForm updateContainerForm) {
        ContainerView containerView = containerService.update(id, updateContainerForm);

        return ResponseEntity.ok(containerView);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Void> delete(@PathVariable Long id) {
        containerService.delete(id);

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{number}/movements")
    ResponseEntity<ContainerWithMovementsView> getMovementsByContainer(@PathVariable String number) {
        ContainerWithMovementsView container = containerService.findByContainer(number);

        return ResponseEntity.ok(container);
    }
}
