package br.com.sbs.sisgecon.containers.dto;

import br.com.sbs.sisgecon.containers.Container;
import br.com.sbs.sisgecon.containers.enums.ContainerCategory;
import br.com.sbs.sisgecon.containers.enums.ContainerStatus;
import br.com.sbs.sisgecon.containers.enums.ContainerType;
import br.com.sbs.sisgecon.movement.dto.MovementViewByContainer;

import java.util.List;

public record ContainerWithMovementsView(Long id, String number, ContainerType containerType, ContainerStatus containerStatus, ContainerCategory containerCategory, List<MovementViewByContainer> movements) {

    public ContainerWithMovementsView(Container container, List<MovementViewByContainer> movements) {
        this(container.getId(), container.getNumber(), container.getTypeContainer(), container.getStatusContainer(), container.getCategoryContainer(), movements);
    }
}


