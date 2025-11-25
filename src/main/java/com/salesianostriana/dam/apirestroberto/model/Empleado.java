package com.salesianostriana.dam.apirestroberto.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

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

    @ManyToOne
    private Departamento departamento;

    @OneToMany
    private List<Fichaje> fichajes;

}
