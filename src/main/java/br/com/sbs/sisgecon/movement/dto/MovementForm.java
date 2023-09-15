package br.com.sbs.sisgecon.movement.dto;

import br.com.sbs.sisgecon.containers.Container;
import br.com.sbs.sisgecon.movement.Movement;
import br.com.sbs.sisgecon.movement.enums.MovementType;
import jakarta.validation.constraints.NotNull;

public record MovementForm(@NotNull MovementType movementType,
                           @NotNull Long containerId) {

    public Movement toEntity(Container container) {
        return new Movement(movementType, container);
    }
}
