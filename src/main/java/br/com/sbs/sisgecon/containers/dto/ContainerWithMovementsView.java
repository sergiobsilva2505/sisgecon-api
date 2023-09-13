package br.com.sbs.sisgecon.containers.dto;

import br.com.sbs.sisgecon.containers.Container;
import br.com.sbs.sisgecon.containers.enums.CategoryContainer;
import br.com.sbs.sisgecon.containers.enums.StatusContainer;
import br.com.sbs.sisgecon.containers.enums.TypeContainer;
import br.com.sbs.sisgecon.movement.dto.MovementViewByContainer;

import java.util.List;

public record ContainerWithMovementsView(Long id, String number, TypeContainer typeContainer, StatusContainer statusContainer, CategoryContainer categoryContainer, List<MovementViewByContainer> movements) {

    public ContainerWithMovementsView(Container container, List<MovementViewByContainer> movements) {
        this(container.getId(), container.getNumber(), container.getTypeContainer(), container.getStatusContainer(), container.getCategoryContainer(), movements);
    }
}


