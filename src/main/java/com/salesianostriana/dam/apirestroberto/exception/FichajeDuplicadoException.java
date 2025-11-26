package com.salesianostriana.dam.apirestroberto.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class FichajeDuplicadoException extends RuntimeException {
    public FichajeDuplicadoException(String message) {
        super(message);
    }
}