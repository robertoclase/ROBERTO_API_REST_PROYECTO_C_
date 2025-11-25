package com.salesianostriana.dam.apirestroberto.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.ArrayList;
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "departamento_id")
    private Departamento departamento;

    @OneToMany(mappedBy = "empleado", cascade = CascadeType.ALL)
    private List<Fichaje> fichajes = new ArrayList<>();
}