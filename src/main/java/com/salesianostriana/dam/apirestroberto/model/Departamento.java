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
public class Departamento {

    @Id
    @GeneratedValue
    private Long id;

    @NotBlank(message = "El nombre no puede estar vacío")
    @Column(unique = true)
    private String nombre;

    @NotNull(message = "El presupuesto no puede ser nulo")
    @Positive(message = "El presupuesto debe ser mayor que 0")
    private BigDecimal presupuesto;

    @OneToMany(mappedBy = "departamento", cascade = CascadeType.ALL)
    private List<Empleado> empleados = new ArrayList<>();
}