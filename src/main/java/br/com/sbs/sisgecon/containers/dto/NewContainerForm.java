package br.com.sbs.sisgecon.containers.dto;

import br.com.sbs.sisgecon.client.Client;
import br.com.sbs.sisgecon.containers.Container;
import br.com.sbs.sisgecon.containers.enums.CategoryContainer;
import br.com.sbs.sisgecon.containers.enums.StatusContainer;
import br.com.sbs.sisgecon.containers.enums.TypeContainer;

public record NewContainerForm(String number, TypeContainer typeContainer, StatusContainer statusContainer, CategoryContainer categoryContainer, Long clientId) {

    public Container toEntity(Client client) {
        return new Container(number, typeContainer, statusContainer, categoryContainer, client);
    }
}
