package com.salesianostriana.dam.apirestroberto.service;

import com.salesianostriana.dam.apirestroberto.exception.NotFoundException;
import com.salesianostriana.dam.apirestroberto.exception.PresupuestoExcedidoException;
import com.salesianostriana.dam.apirestroberto.model.Departamento;
import com.salesianostriana.dam.apirestroberto.model.Empleado;
import com.salesianostriana.dam.apirestroberto.repository.DepartamentoRepository;
import com.salesianostriana.dam.apirestroberto.repository.EmpleadoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EmpleadoService {

    private final EmpleadoRepository empleadoRepository;
    private final DepartamentoRepository departamentoRepository;

    public List<Empleado> findAll() {
        return empleadoRepository.findAll();
    }

    public Empleado findById(Long id) {
        return empleadoRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Empleado no encontrado"));
    }

    public Empleado save(Empleado empleado) {
        return empleadoRepository.save(empleado);
    }

    public void delete(Long id) {
        if (!empleadoRepository.existsById(id)) {
            throw new NotFoundException("Empleado no encontrado");
        }
        empleadoRepository.deleteById(id);
    }

    public Empleado asignarDepartamento(Long empleadoId, Long departamentoId) {
        Empleado empleado = findById(empleadoId);
        Departamento departamento = departamentoRepository.findById(departamentoId)
                .orElseThrow(() -> new NotFoundException("Departamento no encontrado"));

        empleado.setDepartamento(departamento);

        if (excedePresupuesto(departamento)) {
            throw new PresupuestoExcedidoException("El presupuesto del departamento ha sido excedido");
        }

        return empleadoRepository.save(empleado);
    }

    private boolean excedePresupuesto(Departamento departamento) {
        BigDecimal totalSalarios = empleadoRepository.findByDepartamentoId(departamento.getId())
                .stream()
                .map(Empleado::getSalario)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        return totalSalarios.compareTo(departamento.getPresupuesto()) > 0;
    }
}