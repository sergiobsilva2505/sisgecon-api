package br.com.sbs.sisgecon.containers;

import br.com.sbs.sisgecon.containers.enums.ContainerCategory;

public interface ContainersProjection {

    ContainerCategory getContainerCategory();
    Integer getQuantityOfContainers();

}
