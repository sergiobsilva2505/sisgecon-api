package br.com.sbs.sisgecon.containers.dto;

import br.com.sbs.sisgecon.client.dto.ClientView;
import br.com.sbs.sisgecon.containers.Container;
import br.com.sbs.sisgecon.containers.enums.CategoryContainer;
import br.com.sbs.sisgecon.containers.enums.StatusContainer;
import br.com.sbs.sisgecon.containers.enums.TypeContainer;

public record ContainerView(Long id, String number, TypeContainer typeContainer, StatusContainer statusContainer, CategoryContainer categoryContainer, ClientView client) {

    public ContainerView(Container container) {
        this(container.getId(), container.getNumber(), container.getTypeContainer(), container.getStatusContainer(), container.getCategoryContainer(), new ClientView(container.getClient()));
    }
}
