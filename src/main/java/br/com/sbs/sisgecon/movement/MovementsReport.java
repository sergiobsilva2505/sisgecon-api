package br.com.sbs.sisgecon.movement;

import br.com.sbs.sisgecon.containers.ContainersProjection;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record MovementsReport(@JsonProperty("summary") List<ContainersProjection> quantityOfImportsAndExports, List<MovementsProjection> quantityOfMovements) {
}
