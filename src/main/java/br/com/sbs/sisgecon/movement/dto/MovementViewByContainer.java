package br.com.sbs.sisgecon.movement.dto;

import br.com.sbs.sisgecon.movement.Movement;
import br.com.sbs.sisgecon.movement.enums.StatusMovement;
import br.com.sbs.sisgecon.movement.enums.TypeMovement;

import java.time.LocalDateTime;

public record MovementViewByContainer(Long id,
                                      TypeMovement typeMovement,
                                      LocalDateTime initialDate,
                                      LocalDateTime finishDate,
                                      StatusMovement statusMovement) {

    public MovementViewByContainer(Movement movement) {
        this(movement.getId(), movement.getTypeMovement(), movement.getInitialDate(), movement.getFinishDate(), movement.getStatusMovement());
    }
}
