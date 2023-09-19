package br.com.sbs.sisgeconapi.containers;

import br.com.sbs.sisgeconapi.client.domain.Client;
import br.com.sbs.sisgeconapi.containers.dto.UpdateContainerForm;
import br.com.sbs.sisgeconapi.containers.enums.ContainerCategory;
import br.com.sbs.sisgeconapi.containers.enums.ContainerStatus;
import br.com.sbs.sisgeconapi.containers.enums.ContainerType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name="containers")
public class Container {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Pattern(regexp = "[A-Z]{4}[0-9]{7}", message = "deve corresponder ao padrão (ABCU1234567)")
    private String number;

    @NotNull
    @Enumerated(EnumType.STRING)
    private ContainerType containerType;

    @NotNull
    @Enumerated(EnumType.STRING)
    private ContainerStatus containerStatus;

    @NotNull
    @Enumerated(EnumType.STRING)
    private ContainerCategory containerCategory;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    public Container() {
    }

    public Container(String number, ContainerType containerType, ContainerStatus containerStatus, ContainerCategory containerCategory, Client client) {
        this.number = number;
        this.containerType = containerType;
        this.containerStatus = containerStatus;
        this.containerCategory = containerCategory;
        this.client = client;
    }

    public void toMerge(UpdateContainerForm updateContainerForm) {
        this.number = updateContainerForm.number();
        this.containerType = updateContainerForm.containerType();
        this.containerStatus = updateContainerForm.containerStatus();
        this.containerCategory = updateContainerForm.containerCategory();
    }

    public Long getId() {
        return id;
    }

    public String getNumber() {
        return number;
    }

    public ContainerType getTypeContainer() {
        return containerType;
    }

    public ContainerStatus getStatusContainer() {
        return containerStatus;
    }

    public ContainerCategory getCategoryContainer() {
        return containerCategory;
    }

    public Client getClient() {
        return client;
    }

    public String getClientName() {
        return client.getName();
    }
}
