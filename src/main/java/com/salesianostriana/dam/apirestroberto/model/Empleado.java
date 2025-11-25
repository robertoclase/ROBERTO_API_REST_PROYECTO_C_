package com.salesianostriana.dam.apirestroberto.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Empleado {

    @Id
    @GeneratedValue
    private Long id;
    private String nombreCompleto;
    private String cargo;
    private BigDecimal salario;

}
