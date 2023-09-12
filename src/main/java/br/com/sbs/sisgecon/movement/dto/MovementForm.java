package br.com.sbs.sisgecon.movement.dto;

import br.com.sbs.sisgecon.containers.Container;
import br.com.sbs.sisgecon.movement.Movement;
import br.com.sbs.sisgecon.movement.enums.TypeMovement;

public record MovementForm(TypeMovement typeMovement, Long containerId) {

    public Movement toEntity(Container container) {
        return new Movement(typeMovement, container);
    }
}
