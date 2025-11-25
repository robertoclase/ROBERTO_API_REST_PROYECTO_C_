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
public class Departamento {

    @Id
    @GeneratedValue
    private Long id;
    private String nombre;
    private BigDecimal presupuesto;

    @OneToMany(mappedBy = "departamento", cascade = CascadeType.ALL)
    private List<Empleado> empleados = new ArrayList<>();
}