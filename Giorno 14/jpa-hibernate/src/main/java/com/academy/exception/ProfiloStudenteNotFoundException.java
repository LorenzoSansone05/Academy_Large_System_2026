package com.academy.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ProfiloStudenteNotFoundException extends RuntimeException {

    public ProfiloStudenteNotFoundException() {
        super("Profilo non trovato");
    }
}
