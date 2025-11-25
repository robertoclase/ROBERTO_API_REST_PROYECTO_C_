package com.salesianostriana.dam.apirestroberto.model;

import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;

import java.time.LocalDateTime;

public class Fichaje {
    private Long id;
    private LocalDateTime momento;
    @Enumerated
    private Tipo tipo;

    @ManyToOne
    private Empleado empleado;
}
