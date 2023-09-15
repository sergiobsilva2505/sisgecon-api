package br.com.sbs.sisgecon.movement.dto;

import br.com.sbs.sisgecon.containers.Container;
import br.com.sbs.sisgecon.containers.enums.ContainerCategory;
import br.com.sbs.sisgecon.containers.enums.ContainerStatus;
import br.com.sbs.sisgecon.containers.enums.ContainerType;
import br.com.sbs.sisgecon.movement.Movement;
import br.com.sbs.sisgecon.movement.enums.MovementStatus;
import br.com.sbs.sisgecon.movement.enums.MovementType;

import java.time.LocalDateTime;

public record MovementView(Long id,
                           MovementType movementType,
                           LocalDateTime initialDate,
                           LocalDateTime finishDate,
                           MovementStatus movementStatus,
                           String containerNumber,
                           ContainerType containerType,
                           ContainerStatus containerStatus,
                           ContainerCategory containerCategory,
                           String clientName) {

    public MovementView(Movement movement, Container container) {
        this(movement.getId(), movement.getTypeMovement(), movement.getInitialDate(), movement.getFinishDate(),
                movement.getStatusMovement(), container.getNumber(), container.getTypeContainer(), container.getStatusContainer(), container.getCategoryContainer(), container.getClientName());
    }
}
