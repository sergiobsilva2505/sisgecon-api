package br.com.sbs.sisgecon.client.dto;

import br.com.sbs.sisgecon.client.Client;

public record ClientView(Long id, String name, String cnpj) {

    public ClientView(Client client) {
        this(client.getId(), client.getName(), client.getCnpj());
    }
}
