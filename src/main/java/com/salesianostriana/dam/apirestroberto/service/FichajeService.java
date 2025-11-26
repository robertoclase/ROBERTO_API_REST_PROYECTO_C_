
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


        var ultimoFichaje = fichajeRepository.findTopByEmpleadoIdOrderByMomentoDesc(empleadoId);

        if (ultimoFichaje.isPresent()) {
            Tipo ultimoTipo = ultimoFichaje.get().getTipo();

            if (ultimoTipo == Tipo.ENTRADA) {
                throw new FichajeDuplicadoException(
                        "No se puede registrar una ENTRADA cuando el último fichaje ya fue una ENTRADA"
                );
            }

        }

        Tipo tipo = determinarTipoFichaje(empleadoId);
        Fichaje fichaje = new Fichaje(null, LocalDateTime.now(), tipo,
                empleadoRepository.getReferenceById(empleadoId));

        return fichajeRepository.save(fichaje);
    }

    private Tipo determinarTipoFichaje(Long empleadoId) {
        return fichajeRepository.findTopByEmpleadoIdOrderByMomentoDesc(empleadoId)
                .map(ultimoFichaje ->
                        ultimoFichaje.getTipo() == Tipo.ENTRADA ? Tipo.SALIDA : Tipo.ENTRADA
                )
                .orElse(Tipo.ENTRADA);
    }
}