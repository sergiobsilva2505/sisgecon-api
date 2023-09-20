package br.com.sbs.sisgeconapi.containers;

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
        SELECT container_category AS containerCategory, count(id) AS quantityOfContainers
        FROM containers
        GROUP BY container_category;
    """, nativeQuery = true)
    List<ContainersProjection> getQuantityOfImportsAndExports();

//    TODO: https://www.youtube.com/watch?v=l5B0jidJPOo&ab_channel=AlgaWorks

}
