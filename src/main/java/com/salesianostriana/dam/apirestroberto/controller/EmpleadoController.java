package com.salesianostriana.dam.apirestroberto.controller;

import com.salesianostriana.dam.apirestroberto.dto.EmpleadoRequestDto;
import com.salesianostriana.dam.apirestroberto.dto.EmpleadoResponseDto;
import com.salesianostriana.dam.apirestroberto.service.EmpleadoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/empleados")
@RequiredArgsConstructor
@Tag(name = "Empleado", description = "API para gestión de empleados")
public class EmpleadoController {

    private final EmpleadoService empleadoService;

    @Operation(summary = "Obtener todos los empleados")
    @ApiResponse(responseCode = "200", description = "Lista de empleados encontrada",
                 content = @Content(array = @ArraySchema(schema = @Schema(implementation = EmpleadoResponseDto.class))))
    @GetMapping
    public ResponseEntity<List<EmpleadoResponseDto>> findAll() {
        List<EmpleadoResponseDto> empleados = empleadoService.findAll().stream().map(EmpleadoResponseDto::from).toList();
        return ResponseEntity.ok(empleados);
    }

    @Operation(summary = "Obtener un empleado por ID")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Empleado encontrado"),
                  @ApiResponse(responseCode = "404", description = "Empleado no encontrado")})
    @GetMapping("/{id}")
    public ResponseEntity<EmpleadoResponseDto> findById(@PathVariable Long id) {
        return ResponseEntity.ok(EmpleadoResponseDto.from(empleadoService.findById(id)));
    }

    @Operation(summary = "Crear un nuevo empleado")
    @ApiResponse(responseCode = "201", description = "Empleado creado exitosamente")
    @PostMapping
    public ResponseEntity<EmpleadoResponseDto> create(@Valid @RequestBody EmpleadoRequestDto dto) {
        var empleado = dto.toEntity();
        var saved = empleadoService.save(empleado);
        return ResponseEntity.status(HttpStatus.CREATED).body(EmpleadoResponseDto.from(saved));
    }

    @Operation(summary = "Actualizar un empleado existente")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Empleado actualizado"),
                  @ApiResponse(responseCode = "404", description = "Empleado no encontrado")})
    @PutMapping("/{id}")
    public ResponseEntity<EmpleadoResponseDto> update(@PathVariable Long id, @Valid @RequestBody EmpleadoRequestDto dto) {
        var existing = empleadoService.findById(id);
        existing.setNombreCompleto(dto.nombreCompleto());
        existing.setCargo(dto.cargo());
        existing.setSalario(dto.salario());
        var updated = empleadoService.save(existing);
        return ResponseEntity.ok(EmpleadoResponseDto.from(updated));
    }

    @Operation(summary = "Eliminar un empleado")
    @ApiResponses(value = {@ApiResponse(responseCode = "204", description = "Empleado eliminado"),
                 @ApiResponse(responseCode = "404", description = "Empleado no encontrado")})
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        empleadoService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Asignar un empleado a un departamento")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Departamento asignado correctamente"),
                  @ApiResponse(responseCode = "404", description = "Empleado o departamento no encontrado"), @ApiResponse(responseCode = "400", description = "Presupuesto del departamento excedido")})
    @PutMapping("/{empleadoId}/departamento/{deptoId}")
    public ResponseEntity<EmpleadoResponseDto> asignarDepartamento(@PathVariable Long empleadoId, @PathVariable Long deptoId) {
        var empleado = empleadoService.asignarDepartamento(empleadoId, deptoId);
        return ResponseEntity.ok(EmpleadoResponseDto.from(empleado));
    }
}