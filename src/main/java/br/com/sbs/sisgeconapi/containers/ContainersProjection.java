package br.com.sbs.sisgeconapi.containers;

import br.com.sbs.sisgeconapi.containers.enums.ContainerCategory;

public interface ContainersProjection {

    ContainerCategory getContainerCategory();
    Integer getQuantityOfContainers();

}
