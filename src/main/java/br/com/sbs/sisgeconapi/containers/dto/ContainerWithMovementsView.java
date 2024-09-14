package br.com.sbs.sisgeconapi.containers.dto;

import br.com.sbs.sisgeconapi.containers.Container;
import br.com.sbs.sisgeconapi.containers.enums.ContainerCategory;
import br.com.sbs.sisgeconapi.containers.enums.ContainerStatus;
import br.com.sbs.sisgeconapi.containers.enums.ContainerType;
import br.com.sbs.sisgeconapi.movement.dto.MovementViewByContainer;

import java.util.List;

public record ContainerWithMovementsView(Long id, String number, ContainerType containerType,
                                         ContainerStatus containerStatus, ContainerCategory containerCategory,
                                         List<MovementViewByContainer> movements) {

    public ContainerWithMovementsView(Container container, List<MovementViewByContainer> movements) {
        this(container.getId(), container.getNumber(), container.getTypeContainer(), container.getStatusContainer(), container.getCategoryContainer(), movements);
    }
}


