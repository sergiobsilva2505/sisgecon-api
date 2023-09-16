package br.com.sbs.sisgeconapi.movement;

import br.com.sbs.sisgeconapi.movement.enums.MovementType;

public interface MovementsProjection {

    Integer getMovementsCount();
    MovementType getMovementType();
    String getClientName();

}
