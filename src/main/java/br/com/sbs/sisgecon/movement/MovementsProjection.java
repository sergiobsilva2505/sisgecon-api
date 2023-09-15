package br.com.sbs.sisgecon.movement;

import br.com.sbs.sisgecon.movement.enums.MovementType;

public interface MovementsProjection {

    Integer getMovementsCount();
    MovementType getMovementType();
    String getClientName();

}
