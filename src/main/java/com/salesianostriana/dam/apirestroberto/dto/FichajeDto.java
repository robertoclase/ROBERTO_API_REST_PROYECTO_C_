// FichajeDto.java
package com.salesianostriana.dam.apirestroberto.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FichajeDto {
    private Long id;
    private LocalDateTime momento;
    private String tipo;
    private Long empleadoId;
    private String nombreEmpleado;
}