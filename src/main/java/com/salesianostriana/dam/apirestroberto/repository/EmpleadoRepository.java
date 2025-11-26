package com.salesianostriana.dam.apirestroberto.repository;

import com.salesianostriana.dam.apirestroberto.model.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {
    List<Empleado> findByDepartamentoId(Long departamentoId);
}