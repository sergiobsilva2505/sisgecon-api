package br.com.sbs.sisgeconapi.client;

import br.com.sbs.sisgeconapi.client.dto.NewClientForm;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.validation.Errors;

import static org.mockito.Mockito.*;

class NewClientFormValidatorTest {

    private ClientRepository clientRepository;
    private NewClientFormValidator newClientFormValidator;
    private Errors errors;

    @BeforeEach
    void setUp() {
        clientRepository = mock(ClientRepository.class);
        newClientFormValidator = new NewClientFormValidator(clientRepository);
        errors = mock(Errors.class);
    }

    @Test
    void validate__should_return_error_when_cnpj_already_exists() {
        NewClientForm clientForm = mock(NewClientForm.class);
        when(clientRepository.existsByCnpj(clientForm.cnpj())).thenReturn(true);

        newClientFormValidator.validate(clientForm, errors);

        verify(errors).rejectValue("cnpj", "cnpj.already.exists");
    }

    @Test
    void validate__should_not_return_error_when_cnpj_does_not_exists() {
        NewClientForm clientForm = mock(NewClientForm.class);
        when(clientRepository.existsByCnpj(clientForm.cnpj())).thenReturn(false);

        newClientFormValidator.validate(clientForm, errors);

        verify(errors, never()).rejectValue("cnpj", "cnpj.already.exists");
    }

}