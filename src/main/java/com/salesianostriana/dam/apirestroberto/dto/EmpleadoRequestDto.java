// EmpleadoRequestDto.java
package com.salesianostriana.dam.apirestroberto.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmpleadoRequestDto {
    private String nombreCompleto;
    private String cargo;
    private BigDecimal salario;
    private Long departamentoId;
}