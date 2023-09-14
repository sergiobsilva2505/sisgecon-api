package br.com.sbs.sisgecon.movement;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovementRepository extends JpaRepository<Movement, Long> {

    List<Movement> findAllByContainerId(Long id);

    @Query(value = """
            SELECT COUNT(movement.id) movementsCount, movement.type_movement AS typeMovement, ci.name AS clientName
            FROM movements movement
                     JOIN containers container ON movement.container_id = container.id
                     JOIN clients ci ON container.client_id = ci.id
            GROUP BY movement.type_movement, container.client_id;
        """,nativeQuery = true)
    List<MovementsProjection> getQuantityOfMovements();

}
