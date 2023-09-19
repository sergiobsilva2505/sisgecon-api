package br.com.sbs.sisgeconapi.util;

import br.com.sbs.sisgeconapi.client.domain.Client;
import br.com.sbs.sisgeconapi.client.domain.ClientRepository;
import br.com.sbs.sisgeconapi.containers.Container;
import br.com.sbs.sisgeconapi.containers.ContainerRepository;
import br.com.sbs.sisgeconapi.containers.enums.ContainerCategory;
import br.com.sbs.sisgeconapi.containers.enums.ContainerStatus;
import br.com.sbs.sisgeconapi.containers.enums.ContainerType;
import br.com.sbs.sisgeconapi.movement.Movement;
import br.com.sbs.sisgeconapi.movement.MovementRepository;
import br.com.sbs.sisgeconapi.movement.enums.MovementStatus;
import br.com.sbs.sisgeconapi.movement.enums.MovementType;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

public class ProgramingDatabaseMotherTest {

    private final ClientRepository clientRepository;
    private final ContainerRepository containerRepository;
    private final MovementRepository movementRepository;


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

        Container container1 = new Container("TEXU1234568", ContainerType.TWENTY, ContainerStatus.FULL, ContainerCategory.IMPORT, caleb);
        Container container2 = new Container("CAXU4568524", ContainerType.FORTY, ContainerStatus.EMPTY, ContainerCategory.EXPORT, daniel);
        Container container3 = new Container("TEMU9871236", ContainerType.TWENTY, ContainerStatus.FULL, ContainerCategory.IMPORT, cesar);
        Container container4 = new Container("ASFU7539510", ContainerType.TWENTY, ContainerStatus.EMPTY, ContainerCategory.IMPORT, caleb);
        Container container5 = new Container("GAZU3698741", ContainerType.TWENTY, ContainerStatus.FULL, ContainerCategory.IMPORT, daniel);
        Container container6 = new Container("FSCU8271936", ContainerType.TWENTY, ContainerStatus.FULL, ContainerCategory.EXPORT, caleb);
        containerRepository.saveAll(
                Arrays.asList(container1, container2, container3, container4, container5, container6));

        List<Movement> movements = List.of(
                new Movement(MovementType.GATE_IN, LocalDateTime.of(2023, 9, 12, 20, 37, 58), LocalDateTime.of(2023, 9, 12, 20, 37, 58), MovementStatus.FINISHED, container1),
                new Movement(MovementType.GATE_IN, LocalDateTime.of(2023, 9, 12, 20, 37, 58), LocalDateTime.of(2023, 9, 12, 20, 37, 58), MovementStatus.FINISHED, container2),
                new Movement(MovementType.GATE_IN, LocalDateTime.of(2023, 9, 12, 20, 37, 58), LocalDateTime.of(2023, 9, 12, 20, 37, 58), MovementStatus.FINISHED, container3),
                new Movement(MovementType.GATE_IN, LocalDateTime.of(2023, 9, 12, 20, 37, 58), LocalDateTime.of(2023, 9, 12, 20, 37, 58), MovementStatus.FINISHED, container4),
                new Movement(MovementType.GATE_IN, LocalDateTime.of(2023, 9, 12, 20, 37, 58), LocalDateTime.of(2023, 9, 12, 20, 37, 58), MovementStatus.FINISHED, container5),
                new Movement(MovementType.GATE_IN, LocalDateTime.of(2023, 9, 12, 20, 37, 58), LocalDateTime.of(2023, 9, 12, 20, 37, 58), MovementStatus.FINISHED, container6),
                new Movement(MovementType.GATE_OUT, LocalDateTime.of(2023, 2, 12, 15, 27, 58), LocalDateTime.of(2023, 2, 12, 19, 45, 58), MovementStatus.FINISHED, container1),
                new Movement(MovementType.GATE_OUT, LocalDateTime.of(2023, 2, 12, 15, 27, 58), LocalDateTime.of(2023, 2, 12, 19, 45, 58), MovementStatus.FINISHED, container2),
                new Movement(MovementType.GATE_OUT, LocalDateTime.of(2023, 2, 12, 15, 27, 58), LocalDateTime.of(2023, 2, 12, 19, 45, 58), MovementStatus.FINISHED, container3),
                new Movement(MovementType.GATE_OUT, LocalDateTime.of(2023, 2, 12, 15, 27, 58), LocalDateTime.of(2023, 2, 12, 19, 45, 58), MovementStatus.FINISHED, container4),
                new Movement(MovementType.GATE_OUT, LocalDateTime.of(2023, 2, 12, 15, 27, 58), LocalDateTime.of(2023, 2, 12, 19, 45, 58), MovementStatus.FINISHED, container5),
                new Movement(MovementType.GATE_OUT, LocalDateTime.of(2023, 2, 12, 15, 27, 58), LocalDateTime.of(2023, 2, 12, 19, 45, 58), MovementStatus.FINISHED, container6),
                new Movement(MovementType.REPOSITIONING, LocalDateTime.of(2023, 2, 12, 15, 27, 58), LocalDateTime.of(2023, 2, 12, 19, 45, 58), MovementStatus.FINISHED, container1),
                new Movement(MovementType.REPOSITIONING, LocalDateTime.of(2023, 2, 12, 15, 27, 58), LocalDateTime.of(2023, 2, 12, 19, 45, 58), MovementStatus.FINISHED, container2),
                new Movement(MovementType.REPOSITIONING, LocalDateTime.of(2023, 2, 12, 15, 27, 58), LocalDateTime.of(2023, 2, 12, 19, 45, 58), MovementStatus.FINISHED, container3),
                new Movement(MovementType.REPOSITIONING, LocalDateTime.of(2023, 2, 12, 15, 27, 58), LocalDateTime.of(2023, 2, 12, 19, 45, 58), MovementStatus.FINISHED, container4),
                new Movement(MovementType.REPOSITIONING, LocalDateTime.of(2023, 2, 12, 15, 27, 58), LocalDateTime.of(2023, 2, 12, 19, 45, 58), MovementStatus.FINISHED, container5),
                new Movement(MovementType.REPOSITIONING, LocalDateTime.of(2023, 2, 12, 15, 27, 58), LocalDateTime.of(2023, 2, 12, 19, 45, 58), MovementStatus.FINISHED, container6),
                new Movement(MovementType.IN_WEIGHING, LocalDateTime.of(2023, 9, 12, 20, 37, 58), LocalDateTime.of(2023, 9, 12, 21, 45, 58), MovementStatus.FINISHED, container1),
                new Movement(MovementType.IN_WEIGHING, LocalDateTime.of(2023, 9, 12, 20, 37, 58), LocalDateTime.of(2023, 9, 12, 21, 45, 58), MovementStatus.FINISHED, container2),
                new Movement(MovementType.IN_WEIGHING, LocalDateTime.of(2023, 9, 12, 20, 37, 58), LocalDateTime.of(2023, 9, 12, 21, 45, 58), MovementStatus.FINISHED, container3),
                new Movement(MovementType.IN_WEIGHING, LocalDateTime.of(2023, 9, 12, 20, 37, 58), LocalDateTime.of(2023, 9, 12, 21, 45, 58), MovementStatus.FINISHED, container4),
                new Movement(MovementType.IN_WEIGHING, LocalDateTime.of(2023, 9, 12, 20, 37, 58), LocalDateTime.of(2023, 9, 12, 21, 45, 58), MovementStatus.FINISHED, container5),
                new Movement(MovementType.IN_WEIGHING, LocalDateTime.of(2023, 9, 12, 20, 37, 58), LocalDateTime.of(2023, 9, 12, 21, 45, 58), MovementStatus.FINISHED, container6),
                new Movement(MovementType.OUT_WEIGHING, LocalDateTime.of(2023, 9, 13, 9, 37, 58), LocalDateTime.of(2023, 9, 13, 10, 45, 58), MovementStatus.FINISHED, container1),
                new Movement(MovementType.OUT_WEIGHING, LocalDateTime.of(2023, 9, 13, 9, 37, 58), LocalDateTime.of(2023, 9, 13, 10, 45, 58), MovementStatus.FINISHED, container2),
                new Movement(MovementType.OUT_WEIGHING, LocalDateTime.of(2023, 9, 13, 9, 37, 58), LocalDateTime.of(2023, 9, 13, 10, 45, 58), MovementStatus.FINISHED, container3),
                new Movement(MovementType.OUT_WEIGHING, LocalDateTime.of(2023, 9, 13, 9, 37, 58), LocalDateTime.of(2023, 9, 13, 10, 45, 58), MovementStatus.FINISHED, container4),
                new Movement(MovementType.OUT_WEIGHING, LocalDateTime.of(2023, 9, 13, 9, 37, 58), LocalDateTime.of(2023, 9, 13, 10, 45, 58), MovementStatus.FINISHED, container5),
                new Movement(MovementType.OUT_WEIGHING, LocalDateTime.of(2023, 9, 13, 9, 37, 58), LocalDateTime.of(2023, 9, 13, 10, 45, 58), MovementStatus.FINISHED, container6),
                new Movement(MovementType.SCANNER, LocalDateTime.of(2023, 2, 12, 11, 27, 58), LocalDateTime.of(2023, 2, 12, 11, 45, 58), MovementStatus.FINISHED, container1),
                new Movement(MovementType.SCANNER, LocalDateTime.of(2023, 2, 12, 11, 27, 58), LocalDateTime.of(2023, 2, 12, 11, 45, 58), MovementStatus.FINISHED, container2),
                new Movement(MovementType.SCANNER, LocalDateTime.of(2023, 2, 12, 11, 27, 58), LocalDateTime.of(2023, 2, 12, 11, 45, 58), MovementStatus.FINISHED, container3),
                new Movement(MovementType.SCANNER, LocalDateTime.of(2023, 2, 12, 11, 27, 58), LocalDateTime.of(2023, 2, 12, 11, 45, 58), MovementStatus.FINISHED, container4),
                new Movement(MovementType.SCANNER, LocalDateTime.of(2023, 2, 12, 11, 27, 58), LocalDateTime.of(2023, 2, 12, 11, 45, 58), MovementStatus.FINISHED, container5),
                new Movement(MovementType.SCANNER, LocalDateTime.of(2023, 2, 12, 11, 27, 58), LocalDateTime.of(2023, 2, 12, 11, 45, 58), MovementStatus.FINISHED, container6),
                new Movement(MovementType.LOADING, LocalDateTime.of(2023, 2, 12, 15, 27, 58), LocalDateTime.of(2023, 2, 12, 19, 45, 58), MovementStatus.FINISHED, container1),
                new Movement(MovementType.LOADING, LocalDateTime.of(2023, 2, 12, 15, 27, 58), LocalDateTime.of(2023, 2, 12, 19, 45, 58), MovementStatus.FINISHED, container2),
                new Movement(MovementType.LOADING, LocalDateTime.of(2023, 2, 12, 15, 27, 58), LocalDateTime.of(2023, 2, 12, 19, 45, 58), MovementStatus.FINISHED, container3),
                new Movement(MovementType.LOADING, LocalDateTime.of(2023, 2, 12, 15, 27, 58), LocalDateTime.of(2023, 2, 12, 19, 45, 58), MovementStatus.FINISHED, container4),
                new Movement(MovementType.LOADING, LocalDateTime.of(2023, 2, 12, 15, 27, 58), LocalDateTime.of(2023, 2, 12, 19, 45, 58), MovementStatus.FINISHED, container5),
                new Movement(MovementType.LOADING, LocalDateTime.of(2023, 2, 12, 15, 27, 58), LocalDateTime.of(2023, 2, 12, 19, 45, 58), MovementStatus.FINISHED, container6),
                new Movement(MovementType.SHIPPING, LocalDateTime.of(2023, 2, 12, 15, 27, 58), LocalDateTime.of(2023, 2, 12, 19, 45, 58), MovementStatus.FINISHED, container1),
                new Movement(MovementType.SHIPPING, LocalDateTime.of(2023, 2, 12, 15, 27, 58), LocalDateTime.of(2023, 2, 12, 19, 45, 58), MovementStatus.FINISHED, container2),
                new Movement(MovementType.SHIPPING, LocalDateTime.of(2023, 2, 12, 15, 27, 58), LocalDateTime.of(2023, 2, 12, 19, 45, 58), MovementStatus.FINISHED, container3),
                new Movement(MovementType.SHIPPING, LocalDateTime.of(2023, 2, 12, 15, 27, 58), LocalDateTime.of(2023, 2, 12, 19, 45, 58), MovementStatus.FINISHED, container4),
                new Movement(MovementType.SHIPPING, LocalDateTime.of(2023, 2, 12, 15, 27, 58), LocalDateTime.of(2023, 2, 12, 19, 45, 58), MovementStatus.FINISHED, container5),
                new Movement(MovementType.SHIPPING, LocalDateTime.of(2023, 2, 12, 15, 27, 58), LocalDateTime.of(2023, 2, 12, 19, 45, 58), MovementStatus.FINISHED, container6),
                new Movement(MovementType.UNLOAD, LocalDateTime.of(2023, 2, 12, 15, 27, 58), LocalDateTime.of(2023, 2, 12, 19, 45, 58), MovementStatus.FINISHED, container1),
                new Movement(MovementType.UNLOAD, LocalDateTime.of(2023, 2, 12, 15, 27, 58), LocalDateTime.of(2023, 2, 12, 19, 45, 58), MovementStatus.FINISHED, container2),
                new Movement(MovementType.UNLOAD, LocalDateTime.of(2023, 2, 12, 15, 27, 58), LocalDateTime.of(2023, 2, 12, 19, 45, 58), MovementStatus.FINISHED, container3),
                new Movement(MovementType.UNLOAD, LocalDateTime.of(2023, 2, 12, 15, 27, 58), LocalDateTime.of(2023, 2, 12, 19, 45, 58), MovementStatus.FINISHED, container4),
                new Movement(MovementType.UNLOAD, LocalDateTime.of(2023, 2, 12, 15, 27, 58), LocalDateTime.of(2023, 2, 12, 19, 45, 58), MovementStatus.FINISHED, container5),
                new Movement(MovementType.UNLOAD, LocalDateTime.of(2023, 2, 12, 15, 27, 58), LocalDateTime.of(2023, 2, 12, 19, 45, 58), MovementStatus.FINISHED, container6));
        movementRepository.saveAll(movements);
    }
}