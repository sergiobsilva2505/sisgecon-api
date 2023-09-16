package br.com.sbs.sisgeconapi.movement.dto;

import br.com.sbs.sisgeconapi.containers.Container;
import br.com.sbs.sisgeconapi.containers.enums.ContainerCategory;
import br.com.sbs.sisgeconapi.containers.enums.ContainerStatus;
import br.com.sbs.sisgeconapi.containers.enums.ContainerType;
import br.com.sbs.sisgeconapi.movement.Movement;
import br.com.sbs.sisgeconapi.movement.enums.MovementStatus;
import br.com.sbs.sisgeconapi.movement.enums.MovementType;

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
