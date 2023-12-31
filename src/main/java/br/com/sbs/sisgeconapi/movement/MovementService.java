package br.com.sbs.sisgeconapi.movement;

import br.com.sbs.sisgeconapi.containers.Container;
import br.com.sbs.sisgeconapi.containers.ContainerRepository;
import br.com.sbs.sisgeconapi.containers.ContainersProjection;
import br.com.sbs.sisgeconapi.exception.ControllerNotFoundException;
import br.com.sbs.sisgeconapi.movement.dto.MovementForm;
import br.com.sbs.sisgeconapi.movement.dto.MovementView;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
    public Page<MovementView> findAll(PageRequest pageRequest) {

        Page<Movement> movements = movementRepository.findAll(pageRequest);

        return movements.map(movement -> new MovementView(movement, movement.getContainer()));
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
