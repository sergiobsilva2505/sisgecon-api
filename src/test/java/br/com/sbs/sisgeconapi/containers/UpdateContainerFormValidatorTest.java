package br.com.sbs.sisgeconapi.containers;

import br.com.sbs.sisgeconapi.containers.dto.UpdateContainerForm;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.validation.Errors;

import static org.mockito.Mockito.*;

class UpdateContainerFormValidatorTest {

    private ContainerRepository containerRepository;
    private UpdateContainerFormValidator updateContainerFormValidator;
    private Errors errors;

    @BeforeEach
    void setUp() {
        containerRepository = mock(ContainerRepository.class);
        updateContainerFormValidator = new UpdateContainerFormValidator(containerRepository);
        errors = mock(Errors.class);
    }

    @Test
    void validate__should_not_return_error_when_container_does_not_exists() {
        UpdateContainerForm updateContainerForm = mock(UpdateContainerForm.class);
        when(containerRepository.existsByNumberAndIdNot(updateContainerForm.number(), updateContainerForm.id())).thenReturn(false);

        updateContainerFormValidator.validate(updateContainerForm, errors);

        verify(errors, never()).rejectValue("number", "container.already.exists");
    }

    @Test
    void validate__should_return_error_when_container_already_exists() {
        UpdateContainerForm updateContainerForm = mock(UpdateContainerForm.class);
        when(containerRepository.existsByNumberAndIdNot(updateContainerForm.number(), updateContainerForm.id())).thenReturn(true);

        updateContainerFormValidator.validate(updateContainerForm, errors);

        verify(errors).rejectValue("number", "container.already.exists");
    }
}