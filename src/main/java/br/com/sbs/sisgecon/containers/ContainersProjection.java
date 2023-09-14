package br.com.sbs.sisgecon.containers;

import br.com.sbs.sisgecon.containers.enums.CategoryContainer;

public interface ContainersProjection {

    CategoryContainer getCategoryContainer();
    Integer getQuantityOfContainers();

}
