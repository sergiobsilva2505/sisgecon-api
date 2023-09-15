package br.com.sbs.sisgecon.util;

import br.com.sbs.sisgecon.client.Client;
import br.com.sbs.sisgecon.client.ClientRepository;
import br.com.sbs.sisgecon.containers.Container;
import br.com.sbs.sisgecon.containers.ContainerRepository;
import br.com.sbs.sisgecon.containers.enums.CategoryContainer;
import br.com.sbs.sisgecon.containers.enums.StatusContainer;
import br.com.sbs.sisgecon.containers.enums.TypeContainer;
import br.com.sbs.sisgecon.movement.Movement;
import br.com.sbs.sisgecon.movement.MovementRepository;
import br.com.sbs.sisgecon.movement.enums.StatusMovement;
import br.com.sbs.sisgecon.movement.enums.TypeMovement;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

public class ProgramingDatabaseMotherTest {

    private ClientRepository clientRepository;
    private ContainerRepository containerRepository;
    private MovementRepository movementRepository;


    public ProgramingDatabaseMotherTest(ClientRepository clientRepository, ContainerRepository containerRepository, MovementRepository movementRepository) {
        this.clientRepository = clientRepository;
        this.containerRepository = containerRepository;
        this.movementRepository = movementRepository;
        this.clientRepository.deleteAll();
        this.containerRepository.deleteAll();
        this.movementRepository.deleteAll();
    }

    public void create() {
        Client daniel = new Client("Daniel e Heitor Telecomunicações ME", "71089937000123");
        Client caleb = new Client("Caleb e Rayssa Adega ME", "95550187000103");
        Client cesar = new Client("César e Pedro Henrique Casa Noturna Ltda", "24913521000106");
        clientRepository.saveAll(Arrays.asList(daniel, caleb, cesar));

        Container container1 = new Container("TEXU1234568", TypeContainer.TWENTY, StatusContainer.FULL, CategoryContainer.IMPORT, caleb);
        Container container2 = new Container("CAXU4568524", TypeContainer.FORTY, StatusContainer.EMPTY, CategoryContainer.EXPORT, daniel);
        Container container3 = new Container("TEMU9871236", TypeContainer.TWENTY, StatusContainer.FULL, CategoryContainer.IMPORT, cesar);
        Container container4 = new Container("ASFU7539510", TypeContainer.TWENTY, StatusContainer.EMPTY, CategoryContainer.IMPORT, caleb);
        Container container5 = new Container("GAZU3698741", TypeContainer.TWENTY, StatusContainer.FULL, CategoryContainer.IMPORT, daniel);
        Container container6 = new Container("FSCU8271936", TypeContainer.TWENTY, StatusContainer.FULL, CategoryContainer.EXPORT, caleb);
        containerRepository.saveAll(
                Arrays.asList(container1, container2, container3, container4, container5, container6));

        List<Movement> movements = List.of(
                new Movement(TypeMovement.GATE_IN, LocalDateTime.of(2023, 9, 12, 20, 37, 58), LocalDateTime.of(2023, 9, 12, 20, 37, 58), StatusMovement.FINISHED, container1),
                new Movement(TypeMovement.GATE_IN, LocalDateTime.of(2023, 9, 12, 20, 37, 58), LocalDateTime.of(2023, 9, 12, 20, 37, 58), StatusMovement.FINISHED, container2),
                new Movement(TypeMovement.GATE_IN, LocalDateTime.of(2023, 9, 12, 20, 37, 58), LocalDateTime.of(2023, 9, 12, 20, 37, 58), StatusMovement.FINISHED, container3),
                new Movement(TypeMovement.GATE_IN, LocalDateTime.of(2023, 9, 12, 20, 37, 58), LocalDateTime.of(2023, 9, 12, 20, 37, 58), StatusMovement.FINISHED, container4),
                new Movement(TypeMovement.GATE_IN, LocalDateTime.of(2023, 9, 12, 20, 37, 58), LocalDateTime.of(2023, 9, 12, 20, 37, 58), StatusMovement.FINISHED, container5),
                new Movement(TypeMovement.GATE_IN, LocalDateTime.of(2023, 9, 12, 20, 37, 58), LocalDateTime.of(2023, 9, 12, 20, 37, 58), StatusMovement.FINISHED, container6),
                new Movement(TypeMovement.GATE_OUT, LocalDateTime.of(2023, 2, 12, 15, 27, 58), LocalDateTime.of(2023, 2, 12, 19, 45, 58), StatusMovement.FINISHED, container1),
                new Movement(TypeMovement.GATE_OUT, LocalDateTime.of(2023, 2, 12, 15, 27, 58), LocalDateTime.of(2023, 2, 12, 19, 45, 58), StatusMovement.FINISHED, container2),
                new Movement(TypeMovement.GATE_OUT, LocalDateTime.of(2023, 2, 12, 15, 27, 58), LocalDateTime.of(2023, 2, 12, 19, 45, 58), StatusMovement.FINISHED, container3),
                new Movement(TypeMovement.GATE_OUT, LocalDateTime.of(2023, 2, 12, 15, 27, 58), LocalDateTime.of(2023, 2, 12, 19, 45, 58), StatusMovement.FINISHED, container4),
                new Movement(TypeMovement.GATE_OUT, LocalDateTime.of(2023, 2, 12, 15, 27, 58), LocalDateTime.of(2023, 2, 12, 19, 45, 58), StatusMovement.FINISHED, container5),
                new Movement(TypeMovement.GATE_OUT, LocalDateTime.of(2023, 2, 12, 15, 27, 58), LocalDateTime.of(2023, 2, 12, 19, 45, 58), StatusMovement.FINISHED, container6),
                new Movement(TypeMovement.REPOSITIONING, LocalDateTime.of(2023, 2, 12, 15, 27, 58), LocalDateTime.of(2023, 2, 12, 19, 45, 58), StatusMovement.FINISHED, container1),
                new Movement(TypeMovement.REPOSITIONING, LocalDateTime.of(2023, 2, 12, 15, 27, 58), LocalDateTime.of(2023, 2, 12, 19, 45, 58), StatusMovement.FINISHED, container2),
                new Movement(TypeMovement.REPOSITIONING, LocalDateTime.of(2023, 2, 12, 15, 27, 58), LocalDateTime.of(2023, 2, 12, 19, 45, 58), StatusMovement.FINISHED, container3),
                new Movement(TypeMovement.REPOSITIONING, LocalDateTime.of(2023, 2, 12, 15, 27, 58), LocalDateTime.of(2023, 2, 12, 19, 45, 58), StatusMovement.FINISHED, container4),
                new Movement(TypeMovement.REPOSITIONING, LocalDateTime.of(2023, 2, 12, 15, 27, 58), LocalDateTime.of(2023, 2, 12, 19, 45, 58), StatusMovement.FINISHED, container5),
                new Movement(TypeMovement.REPOSITIONING, LocalDateTime.of(2023, 2, 12, 15, 27, 58), LocalDateTime.of(2023, 2, 12, 19, 45, 58), StatusMovement.FINISHED, container6),
                new Movement(TypeMovement.IN_WEIGHING, LocalDateTime.of(2023, 9, 12, 20, 37, 58), LocalDateTime.of(2023, 9, 12, 21, 45, 58), StatusMovement.FINISHED, container1),
                new Movement(TypeMovement.IN_WEIGHING, LocalDateTime.of(2023, 9, 12, 20, 37, 58), LocalDateTime.of(2023, 9, 12, 21, 45, 58), StatusMovement.FINISHED, container2),
                new Movement(TypeMovement.IN_WEIGHING, LocalDateTime.of(2023, 9, 12, 20, 37, 58), LocalDateTime.of(2023, 9, 12, 21, 45, 58), StatusMovement.FINISHED, container3),
                new Movement(TypeMovement.IN_WEIGHING, LocalDateTime.of(2023, 9, 12, 20, 37, 58), LocalDateTime.of(2023, 9, 12, 21, 45, 58), StatusMovement.FINISHED, container4),
                new Movement(TypeMovement.IN_WEIGHING, LocalDateTime.of(2023, 9, 12, 20, 37, 58), LocalDateTime.of(2023, 9, 12, 21, 45, 58), StatusMovement.FINISHED, container5),
                new Movement(TypeMovement.IN_WEIGHING, LocalDateTime.of(2023, 9, 12, 20, 37, 58), LocalDateTime.of(2023, 9, 12, 21, 45, 58), StatusMovement.FINISHED, container6),
                new Movement(TypeMovement.OUT_WEIGHING, LocalDateTime.of(2023, 9, 13, 9, 37, 58), LocalDateTime.of(2023, 9, 13, 10, 45, 58), StatusMovement.FINISHED, container1),
                new Movement(TypeMovement.OUT_WEIGHING, LocalDateTime.of(2023, 9, 13, 9, 37, 58), LocalDateTime.of(2023, 9, 13, 10, 45, 58), StatusMovement.FINISHED, container2),
                new Movement(TypeMovement.OUT_WEIGHING, LocalDateTime.of(2023, 9, 13, 9, 37, 58), LocalDateTime.of(2023, 9, 13, 10, 45, 58), StatusMovement.FINISHED, container3),
                new Movement(TypeMovement.OUT_WEIGHING, LocalDateTime.of(2023, 9, 13, 9, 37, 58), LocalDateTime.of(2023, 9, 13, 10, 45, 58), StatusMovement.FINISHED, container4),
                new Movement(TypeMovement.OUT_WEIGHING, LocalDateTime.of(2023, 9, 13, 9, 37, 58), LocalDateTime.of(2023, 9, 13, 10, 45, 58), StatusMovement.FINISHED, container5),
                new Movement(TypeMovement.OUT_WEIGHING, LocalDateTime.of(2023, 9, 13, 9, 37, 58), LocalDateTime.of(2023, 9, 13, 10, 45, 58), StatusMovement.FINISHED, container6),
                new Movement(TypeMovement.SCANNER, LocalDateTime.of(2023, 2, 12, 11, 27, 58), LocalDateTime.of(2023, 2, 12, 11, 45, 58), StatusMovement.FINISHED, container1),
                new Movement(TypeMovement.SCANNER, LocalDateTime.of(2023, 2, 12, 11, 27, 58), LocalDateTime.of(2023, 2, 12, 11, 45, 58), StatusMovement.FINISHED, container2),
                new Movement(TypeMovement.SCANNER, LocalDateTime.of(2023, 2, 12, 11, 27, 58), LocalDateTime.of(2023, 2, 12, 11, 45, 58), StatusMovement.FINISHED, container3),
                new Movement(TypeMovement.SCANNER, LocalDateTime.of(2023, 2, 12, 11, 27, 58), LocalDateTime.of(2023, 2, 12, 11, 45, 58), StatusMovement.FINISHED, container4),
                new Movement(TypeMovement.SCANNER, LocalDateTime.of(2023, 2, 12, 11, 27, 58), LocalDateTime.of(2023, 2, 12, 11, 45, 58), StatusMovement.FINISHED, container5),
                new Movement(TypeMovement.SCANNER, LocalDateTime.of(2023, 2, 12, 11, 27, 58), LocalDateTime.of(2023, 2, 12, 11, 45, 58), StatusMovement.FINISHED, container6),
                new Movement(TypeMovement.LOADING, LocalDateTime.of(2023, 2, 12, 15, 27, 58), LocalDateTime.of(2023, 2, 12, 19, 45, 58), StatusMovement.FINISHED, container1),
                new Movement(TypeMovement.LOADING, LocalDateTime.of(2023, 2, 12, 15, 27, 58), LocalDateTime.of(2023, 2, 12, 19, 45, 58), StatusMovement.FINISHED, container2),
                new Movement(TypeMovement.LOADING, LocalDateTime.of(2023, 2, 12, 15, 27, 58), LocalDateTime.of(2023, 2, 12, 19, 45, 58), StatusMovement.FINISHED, container3),
                new Movement(TypeMovement.LOADING, LocalDateTime.of(2023, 2, 12, 15, 27, 58), LocalDateTime.of(2023, 2, 12, 19, 45, 58), StatusMovement.FINISHED, container4),
                new Movement(TypeMovement.LOADING, LocalDateTime.of(2023, 2, 12, 15, 27, 58), LocalDateTime.of(2023, 2, 12, 19, 45, 58), StatusMovement.FINISHED, container5),
                new Movement(TypeMovement.LOADING, LocalDateTime.of(2023, 2, 12, 15, 27, 58), LocalDateTime.of(2023, 2, 12, 19, 45, 58), StatusMovement.FINISHED, container6),
                new Movement(TypeMovement.SHIPPING, LocalDateTime.of(2023, 2, 12, 15, 27, 58), LocalDateTime.of(2023, 2, 12, 19, 45, 58), StatusMovement.FINISHED, container1),
                new Movement(TypeMovement.SHIPPING, LocalDateTime.of(2023, 2, 12, 15, 27, 58), LocalDateTime.of(2023, 2, 12, 19, 45, 58), StatusMovement.FINISHED, container2),
                new Movement(TypeMovement.SHIPPING, LocalDateTime.of(2023, 2, 12, 15, 27, 58), LocalDateTime.of(2023, 2, 12, 19, 45, 58), StatusMovement.FINISHED, container3),
                new Movement(TypeMovement.SHIPPING, LocalDateTime.of(2023, 2, 12, 15, 27, 58), LocalDateTime.of(2023, 2, 12, 19, 45, 58), StatusMovement.FINISHED, container4),
                new Movement(TypeMovement.SHIPPING, LocalDateTime.of(2023, 2, 12, 15, 27, 58), LocalDateTime.of(2023, 2, 12, 19, 45, 58), StatusMovement.FINISHED, container5),
                new Movement(TypeMovement.SHIPPING, LocalDateTime.of(2023, 2, 12, 15, 27, 58), LocalDateTime.of(2023, 2, 12, 19, 45, 58), StatusMovement.FINISHED, container6),
                new Movement(TypeMovement.UNLOAD, LocalDateTime.of(2023, 2, 12, 15, 27, 58), LocalDateTime.of(2023, 2, 12, 19, 45, 58), StatusMovement.FINISHED, container1),
                new Movement(TypeMovement.UNLOAD, LocalDateTime.of(2023, 2, 12, 15, 27, 58), LocalDateTime.of(2023, 2, 12, 19, 45, 58), StatusMovement.FINISHED, container2),
                new Movement(TypeMovement.UNLOAD, LocalDateTime.of(2023, 2, 12, 15, 27, 58), LocalDateTime.of(2023, 2, 12, 19, 45, 58), StatusMovement.FINISHED, container3),
                new Movement(TypeMovement.UNLOAD, LocalDateTime.of(2023, 2, 12, 15, 27, 58), LocalDateTime.of(2023, 2, 12, 19, 45, 58), StatusMovement.FINISHED, container4),
                new Movement(TypeMovement.UNLOAD, LocalDateTime.of(2023, 2, 12, 15, 27, 58), LocalDateTime.of(2023, 2, 12, 19, 45, 58), StatusMovement.FINISHED, container5),
                new Movement(TypeMovement.UNLOAD, LocalDateTime.of(2023, 2, 12, 15, 27, 58), LocalDateTime.of(2023, 2, 12, 19, 45, 58), StatusMovement.FINISHED, container6));
        movementRepository.saveAll(movements);
    }
}