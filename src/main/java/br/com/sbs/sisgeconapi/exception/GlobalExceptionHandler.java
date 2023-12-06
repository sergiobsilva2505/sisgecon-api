package br.com.sbs.sisgeconapi.exception;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private final MessageSource messageSource;

    public GlobalExceptionHandler(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    private List<FieldMessage>  getFieldMessages(MethodArgumentNotValidException exception) {
        List<FieldMessage> invalidParams = new ArrayList<>();
        List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();
        fieldErrors.forEach((error) -> {
            String errorMessage = messageSource.getMessage(error, LocaleContextHolder.getLocale());
            invalidParams.add(new FieldMessage(error.getField(), errorMessage));
        });

        return invalidParams;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    ResponseEntity<ProblemDetail> validationError(MethodArgumentNotValidException exception) {
        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
        List<FieldMessage> invalidParams = getFieldMessages(exception);

        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(httpStatus, exception.getLocalizedMessage());
        problemDetail.setTitle("Erro de validação");
        problemDetail.setDetail("Um ou mais campos estão com dados incorretos ou o dado já existe");
        problemDetail.setProperty("invalidParams", invalidParams);

        return ResponseEntity.status(httpStatus).body(problemDetail);
    }

    @ExceptionHandler(ControllerNotFoundException.class)
    ResponseEntity<ProblemDetail> controllerNotfound(ControllerNotFoundException exception) {

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, exception.getLocalizedMessage()));
    }

    @ExceptionHandler(ServiceNotFoundException.class)
    ResponseEntity<ProblemDetail> serviceNotfound(ServiceNotFoundException exception) {

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, exception.getLocalizedMessage()));
    }

    @ExceptionHandler(DatabaseException.class)
    ResponseEntity<ProblemDetail> databaseViolation(DatabaseException exception) {

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, exception.getLocalizedMessage()));
    }
}
