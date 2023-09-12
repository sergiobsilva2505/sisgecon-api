package br.com.sbs.sisgecon.containers;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContainerRepository extends JpaRepository<Container, Long> {

    boolean existsByNumber(String number);
}
