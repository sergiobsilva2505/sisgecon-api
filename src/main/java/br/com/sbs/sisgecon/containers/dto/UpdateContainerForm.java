package br.com.sbs.sisgecon.containers.dto;

import br.com.sbs.sisgecon.containers.enums.CategoryContainer;
import br.com.sbs.sisgecon.containers.enums.StatusContainer;
import br.com.sbs.sisgecon.containers.enums.TypeContainer;

public record UpdateContainerForm (String number, TypeContainer typeContainer, StatusContainer statusContainer, CategoryContainer categoryContainer) {
}
