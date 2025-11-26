package com.salesianostriana.dam.apirestroberto.service;

import com.salesianostriana.dam.apirestroberto.exception.FichajeDuplicadoException;
import com.salesianostriana.dam.apirestroberto.exception.NotFoundException;
import com.salesianostriana.dam.apirestroberto.model.Fichaje;
import com.salesianostriana.dam.apirestroberto.model.Tipo;
import com.salesianostriana.dam.apirestroberto.repository.EmpleadoRepository;
import com.salesianostriana.dam.apirestroberto.repository.FichajeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FichajeService {

    private final FichajeRepository fichajeRepository;
    private final EmpleadoRepository empleadoRepository;

    public List<Fichaje> findByEmpleadoId(Long empleadoId) {
        if (!empleadoRepository.existsById(empleadoId)) {
            throw new NotFoundException("Empleado no encontrado");
        }
        return fichajeRepository.findByEmpleadoId(empleadoId);
    }

    public Fichaje registrarFichaje(Long empleadoId) {
        if (!empleadoRepository.existsById(empleadoId)) {
            throw new NotFoundException("Empleado no encontrado");
        }

        Tipo tipo = determinarTipoFichaje(empleadoId);

        Fichaje fichaje = new Fichaje(
                null,
                LocalDateTime.now(),
                tipo,
                empleadoRepository.getReferenceById(empleadoId)
        );

        return fichajeRepository.save(fichaje);
    }

    private Tipo determinarTipoFichaje(Long empleadoId) {
        return fichajeRepository.findTopByEmpleadoIdOrderByMomentoDesc(empleadoId)
                .map(ultimoFichaje -> {
                    if (ultimoFichaje.getTipo() == Tipo.ENTRADA) {
                        return Tipo.SALIDA;
                    } else {
                        return Tipo.ENTRADA;
                    }
                })
                .orElse(Tipo.ENTRADA); // Primer fichaje es ENTRADA
    }
}