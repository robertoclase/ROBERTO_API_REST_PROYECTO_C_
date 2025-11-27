package com.salesianostriana.dam.apirestroberto.controller;

import com.salesianostriana.dam.apirestroberto.dto.DepartamentoDto;
import com.salesianostriana.dam.apirestroberto.model.Departamento;
import com.salesianostriana.dam.apirestroberto.service.DepartamentoService;
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
@RequestMapping("/api/v1/departamentos")
@RequiredArgsConstructor
@Tag(name = "Departamento", description = "API para gestión de departamentos")
public class DepartamentoController {

    private final DepartamentoService departamentoService;

    @Operation(summary = "Obtener todos los departamentos")
    @ApiResponse(responseCode = "200", description = "Lista de departamentos encontrada",
            content = @Content(array = @ArraySchema(schema = @Schema(implementation = DepartamentoDto.class))))
    @GetMapping
    public ResponseEntity<List<DepartamentoDto>> findAll() {
        List<DepartamentoDto> departamentos = departamentoService.findAll()
                .stream()
                .map(DepartamentoDto::from)
                .toList();
        return ResponseEntity.ok(departamentos);
    }

    @Operation(summary = "Obtener un departamento por ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Departamento encontrado"),
            @ApiResponse(responseCode = "404", description = "Departamento no encontrado")
    })
    @GetMapping("/{id}")
    public ResponseEntity<DepartamentoDto> findById(@PathVariable Long id) {
        Departamento departamento = departamentoService.findByIdOrThrow(id);
        return ResponseEntity.ok(DepartamentoDto.from(departamento));
    }

    @Operation(summary = "Crear un nuevo departamento")
    @ApiResponse(responseCode = "201", description = "Departamento creado exitosamente")
    @PostMapping
    public ResponseEntity<DepartamentoDto> create(@Valid @RequestBody DepartamentoDto dto) {
        Departamento departamento = dto.toEntity();
        Departamento saved = departamentoService.save(departamento);
        return ResponseEntity.status(HttpStatus.CREATED).body(DepartamentoDto.from(saved));
    }

    @Operation(summary = "Actualizar un departamento existente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Departamento actualizado"),
            @ApiResponse(responseCode = "404", description = "Departamento no encontrado")
    })
    @PutMapping("/{id}")
    public ResponseEntity<DepartamentoDto> update(@PathVariable Long id,
                                                  @Valid @RequestBody DepartamentoDto dto) {
        Departamento existing = departamentoService.findByIdOrThrow(id);
        existing.setNombre(dto.nombre());
        existing.setPresupuesto(dto.presupuesto());
        Departamento updated = departamentoService.edit(existing);
        return ResponseEntity.ok(DepartamentoDto.from(updated));
    }

    @Operation(summary = "Eliminar un departamento")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Departamento eliminado"),
            @ApiResponse(responseCode = "404", description = "Departamento no encontrado")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        departamentoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}