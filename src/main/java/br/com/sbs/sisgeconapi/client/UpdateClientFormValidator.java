package br.com.sbs.sisgeconapi.client;

import br.com.sbs.sisgeconapi.client.dto.UpdateClientForm;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class UpdateClientFormValidator implements Validator {

    private final ClientRepository clientRepository;

    public UpdateClientFormValidator(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return UpdateClientForm.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object target, Errors errors) {
        UpdateClientForm updateClientForm = (UpdateClientForm) target;

        if (clientRepository.existsByCnpjAndIdNot(updateClientForm.cnpj(), updateClientForm.id())) {
            errors.rejectValue("cnpj", "cnpj.already.exists");
        }
    }
}