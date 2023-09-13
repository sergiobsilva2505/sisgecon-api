package br.com.sbs.sisgecon.containers;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ContainerRepository extends JpaRepository<Container, Long> {

    boolean existsByNumber(String number);

    boolean existsByNumberAndIdNot(String number, Long id);

    Optional<Container> findByNumber(String number);

}
