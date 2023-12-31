package br.com.sbs.sisgeconapi.movement.dto;

import br.com.sbs.sisgeconapi.movement.Movement;
import br.com.sbs.sisgeconapi.movement.enums.MovementStatus;
import br.com.sbs.sisgeconapi.movement.enums.MovementType;

import java.time.LocalDateTime;

public record MovementViewByContainer(Long id,
                                      MovementType movementType,
                                      LocalDateTime initialDate,
                                      LocalDateTime finishDate,
                                      MovementStatus movementStatus) {

    public MovementViewByContainer(Movement movement) {
        this(movement.getId(), movement.getTypeMovement(), movement.getInitialDate(), movement.getFinishDate(), movement.getStatusMovement());
    }
}
