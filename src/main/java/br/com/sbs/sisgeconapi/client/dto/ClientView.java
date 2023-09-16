package br.com.sbs.sisgeconapi.client.dto;

import br.com.sbs.sisgeconapi.client.Client;

public record ClientView(Long id, String name, String cnpj) {

    public ClientView(Client client) {
        this(client.getId(), client.getName(), client.getCnpj());
    }
}
