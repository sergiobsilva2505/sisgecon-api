package br.com.sbs.sisgecon.client.dto;

import br.com.sbs.sisgecon.client.Client;

public record NewClientForm(String name, String cnpj) {

    public Client toEntity() {
        return new Client(name, cnpj);
    }
}
