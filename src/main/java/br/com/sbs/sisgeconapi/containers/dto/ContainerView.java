package br.com.sbs.sisgeconapi.containers.dto;

import br.com.sbs.sisgeconapi.client.dto.ClientView;
import br.com.sbs.sisgeconapi.containers.Container;
import br.com.sbs.sisgeconapi.containers.enums.ContainerCategory;
import br.com.sbs.sisgeconapi.containers.enums.ContainerStatus;
import br.com.sbs.sisgeconapi.containers.enums.ContainerType;

public record ContainerView(Long id, String number, ContainerType containerType, ContainerStatus containerStatus, ContainerCategory containerCategory, ClientView client) {

    public ContainerView(Container container) {
        this(container.getId(), container.getNumber(), container.getTypeContainer(), container.getStatusContainer(), container.getCategoryContainer(), new ClientView(container.getClient()));
    }
}
