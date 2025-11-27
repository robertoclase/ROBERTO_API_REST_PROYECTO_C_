package com.salesianostriana.dam.apirestroberto.controller;

import com.salesianostriana.dam.apirestroberto.dto.FichajeDto;
import com.salesianostriana.dam.apirestroberto.service.FichajeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/empleados")
@RequiredArgsConstructor
@Tag(name = "Fichaje", description = "API para gestión de fichajes de empleados")
public class FichajeController {

    private final FichajeService fichajeService;

    @Operation(summary = "Registrar un nuevo fichaje para un empleado")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Fichaje registrado exitosamente"),
            @ApiResponse(responseCode = "404", description = "Empleado no encontrado"),
            @ApiResponse(responseCode = "409", description = "Fichaje duplicado (mismo tipo consecutivo)")
    })
    @PostMapping("/{empleadoId}/fichar")
    public ResponseEntity<FichajeDto> registrarFichaje(@PathVariable Long empleadoId) {
        var fichaje = fichajeService.registrarFichaje(empleadoId);
        return ResponseEntity.status(HttpStatus.CREATED).body(FichajeDto.from(fichaje));
    }

    @Operation(summary = "Obtener el historial de fichajes de un empleado")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Historial de fichajes encontrado",
                    content = @Content(array = @ArraySchema(schema = @Schema(implementation = FichajeDto.class)))),
            @ApiResponse(responseCode = "404", description = "Empleado no encontrado")
    })
    @GetMapping("/{empleadoId}/fichajes")
    public ResponseEntity<List<FichajeDto>> obtenerFichajes(@PathVariable Long empleadoId) {
        List<FichajeDto> fichajes = fichajeService.findByEmpleadoId(empleadoId)
                .stream()
                .map(FichajeDto::from)
                .toList();
        return ResponseEntity.ok(fichajes);
    }
}