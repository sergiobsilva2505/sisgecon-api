package br.com.sbs.sisgecon.movement;

import br.com.sbs.sisgecon.containers.Container;
import br.com.sbs.sisgecon.containers.ContainerRepository;
import br.com.sbs.sisgecon.containers.ContainersProjection;
import br.com.sbs.sisgecon.exception.ControllerNotFoundException;
import br.com.sbs.sisgecon.movement.dto.MovementForm;
import br.com.sbs.sisgecon.movement.dto.MovementView;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

    @Transactional(readOnly = true)
    public List<MovementView> findAll() {

        List<Movement> movements = movementRepository.findAll();

        return movements.stream()
                .map(movement -> new MovementView(movement, movement.getContainer()))
                .toList();
    }

    @Transactional(readOnly = true)
    public MovementView findById(Long id) {
        Movement movement = movementRepository.findById(id)
                .orElseThrow(() -> new ControllerNotFoundException("Movimentação não encontrada, id:%d".formatted(id)));

        return new MovementView(movement, movement.getContainer());
    }

    @Transactional
    public MovementView finish(Long id) {
        Movement movement = movementRepository.findById(id)
                .orElseThrow(() -> new ControllerNotFoundException("Movimentação não encontrada, id:%d".formatted(id)));
        movement.finish();

        return new MovementView(movement, movement.getContainer());
    }

    public void delete(Long id) {
        Movement movement = movementRepository.findById(id)
                .orElseThrow(() -> new ControllerNotFoundException("Movimentação não encontrada, id:%d".formatted(id)));

        movementRepository.delete(movement);
    }

    public MovementsReport buildReport() {
        List<ContainersProjection> quantityOfImportsAndExports = containerRepository.getQuantityOfImportsAndExports();
        List<MovementsProjection> quantityOfMovements = movementRepository.getQuantityOfMovements();

        return new MovementsReport(quantityOfImportsAndExports, quantityOfMovements);
    }
}
