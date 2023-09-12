package br.com.sbs.sisgecon.containers;

import br.com.sbs.sisgecon.containers.dto.ContainerView;
import br.com.sbs.sisgecon.containers.dto.NewContainerForm;
import br.com.sbs.sisgecon.containers.dto.UpdateContainerForm;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/containers")
public class ContainerController {

    private final ContainerService containerService;

    public ContainerController(ContainerService containerService) {
        this.containerService = containerService;
    }

    @PostMapping
    ResponseEntity<ContainerView> create(@RequestBody NewContainerForm newContainerForm) {
        ContainerView containerView = containerService.save(newContainerForm);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(containerView.id()).toUri();

        return ResponseEntity.created(uri).body(containerView);
    }

    @RequestMapping
    ResponseEntity<List<ContainerView>> getAll() {
        List<ContainerView> containerView = containerService.findAll();

        return ResponseEntity.ok(containerView);

    }

    @RequestMapping("/{id}")
    ResponseEntity<ContainerView> getById(@PathVariable Long id) {
        ContainerView containerView = containerService.findById(id);

        return ResponseEntity.ok(containerView);

    }

    @PutMapping("/{id}")
    ResponseEntity<ContainerView> edit(@PathVariable Long id, @RequestBody UpdateContainerForm updateContainerForm) {
        ContainerView containerView = containerService.update(id, updateContainerForm);

        return ResponseEntity.ok(containerView);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Void> delete(@PathVariable Long id) {
        containerService.delete(id);

        return ResponseEntity.noContent().build();
    }




}
