package br.com.sbs.sisgecon.containers;

import br.com.sbs.sisgecon.client.Client;
import br.com.sbs.sisgecon.containers.dto.NewContainerForm;
import br.com.sbs.sisgecon.containers.dto.UpdateContainerForm;
import br.com.sbs.sisgecon.containers.enums.CategoryContainer;
import br.com.sbs.sisgecon.containers.enums.StatusContainer;
import br.com.sbs.sisgecon.containers.enums.TypeContainer;
import jakarta.persistence.*;

@Entity
@Table(name="containers")
public class Container {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String number;

    @Enumerated(EnumType.STRING)
    private TypeContainer typeContainer;

    @Enumerated(EnumType.STRING)
    private StatusContainer statusContainer;

    @Enumerated(EnumType.STRING)
    private CategoryContainer categoryContainer;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    public Container() {
    }

    public Container(String number, TypeContainer typeContainer, StatusContainer statusContainer, CategoryContainer categoryContainer, Client client) {
        this.number = number;
        this.typeContainer = typeContainer;
        this.statusContainer = statusContainer;
        this.categoryContainer = categoryContainer;
        this.client = client;
    }

    public void toMerge(UpdateContainerForm updateContainerForm) {
        this.number = updateContainerForm.number();
        this.typeContainer = updateContainerForm.typeContainer();
        this.statusContainer = updateContainerForm.statusContainer();
        this.categoryContainer = updateContainerForm.categoryContainer();
    }

    public Long getId() {
        return id;
    }

    public String getNumber() {
        return number;
    }

    public TypeContainer getTypeContainer() {
        return typeContainer;
    }

    public StatusContainer getStatusContainer() {
        return statusContainer;
    }

    public CategoryContainer getCategoryContainer() {
        return categoryContainer;
    }

    public Client getClient() {
        return client;
    }
}