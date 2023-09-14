package br.com.sbs.sisgecon.containers;

import br.com.sbs.sisgecon.client.Client;
import br.com.sbs.sisgecon.containers.enums.CategoryContainer;
import br.com.sbs.sisgecon.containers.enums.StatusContainer;
import br.com.sbs.sisgecon.containers.enums.TypeContainer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
public class ContainerRepositoryTest {

    @Autowired
    private ContainerRepository containerRepository;
    
    @Autowired
    public TestEntityManager testEntityManager;

    @Test
    public void findByNumber__should_return_an_optional_when_the_container_number_is_found() {
        Client client = new Client("Lucca e Joana Entulhos ME", "48247711000191");
        Container container = new Container("ZZZU9876543", TypeContainer.TWENTY, StatusContainer.FULL, CategoryContainer.IMPORT, client);
        testEntityManager.persist(client);
        testEntityManager.persist(container);

        String number = "ZZZU9876543";
        Optional<Container> optional = containerRepository.findByNumber(number);

        assertThat(optional).isPresent();
        assertThat(optional.get().getNumber()).isEqualTo(container.getNumber());
    }

    @Test
    public void findByNumber__should_return_an_empty_optional_when_the_container_number_is_not_found() {
        Client client = new Client("Lucca e Joana Entulhos ME", "48247711000191");
        Container container = new Container("ZZZU9876543", TypeContainer.TWENTY, StatusContainer.FULL, CategoryContainer.IMPORT, client);
        testEntityManager.persist(client);
        testEntityManager.persist(container);

        String number = "ABCU9876543";
        Optional<Container> optional = containerRepository.findByNumber(number);

        assertThat(optional).isEmpty();
    }
}