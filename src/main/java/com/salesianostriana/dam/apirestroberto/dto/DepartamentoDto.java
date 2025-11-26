// DepartamentoDto.java
package com.salesianostriana.dam.apirestroberto.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DepartamentoDto {
    private Long id;
    private String nombre;
    private BigDecimal presupuesto;
}