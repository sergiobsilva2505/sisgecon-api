package br.com.sbs.sisgeconapi.client;

import br.com.sbs.sisgeconapi.client.dto.UpdateClientForm;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.br.CNPJ;

@Entity
@Table(name = "clients")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Column(length = 100)
    private String name;

    @NotBlank
    @Column(length = 14)
    @CNPJ
    private String cnpj;

    public Client() {
    }

    public Client(String name, String cnpj) {
        this.name = name;
        this.cnpj = cnpj;
    }

    public void merge(UpdateClientForm updateClientForm) {
        this.name = updateClientForm.name();
        this.cnpj = updateClientForm.cnpj();
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
