package br.com.sbs.sisgeconapi.movement;

import br.com.sbs.sisgeconapi.containers.Container;
import br.com.sbs.sisgeconapi.movement.enums.MovementStatus;
import br.com.sbs.sisgeconapi.movement.enums.MovementType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

@Entity
@Table(name = "movements")
public class Movement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @NotNull
    private MovementType movementType;

    private LocalDateTime initialDate;
    private LocalDateTime finishDate;

    @Enumerated(EnumType.STRING)
    private MovementStatus movementStatus;

    @ManyToOne
    @JoinColumn(name = "container_id")
    @NotNull
    private Container container;

    @Deprecated
    public Movement() {
    }

    public Movement(MovementType movementType, LocalDateTime initialDate, LocalDateTime finishDate, MovementStatus movementStatus, Container container) {
        this.movementType = movementType;
        this.initialDate = initialDate;
        this.finishDate = finishDate;
        this.movementStatus = movementStatus;
        this.container = container;
    }

    public Movement(MovementType movementType, Container container) {
        this.movementType = movementType;
        this.initialDate = LocalDateTime.now();
        this.finishDate = null;
        this.movementStatus = MovementStatus.IN_PROGRESS;
        this.container = container;
    }

    public void finish() {
        this.finishDate = LocalDateTime.now();
        this.movementStatus = MovementStatus.FINISHED;
    }

    public Long getId() {
        return id;
    }

    public MovementType getTypeMovement() {
        return movementType;
    }

    public LocalDateTime getInitialDate() {
        return initialDate;
    }

    public LocalDateTime getFinishDate() {
        return finishDate;
    }

    public MovementStatus getStatusMovement() {
        return movementStatus;
    }

    public Container getContainer() {
        return container;
    }
}
