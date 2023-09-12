package br.com.sbs.sisgecon.containers;

import br.com.sbs.sisgecon.containers.dto.NewContainerForm;
import br.com.sbs.sisgecon.containers.dto.UpdateContainerForm;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class UpdateContainerFormValidator implements Validator {

    private final ContainerRepository containerRepository;

    public UpdateContainerFormValidator(ContainerRepository containerRepository) {
        this.containerRepository = containerRepository;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return UpdateContainerForm.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object target, Errors errors) {
        UpdateContainerForm updateContainerForm = (UpdateContainerForm) target;

        if (containerRepository.existsByNumberAndIdNot(updateContainerForm.number(), updateContainerForm.id())) {
            errors.rejectValue("number", "container.already.exists");
        }
    }
}
