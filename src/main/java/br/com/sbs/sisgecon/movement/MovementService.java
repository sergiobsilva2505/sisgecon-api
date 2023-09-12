package br.com.sbs.sisgecon.movement;

import br.com.sbs.sisgecon.containers.Container;
import br.com.sbs.sisgecon.containers.ContainerRepository;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import org.springframework.stereotype.Service;

@Service
public class MovementService {

    private final MovementRepository movementRepository;
    private final ContainerRepository containerRepository;

    public MovementService(MovementRepository movementRepository, ContainerRepository containerRepository) {
        this.movementRepository = movementRepository;
        this.containerRepository = containerRepository;
    }
}
