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
import br.com.sbs.sisgecon.movement.enums.TypeMovement;

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
        Container container7 = new Container("POLU7193462", TypeContainer.TWENTY, StatusContainer.FULL, CategoryContainer.IMPORT, cesar);
        Container container8 = new Container("KKTU9173468", TypeContainer.FORTY, StatusContainer.FULL, CategoryContainer.EXPORT, caleb);
        Container container9 = new Container("KHTU9173499", TypeContainer.FORTY, StatusContainer.FULL, CategoryContainer.EXPORT, caleb);
        Container container10 = new Container("PMUU7412589", TypeContainer.TWENTY, StatusContainer.FULL, CategoryContainer.IMPORT, daniel);
        Container container11 = new Container("ABTU8529872", TypeContainer.FORTY, StatusContainer.EMPTY, CategoryContainer.IMPORT, daniel);
        Container container12 = new Container("QWEU8527419", TypeContainer.TWENTY, StatusContainer.EMPTY, CategoryContainer.EXPORT, caleb);
        Container container13 = new Container("TTNU4856547", TypeContainer.FORTY, StatusContainer.EMPTY, CategoryContainer.IMPORT, daniel);
        containerRepository.saveAll(
                Arrays.asList(container1, container2, container3, container4, container5, container6, container7, container8, container9, container10, container11, container12, container13));

        List<Movement> movements = List.of(
                new Movement(TypeMovement.GATE_IN, container1),
                new Movement(TypeMovement.GATE_IN, container2),
                new Movement(TypeMovement.GATE_IN, container3),
                new Movement(TypeMovement.GATE_IN, container4),
                new Movement(TypeMovement.GATE_IN, container5),
                new Movement(TypeMovement.GATE_IN, container6),
                new Movement(TypeMovement.GATE_IN, container7),
                new Movement(TypeMovement.GATE_IN, container8),
                new Movement(TypeMovement.GATE_IN, container9),
                new Movement(TypeMovement.GATE_IN, container10),
                new Movement(TypeMovement.GATE_IN, container11),
                new Movement(TypeMovement.GATE_IN, container12),
                new Movement(TypeMovement.GATE_IN, container13),
                new Movement(TypeMovement.GATE_OUT, container1),
                new Movement(TypeMovement.GATE_OUT, container2),
                new Movement(TypeMovement.GATE_OUT, container3),
                new Movement(TypeMovement.GATE_OUT, container4),
                new Movement(TypeMovement.GATE_OUT, container5),
                new Movement(TypeMovement.GATE_OUT, container6),
                new Movement(TypeMovement.GATE_OUT, container7),
                new Movement(TypeMovement.GATE_OUT, container8),
                new Movement(TypeMovement.GATE_OUT, container9),
                new Movement(TypeMovement.GATE_OUT, container10),
                new Movement(TypeMovement.GATE_OUT, container11),
                new Movement(TypeMovement.GATE_OUT, container12),
                new Movement(TypeMovement.GATE_OUT, container13),
                new Movement(TypeMovement.REPOSITIONING, container1),
                new Movement(TypeMovement.REPOSITIONING, container2),
                new Movement(TypeMovement.REPOSITIONING, container3),
                new Movement(TypeMovement.REPOSITIONING, container4),
                new Movement(TypeMovement.REPOSITIONING, container5),
                new Movement(TypeMovement.REPOSITIONING, container6),
                new Movement(TypeMovement.REPOSITIONING, container7),
                new Movement(TypeMovement.REPOSITIONING, container8),
                new Movement(TypeMovement.REPOSITIONING, container9),
                new Movement(TypeMovement.REPOSITIONING, container10),
                new Movement(TypeMovement.REPOSITIONING, container11),
                new Movement(TypeMovement.REPOSITIONING, container12),
                new Movement(TypeMovement.REPOSITIONING, container13),
                new Movement(TypeMovement.IN_WEIGHING, container1),
                new Movement(TypeMovement.IN_WEIGHING, container2),
                new Movement(TypeMovement.IN_WEIGHING, container3),
                new Movement(TypeMovement.IN_WEIGHING, container4),
                new Movement(TypeMovement.IN_WEIGHING, container5),
                new Movement(TypeMovement.IN_WEIGHING, container6),
                new Movement(TypeMovement.IN_WEIGHING, container7),
                new Movement(TypeMovement.IN_WEIGHING, container8),
                new Movement(TypeMovement.IN_WEIGHING, container9),
                new Movement(TypeMovement.IN_WEIGHING, container10),
                new Movement(TypeMovement.IN_WEIGHING, container11),
                new Movement(TypeMovement.IN_WEIGHING, container12),
                new Movement(TypeMovement.IN_WEIGHING, container13),
                new Movement(TypeMovement.OUT_WEIGHING, container1),
                new Movement(TypeMovement.OUT_WEIGHING, container2),
                new Movement(TypeMovement.OUT_WEIGHING, container3),
                new Movement(TypeMovement.OUT_WEIGHING, container4),
                new Movement(TypeMovement.OUT_WEIGHING, container5),
                new Movement(TypeMovement.OUT_WEIGHING, container6),
                new Movement(TypeMovement.OUT_WEIGHING, container7),
                new Movement(TypeMovement.OUT_WEIGHING, container8),
                new Movement(TypeMovement.OUT_WEIGHING, container9),
                new Movement(TypeMovement.OUT_WEIGHING, container10),
                new Movement(TypeMovement.OUT_WEIGHING, container11),
                new Movement(TypeMovement.OUT_WEIGHING, container12),
                new Movement(TypeMovement.OUT_WEIGHING, container13),
                new Movement(TypeMovement.SCANNER, container1),
                new Movement(TypeMovement.SCANNER, container2),
                new Movement(TypeMovement.SCANNER, container3),
                new Movement(TypeMovement.SCANNER, container4),
                new Movement(TypeMovement.SCANNER, container5),
                new Movement(TypeMovement.SCANNER, container6),
                new Movement(TypeMovement.SCANNER, container7),
                new Movement(TypeMovement.SCANNER, container8),
                new Movement(TypeMovement.SCANNER, container9),
                new Movement(TypeMovement.SCANNER, container10),
                new Movement(TypeMovement.SCANNER, container11),
                new Movement(TypeMovement.SCANNER, container12),
                new Movement(TypeMovement.SCANNER, container13),
                new Movement(TypeMovement.LOADING, container1),
                new Movement(TypeMovement.LOADING, container2),
                new Movement(TypeMovement.LOADING, container3),
                new Movement(TypeMovement.LOADING, container4),
                new Movement(TypeMovement.LOADING, container5),
                new Movement(TypeMovement.LOADING, container6),
                new Movement(TypeMovement.LOADING, container7),
                new Movement(TypeMovement.LOADING, container8),
                new Movement(TypeMovement.LOADING, container9),
                new Movement(TypeMovement.LOADING, container10),
                new Movement(TypeMovement.LOADING, container11),
                new Movement(TypeMovement.LOADING, container12),
                new Movement(TypeMovement.LOADING, container13),
                new Movement(TypeMovement.SHIPPING, container1),
                new Movement(TypeMovement.SHIPPING, container2),
                new Movement(TypeMovement.SHIPPING, container3),
                new Movement(TypeMovement.SHIPPING, container4),
                new Movement(TypeMovement.SHIPPING, container5),
                new Movement(TypeMovement.SHIPPING, container6),
                new Movement(TypeMovement.SHIPPING, container7),
                new Movement(TypeMovement.SHIPPING, container8),
                new Movement(TypeMovement.SHIPPING, container9),
                new Movement(TypeMovement.SHIPPING, container10),
                new Movement(TypeMovement.SHIPPING, container11),
                new Movement(TypeMovement.SHIPPING, container12),
                new Movement(TypeMovement.SHIPPING, container13),
                new Movement(TypeMovement.UNLOAD, container1),
                new Movement(TypeMovement.UNLOAD, container2),
                new Movement(TypeMovement.UNLOAD, container3),
                new Movement(TypeMovement.UNLOAD, container4),
                new Movement(TypeMovement.UNLOAD, container5),
                new Movement(TypeMovement.UNLOAD, container6),
                new Movement(TypeMovement.UNLOAD, container7),
                new Movement(TypeMovement.UNLOAD, container8),
                new Movement(TypeMovement.UNLOAD, container9),
                new Movement(TypeMovement.UNLOAD, container10),
                new Movement(TypeMovement.UNLOAD, container11),
                new Movement(TypeMovement.UNLOAD, container12),
                new Movement(TypeMovement.UNLOAD, container13));
        movementRepository.saveAll(movements);
    }
}