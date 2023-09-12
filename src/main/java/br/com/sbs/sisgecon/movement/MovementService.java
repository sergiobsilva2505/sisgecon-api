package br.com.sbs.sisgecon.movement;

import br.com.sbs.sisgecon.containers.Container;
import br.com.sbs.sisgecon.containers.ContainerRepository;
import br.com.sbs.sisgecon.exception.ControllerNotFoundException;
import br.com.sbs.sisgecon.movement.dto.MovementForm;
import br.com.sbs.sisgecon.movement.dto.MovementView;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MovementService {

    private final MovementRepository movementRepository;
    private final ContainerRepository containerRepository;

    public MovementService(MovementRepository movementRepository, ContainerRepository containerRepository) {
        this.movementRepository = movementRepository;
        this.containerRepository = containerRepository;
    }

    @Transactional
    public MovementView create(MovementForm movementForm) {
        Container container = containerRepository.findById(movementForm.containerId())
                .orElseThrow(() -> new ControllerNotFoundException("Container não encontrado, id:%d".formatted(movementForm.containerId())));

        Movement movement = movementForm.toEntity(container);
        movement = movementRepository.save(movement);

        return new MovementView(movement, container);
    }

    @Transactional
    public MovementView finish(Long id) {
        Movement movement = movementRepository.findById(id)
                .orElseThrow(() -> new ControllerNotFoundException("Container não encontrado, id:%d".formatted(id)));
        movement.finish();

        return new MovementView(movement, movement.getContainer());
    }
}
