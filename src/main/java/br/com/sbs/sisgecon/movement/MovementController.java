package br.com.sbs.sisgecon.movement;

import br.com.sbs.sisgecon.movement.dto.MovementForm;
import br.com.sbs.sisgecon.movement.dto.MovementView;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/movements")
public class MovementController {

   private final MovementService movementService;

    public MovementController(MovementService movementService) {
        this.movementService = movementService;
    }

    @PostMapping
    ResponseEntity<MovementView> createMovement(@Valid @RequestBody MovementForm movementForm) {
        MovementView movementView =  movementService.create(movementForm);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(movementView.id()).toUri();

        return ResponseEntity.created(uri).body(movementView);
    }

    @GetMapping
    ResponseEntity<List<MovementView>> getAllMovements() {
        List<MovementView> movements =  movementService.findAll();

        return ResponseEntity.ok(movements);
    }

    @GetMapping("/{id}")
    ResponseEntity<MovementView> getById(@PathVariable Long id) {
        MovementView movementView =  movementService.findById(id);

        return ResponseEntity.ok(movementView);
    }

    @PutMapping("/{id}/finish")
    ResponseEntity<MovementView> finish(@PathVariable Long id) {
        MovementView movementView =  movementService.finish(id);

        return ResponseEntity.ok(movementView);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Void> delete(@PathVariable Long id) {
        movementService.delete(id);

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/report")
    ResponseEntity<List<MovementsProjection>> getReport() {
        List<MovementsProjection> movements =  movementService.getQuantityOfMovementsByTypeAndClient();

        return ResponseEntity.ok(movements);
    }
}
