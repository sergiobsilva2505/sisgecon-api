package br.com.sbs.sisgecon.containers.dto;

import br.com.sbs.sisgecon.containers.enums.CategoryContainer;
import br.com.sbs.sisgecon.containers.enums.StatusContainer;
import br.com.sbs.sisgecon.containers.enums.TypeContainer;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record UpdateContainerForm (Long id,
                                   @NotBlank
                                   @Pattern(regexp = "[A-Z]{4}[0-9]{7}")
                                   String number,
                                   @NotNull
                                   TypeContainer typeContainer,
                                   @NotNull
                                   StatusContainer statusContainer,
                                   @NotNull
                                   CategoryContainer categoryContainer) {
}
