package br.com.sbs.sisgecon.containers.dto;

import br.com.sbs.sisgecon.containers.enums.ContainerCategory;
import br.com.sbs.sisgecon.containers.enums.ContainerStatus;
import br.com.sbs.sisgecon.containers.enums.ContainerType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record UpdateContainerForm (Long id,
                                   @NotBlank
                                   @Pattern(regexp = "[A-Z]{4}[0-9]{7}")
                                   String number,
                                   @NotNull
                                   ContainerType containerType,
                                   @NotNull
                                   ContainerStatus containerStatus,
                                   @NotNull
                                   ContainerCategory containerCategory) {
}
