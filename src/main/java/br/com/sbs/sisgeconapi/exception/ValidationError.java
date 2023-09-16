package br.com.sbs.sisgeconapi.exception;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandardError {

    private List<FieldMessage> invalidParams = new ArrayList<>();

    public ValidationError(Integer status, String message, Instant timestamp, String path) {
        super(status, message, timestamp, path);
    }

    public List<FieldMessage> getInvalidParams() {
        return invalidParams;
    }

    public void addInvalidParams(FieldMessage fieldMessage) {
        invalidParams.add(fieldMessage);
    }
}
