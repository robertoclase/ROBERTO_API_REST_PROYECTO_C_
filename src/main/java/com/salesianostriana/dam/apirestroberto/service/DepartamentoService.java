package com.salesianostriana.dam.apirestroberto.service;

import com.salesianostriana.dam.apirestroberto.exception.NotFoundException;
import com.salesianostriana.dam.apirestroberto.model.Departamento;
import com.salesianostriana.dam.apirestroberto.repository.DepartamentoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DepartamentoService {

    private final DepartamentoRepository departamentoRepository;

    public List<Departamento> findAll() {
        return departamentoRepository.findAll();
    }

    public Optional<Departamento> findById(Long id) {
        return departamentoRepository.findById(id);
    }

    public Departamento save(Departamento departamento) {
        return departamentoRepository.save(departamento);
    }

    public Departamento edit(Departamento departamento) {
        return departamentoRepository.save(departamento);
    }

    public void deleteById(Long id) {
        if (!departamentoRepository.existsById(id)) {
            throw new NotFoundException("Departamento no encontrado");
        }
        departamentoRepository.deleteById(id);
    }


    public Departamento findByIdOrThrow(Long id) {
        return departamentoRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Departamento no encontrado"));
    }
}