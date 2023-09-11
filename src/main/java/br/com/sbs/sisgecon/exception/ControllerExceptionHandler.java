package br.com.sbs.sisgecon.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;
import java.util.List;

@RestControllerAdvice
public class ControllerExceptionHandler {

    private final MessageSource messageSource;

    public ControllerExceptionHandler(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    ResponseEntity<ValidationError> validationError(MethodArgumentNotValidException exception, HttpServletRequest request) {
        String message = "ocorreu um ou mais erros de validação";
        HttpStatus badRequest = HttpStatus.BAD_REQUEST;
        ValidationError validationError = new ValidationError(badRequest.value(), message, Instant.now(), request.getServletPath());

        List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();
        fieldErrors.forEach((error) -> {
            String errorMessage = messageSource.getMessage(error, LocaleContextHolder.getLocale());
            FieldMessage fieldMessage = new FieldMessage(error.getField(), errorMessage);

            validationError.addInvalidParams(fieldMessage);
        });

        return ResponseEntity.status(badRequest).body(validationError);
    }
}
