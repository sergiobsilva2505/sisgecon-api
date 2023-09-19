package br.com.sbs.sisgeconapi.client.dto;

import br.com.sbs.sisgeconapi.client.domain.Client;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.br.CNPJ;

public record NewClientForm(@NotBlank
                            String name,
                            @NotBlank
                            @CNPJ
                            String cnpj) {

    public Client toEntity() {
        return new Client(name, cnpj);
    }
}
