// EmpleadoResponseDto.java
package com.salesianostriana.dam.apirestroberto.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmpleadoResponseDto {
    private Long id;
    private String nombreCompleto;
    private String cargo;
    private BigDecimal salario;
    private String nombreDepartamento;
}