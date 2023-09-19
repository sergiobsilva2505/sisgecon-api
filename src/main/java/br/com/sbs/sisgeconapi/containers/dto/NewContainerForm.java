package br.com.sbs.sisgeconapi.containers.dto;

import br.com.sbs.sisgeconapi.client.domain.Client;
import br.com.sbs.sisgeconapi.containers.Container;
import br.com.sbs.sisgeconapi.containers.enums.ContainerCategory;
import br.com.sbs.sisgeconapi.containers.enums.ContainerStatus;
import br.com.sbs.sisgeconapi.containers.enums.ContainerType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record NewContainerForm(@NotBlank
                               @Pattern(regexp = "[A-Z]{4}[0-9]{7}", message = "deve corresponder ao padrão (ABCU1234567)")
                               String number,
                               @NotNull
                               ContainerType containerType,
                               @NotNull
                               ContainerStatus containerStatus,
                               @NotNull
                               ContainerCategory containerCategory,
                               @NotNull
                               Long clientId) {

    public Container toEntity(Client client) {
        return new Container(number, containerType, containerStatus, containerCategory, client);
    }
}
