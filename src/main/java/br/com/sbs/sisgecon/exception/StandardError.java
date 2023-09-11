package br.com.sbs.sisgecon.exception;

import java.time.Instant;

public class StandardError {

    private Integer status;
    private String message;
    private Instant timestamp;
    private String path;

    @Deprecated
    public StandardError() {
    }

    public StandardError(Integer status, String message, Instant timestamp, String path) {
        this.status = status;
        this.message = message;
        this.timestamp = timestamp;
        this.path = path;
    }

    public Integer getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public String getPath() {
        return path;
    }
}
