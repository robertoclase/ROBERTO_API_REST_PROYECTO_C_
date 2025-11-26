package com.salesianostriana.dam.apirestroberto.dto;

import com.salesianostriana.dam.apirestroberto.model.Empleado;
import java.math.BigDecimal;

public record EmpleadoResponseDto(
        Long id,
        String nombreCompleto,
        String cargo,
        BigDecimal salario,
        String nombreDepartamento
) {
    public static EmpleadoResponseDto from(Empleado empleado) {
        String nombreDepto = empleado.getDepartamento() != null
                ? empleado.getDepartamento().getNombre()
                : "Sin departamento";

        return new EmpleadoResponseDto(
                empleado.getId(),
                empleado.getNombreCompleto(),
                empleado.getCargo(),
                empleado.getSalario(),
                nombreDepto
        );
    }
}