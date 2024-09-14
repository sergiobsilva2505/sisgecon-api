package br.com.sbs.sisgeconapi.movement;

import br.com.sbs.sisgeconapi.containers.ContainersProjection;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record MovementsReport(@JsonProperty("summary") List<ContainersProjection> quantityOfImportsAndExports,
                              List<MovementsProjection> quantityOfMovements) {
}
