package br.com.sbs.sisgecon.movement;

import br.com.sbs.sisgecon.movement.enums.TypeMovement;

public interface MovementsProjection {

    Integer getMovementsCount();
    TypeMovement getTypeMovement();
    String getClientName();

}
