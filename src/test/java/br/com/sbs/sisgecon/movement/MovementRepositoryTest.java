package br.com.sbs.sisgecon.movement;

import br.com.sbs.sisgecon.client.ClientRepository;
import br.com.sbs.sisgecon.containers.ContainerRepository;
import br.com.sbs.sisgecon.movement.enums.TypeMovement;
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

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.groups.Tuple.tuple;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
public class MovementRepositoryTest {

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
    public void getQuantityOfMovements() {

        List<MovementsProjection> quantityOfMovements = movementRepository.getQuantityOfMovements();

//        assertThat(quantityOfMovements)
//                .extracting(ContainersProjection::getCategoryContainer, ContainersProjection::getQuantityOfContainers)
//                .containsAnyOf(
//                        tuple(IMPORT, 8),
//                        tuple(EXPORT, 2)
//                );
    }
}