package br.com.sbs.sisgecon.movement.dto;

import br.com.sbs.sisgecon.containers.Container;
import br.com.sbs.sisgecon.containers.dto.ContainerView;
import br.com.sbs.sisgecon.containers.enums.CategoryContainer;
import br.com.sbs.sisgecon.containers.enums.StatusContainer;
import br.com.sbs.sisgecon.containers.enums.TypeContainer;
import br.com.sbs.sisgecon.movement.Movement;
import br.com.sbs.sisgecon.movement.enums.StatusMovement;
import br.com.sbs.sisgecon.movement.enums.TypeMovement;

import java.time.LocalDateTime;

public record MovementView(Long id,
                           TypeMovement typeMovement,
                           LocalDateTime initialDate,
                           LocalDateTime finishDate,
                           StatusMovement statusMovement,
                           String containerNumber,
                           TypeContainer typeContainer,
                           StatusContainer statusContainer,
                           CategoryContainer categoryContainer,
                           String clientName) {

    public MovementView(Movement movement, Container container) {
        this(movement.getId(), movement.getTypeMovement(), movement.getInitialDate(), movement.getFinishDate(), movement.getStatusMovement(), container.getNumber(), container.getTypeContainer(), container.getStatusContainer(), container.getCategoryContainer(), container.getClientName());
    }
}
