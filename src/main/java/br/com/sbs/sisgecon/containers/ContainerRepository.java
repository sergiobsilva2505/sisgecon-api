package br.com.sbs.sisgecon.containers;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ContainerRepository extends JpaRepository<Container, Long> {

    boolean existsByNumber(String number);

    boolean existsByNumberAndIdNot(String number, Long id);

    Optional<Container> findByNumber(String number);

    @Query(value = """
        SELECT category_container AS categoryContainer, count(id) AS quantityOfContainers
        FROM containers
        GROUP BY category_container;
    """, nativeQuery = true)
    List<ContainersProjection> getQuantityOfImportsAndExports();

}
