package com.salesianostriana.dam.apirestroberto.dto;

import com.salesianostriana.dam.apirestroberto.model.Empleado;

import java.math.BigDecimal;

public record EmpleadoRequestDto(
        String nombreCompleto,
        String cargo,
        BigDecimal salario,
        Long departamentoId
) {
    public Empleado toEntity() {
        return new Empleado(
                null,
                this.nombreCompleto(),
                this.cargo(),
                this.salario(),
                null,
                new java.util.ArrayList<>()
        );
    }
}