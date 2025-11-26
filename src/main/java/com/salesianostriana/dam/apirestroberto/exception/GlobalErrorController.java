package com.salesianostriana.dam.apirestroberto.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.net.URI;
import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalErrorController extends ResponseEntityExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ProblemDetail handleNotFoundException(NotFoundException ex) {
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, ex.getMessage());
        problemDetail.setTitle("Recurso no encontrado");
        problemDetail.setType(URI.create("https://api.empresa.com/errors/not-found"));
        problemDetail.setProperty("timestamp", LocalDateTime.now());
        problemDetail.setProperty("errorCode", "RESOURCE_NOT_FOUND");
        return problemDetail;
    }

    @ExceptionHandler(PresupuestoExcedidoException.class)
    public ProblemDetail handlePresupuestoExcedidoException(PresupuestoExcedidoException ex) {
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, ex.getMessage());
        problemDetail.setTitle("Presupuesto excedido");
        problemDetail.setType(URI.create("https://api.empresa.com/errors/budget-exceeded"));
        problemDetail.setProperty("timestamp", LocalDateTime.now());
        problemDetail.setProperty("errorCode", "BUDGET_EXCEEDED");
        return problemDetail;
    }

    @ExceptionHandler(FichajeDuplicadoException.class)
    public ProblemDetail handleFichajeDuplicadoException(FichajeDuplicadoException ex) {
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.CONFLICT, ex.getMessage());
        problemDetail.setTitle("Fichaje duplicado");
        problemDetail.setType(URI.create("https://api.empresa.com/errors/duplicate-check"));
        problemDetail.setProperty("timestamp", LocalDateTime.now());
        problemDetail.setProperty("errorCode", "DUPLICATE_CHECK_IN_OUT");
        return problemDetail;
    }

    @ExceptionHandler(Exception.class)
    public ProblemDetail handleGenericException(Exception ex) {
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.INTERNAL_SERVER_ERROR, "Error interno del servidor");
        problemDetail.setTitle("Error interno");
        problemDetail.setType(URI.create("https://api.empresa.com/errors/internal-error"));
        problemDetail.setProperty("timestamp", LocalDateTime.now());
        problemDetail.setProperty("errorCode", "INTERNAL_ERROR");
        return problemDetail;
    }
}