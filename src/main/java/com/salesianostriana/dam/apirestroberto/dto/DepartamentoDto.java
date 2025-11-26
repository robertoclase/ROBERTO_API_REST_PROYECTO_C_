package com.salesianostriana.dam.apirestroberto.dto;

import com.salesianostriana.dam.apirestroberto.model.Departamento;
import java.math.BigDecimal;

public record DepartamentoDto(
        Long id,
        String nombre,
        BigDecimal presupuesto
) {
    public Departamento toEntity() {
        return new Departamento(
                this.id(),
                this.nombre(),
                this.presupuesto(),
                new java.util.ArrayList<>()
        );
    }

    public static DepartamentoDto from(Departamento departamento) {
        return new DepartamentoDto(
                departamento.getId(),
                departamento.getNombre(),
                departamento.getPresupuesto()
        );
    }
}