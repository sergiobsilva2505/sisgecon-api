package br.com.sbs.sisgecon.containers.dto;

import br.com.sbs.sisgecon.client.Client;
import br.com.sbs.sisgecon.containers.Container;
import br.com.sbs.sisgecon.containers.enums.CategoryContainer;
import br.com.sbs.sisgecon.containers.enums.StatusContainer;
import br.com.sbs.sisgecon.containers.enums.TypeContainer;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record NewContainerForm(@NotBlank
                               @Pattern(regexp = "[A-Z]{4}[0-9]{7}")
                               String number,
                               @NotNull
                               TypeContainer typeContainer,
                               @NotNull
                               StatusContainer statusContainer,
                               @NotNull
                               CategoryContainer categoryContainer,
                               @NotNull
                               Long clientId) {

    public Container toEntity(Client client) {
        return new Container(number, typeContainer, statusContainer, categoryContainer, client);
    }
}
