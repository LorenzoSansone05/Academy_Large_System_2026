package com.academy.exception;

public class StudenteNotFoundExceptionResponse {
    private String errore;
    private Long id;
    private Long timestamp;

    public StudenteNotFoundExceptionResponse(String errore, Long id, Long timestamp) {
        this.errore = errore;
        this.id = id;
        this.timestamp = timestamp;
    }

    // Getter (necessari per Jackson/Spring per creare il JSON)
    public String getErrore() { return errore; }
    public Long getId() { return id; }
    public Long getTimestamp() { return timestamp; }
}
