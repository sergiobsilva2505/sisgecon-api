package br.com.sbs.sisgecon.client;

import br.com.sbs.sisgecon.client.dto.NewClientForm;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class NewClientFormValidator implements Validator {

    private final ClientRepository clientRepository;

    public NewClientFormValidator(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return NewClientForm.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object target, Errors errors) {
        NewClientForm newClientForm = (NewClientForm) target;
        if (clientRepository.existsByCnpj(newClientForm.cnpj())) {
            errors.rejectValue("cnpj", "{cnpj.already.exists}");
        }

    }
}
