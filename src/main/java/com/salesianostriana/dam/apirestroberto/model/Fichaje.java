package com.salesianostriana.dam.apirestroberto.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Fichaje {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull(message = "El momento del fichaje no puede ser nulo")
    private LocalDateTime momento;

    @NotNull(message = "El tipo de fichaje no puede ser nulo")
    @Enumerated(EnumType.STRING)
    private Tipo tipo;

    @NotNull(message = "El empleado no puede ser nulo")
    @ManyToOne
    @JoinColumn(name = "empleado_id", nullable = false)
    private Empleado empleado;

}