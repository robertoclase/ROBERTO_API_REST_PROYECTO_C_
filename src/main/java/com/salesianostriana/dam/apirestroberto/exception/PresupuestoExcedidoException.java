package com.salesianostriana.dam.apirestroberto.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class PresupuestoExcedidoException extends RuntimeException {
    public PresupuestoExcedidoException(String message) {
        super(message);
    }
}