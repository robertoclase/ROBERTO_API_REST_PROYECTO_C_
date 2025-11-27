// Empleado.java - AGREGAR VALIDACIONES
package com.salesianostriana.dam.apirestroberto.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
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

    @NotBlank(message = "El nombre completo no puede estar vacío")
    private String nombreCompleto;

    @NotBlank(message = "El cargo no puede estar vacío")
    private String cargo;

    @NotNull(message = "El salario no puede ser nulo")
    @Positive(message = "El salario debe ser mayor que 0")
    private BigDecimal salario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "departamento_id")
    private Departamento departamento;

    @OneToMany(mappedBy = "empleado", fetch = FetchType.EAGER)
    private List<Fichaje> fichajes = new ArrayList<>();
}