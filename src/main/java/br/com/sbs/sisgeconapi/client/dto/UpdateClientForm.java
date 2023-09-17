package br.com.sbs.sisgeconapi.client.dto;

import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.br.CNPJ;

public record UpdateClientForm(Long id,
                               @NotBlank
                               String name,
                               @NotBlank
                               @CNPJ
                               String cnpj) {

}
