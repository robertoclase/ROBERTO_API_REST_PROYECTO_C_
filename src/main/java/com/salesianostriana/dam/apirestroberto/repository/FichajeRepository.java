package com.salesianostriana.dam.apirestroberto.repository;

import com.salesianostriana.dam.apirestroberto.model.Fichaje;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface FichajeRepository extends JpaRepository<Fichaje, Long> {
    List<Fichaje> findByEmpleadoId(Long empleadoId);
    Optional<Fichaje> findTopByEmpleadoIdOrderByMomentoDesc(Long empleadoId);
}