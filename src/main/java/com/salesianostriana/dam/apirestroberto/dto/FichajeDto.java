package com.salesianostriana.dam.apirestroberto.dto;

import com.salesianostriana.dam.apirestroberto.model.Fichaje;
import java.time.LocalDateTime;

public record FichajeDto(
        Long id,
        LocalDateTime momento,
        String tipo,
        Long empleadoId,
        String nombreEmpleado
) {
    public static FichajeDto from(Fichaje fichaje) {
        return new FichajeDto(
                fichaje.getId(),
                fichaje.getMomento(),
                fichaje.getTipo().name(),
                fichaje.getEmpleado().getId(),
                fichaje.getEmpleado().getNombreCompleto()
        );
    }
}