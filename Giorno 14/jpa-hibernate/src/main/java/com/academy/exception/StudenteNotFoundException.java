package com.academy.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class StudenteNotFoundException extends RuntimeException {

    private Long id;

    public StudenteNotFoundException(Long id) {
        super("Studente non trovato");
        this.id = id;
    }

    public Long getId() {
        return this.id;
    }
}
