package br.com.sbs.sisgecon.containers;

import br.com.sbs.sisgecon.client.ClientRepository;
import br.com.sbs.sisgecon.movement.MovementRepository;
import br.com.sbs.sisgecon.movement.MovementsProjection;
import br.com.sbs.sisgecon.util.ProgramingDatabaseMotherTest;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

import static br.com.sbs.sisgecon.containers.enums.CategoryContainer.EXPORT;
import static br.com.sbs.sisgecon.containers.enums.CategoryContainer.IMPORT;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.groups.Tuple.tuple;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
public class ContainerRepositoryTest {

    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private ContainerRepository containerRepository;
    @Autowired
    private MovementRepository movementRepository;

    @Before
    public void setUp() {
        ProgramingDatabaseMotherTest programingDatabaseMotherTest =
                new ProgramingDatabaseMotherTest(clientRepository, containerRepository, movementRepository);
        programingDatabaseMotherTest.create();
    }

    @Test
    public void existsByNumber__should_return_a_when_container_exists_or_not() {
        String number = "TEXU1234568";
        boolean exists = containerRepository.existsByNumber(number);

        assertThat(exists).isTrue();

        number = "TEXU0008111";
        exists = containerRepository.existsByNumber(number);

        assertThat(exists).isFalse();
    }

    @Test
    public void existsByNumberAndIdNot__should_return_true_when_container_already_exists() {

        boolean exists = containerRepository.existsByNumberAndIdNot("GAZU3698741", null);
        assertThat(exists).isFalse();

        exists = containerRepository.existsByNumberAndIdNot("GAZU3698741", 5L);
        assertThat(exists).isTrue();
    }

    @Test
    public void findByNumber__should_return_an_optional_when_the_container_number_is_found() {
        String number = "TEXU1234568";
        Optional<Container> optional = containerRepository.findByNumber(number);

        assertThat(optional).isPresent();
        assertThat(number).isEqualTo(optional.get().getNumber());

        number = "ABCU9876543";
        optional = containerRepository.findByNumber(number);

        assertThat(optional).isEmpty();
    }

    @Test
    public void getQuantityOfImportsAndExports__must_return_the_total_import_and_export_containers() {
        List<MovementsProjection> quantityOfImportsAndExports = movementRepository.getQuantityOfMovements();

        assertThat(quantityOfImportsAndExports).hasSize(2);
        assertThat(quantityOfImportsAndExports)
                .extracting(MovementsProjection::getClientName, MovementsProjection::getMovementsCount, MovementsProjection::getTypeMovement)
                .containsExactly(
                        tuple(IMPORT, 4),
                        tuple(EXPORT, 2)
                );
    }
}