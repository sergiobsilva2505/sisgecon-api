package br.com.sbs.sisgecon.movement.dto;

import br.com.sbs.sisgecon.containers.Container;
import br.com.sbs.sisgecon.movement.Movement;
import br.com.sbs.sisgecon.movement.enums.TypeMovement;
import jakarta.validation.constraints.NotNull;

public record MovementForm(@NotNull TypeMovement typeMovement,
                           @NotNull Long containerId) {

    public Movement toEntity(Container container) {
        return new Movement(typeMovement, container);
    }
}
