package br.com.sbs.sisgeconapi.containers;

import br.com.sbs.sisgeconapi.containers.dto.NewContainerForm;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.validation.Errors;

import static org.mockito.Mockito.*;

class NewContainerFormValidatorTest {

    private ContainerRepository containerRepository;
    private NewContainerFormValidator newContainerFormValidator;
    private Errors errors;

    @BeforeEach
    void setUp() {
        containerRepository = mock(ContainerRepository.class);
        newContainerFormValidator = new NewContainerFormValidator(containerRepository);
        errors = mock(Errors.class);
    }

    @Test
    void validate__should_not_return_error_when_container_does_not_exists() {
        NewContainerForm newContainerForm = mock(NewContainerForm.class);
        when(containerRepository.existsByNumber(newContainerForm.number())).thenReturn(false);

        newContainerFormValidator.validate(newContainerForm, errors);

        verify(errors, never()).rejectValue("number", "container.already.exists");
    }

    @Test
    void validate__should_return_error_when_container_already_exists() {
        NewContainerForm newContainerForm = mock(NewContainerForm.class);
        when(containerRepository.existsByNumber(newContainerForm.number())).thenReturn(true);

        newContainerFormValidator.validate(newContainerForm, errors);

        verify(errors).rejectValue("number", "container.already.exists");
    }
}