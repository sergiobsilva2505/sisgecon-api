package br.com.sbs.sisgeconapi.movement.dto;

import br.com.sbs.sisgeconapi.containers.Container;
import br.com.sbs.sisgeconapi.movement.Movement;
import br.com.sbs.sisgeconapi.movement.enums.MovementType;
import jakarta.validation.constraints.NotNull;

public record MovementForm(@NotNull MovementType movementType,
                           @NotNull Long containerId) {

    public Movement toEntity(Container container) {
        return new Movement(movementType, container);
    }
}
