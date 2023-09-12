package br.com.sbs.sisgecon.movement;

import br.com.sbs.sisgecon.containers.Container;
import br.com.sbs.sisgecon.movement.enums.StatusMovement;
import br.com.sbs.sisgecon.movement.enums.TypeMovement;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "movements")
public class Movement {

    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private TypeMovement typeMovement;

    private LocalDateTime initialDate;
    private LocalDateTime finishDate;
    @Enumerated(EnumType.STRING)
    private StatusMovement statusMovement;

    @ManyToOne
    @JoinColumn(name = "container_id")
    private Container container;

    @Deprecated
    public Movement() {
    }

    public Movement(TypeMovement typeMovement, Container container) {
        this.typeMovement = typeMovement;
        this.initialDate = LocalDateTime.now();
        this.finishDate = null;
        this.statusMovement = StatusMovement.IN_PROGRESS;
        this.container = container;
    }

    public Long getId() {
        return id;
    }

    public TypeMovement getTypeMovement() {
        return typeMovement;
    }

    public LocalDateTime getInitialDate() {
        return initialDate;
    }

    public LocalDateTime getFinishDate() {
        return finishDate;
    }

    public StatusMovement getStatusMovement() {
        return statusMovement;
    }

    public Container getContainer() {
        return container;
    }
}
