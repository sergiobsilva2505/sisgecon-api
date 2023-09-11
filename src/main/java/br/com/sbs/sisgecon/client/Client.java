package br.com.sbs.sisgecon.client;

import jakarta.persistence.*;

@Entity
@Table(name = "clients")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 100)
    private String name;
    @Column(length = 14)
    private String cnpj;

    public Client() {
    }

    public Client(String name, String cnpj) {
        this.name = name;
        this.cnpj = cnpj;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCnpj() {
        return cnpj;
    }
}
