package com.salesianostriana.dam.apirestroberto.model;

import jakarta.persistence.*;
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

    private LocalDateTime momento;

    @Enumerated(EnumType.STRING)
    private Tipo tipo;

    @ManyToOne()
    @JoinColumn(name = "empleado_id", nullable = false)
    private Empleado empleado;
}