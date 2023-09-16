package br.com.sbs.sisgeconapi.containers;

import br.com.sbs.sisgeconapi.containers.dto.NewContainerForm;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class NewContainerFormValidator implements Validator {

    private final ContainerRepository containerRepository;

    public NewContainerFormValidator(ContainerRepository containerRepository) {
        this.containerRepository = containerRepository;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return NewContainerForm.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object target, Errors errors) {
        NewContainerForm newContainerForm = (NewContainerForm) target;

        if (containerRepository.existsByNumber(newContainerForm.number())) {
            errors.rejectValue("number", "container.already.exists");
        }
    }
}
