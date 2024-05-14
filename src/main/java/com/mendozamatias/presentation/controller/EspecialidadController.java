package com.mendozamatias.presentation.controller;

import com.mendozamatias.bussines.services.IEspecialidadService;
import com.mendozamatias.domain.dto.especialidad.EspecialidadDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.security.PermitAll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "3. Especialidades ", description = "API para la gestión de las Especialidades medicas de la clinica")

@RestController
@RequestMapping("/api/especialidades")
public class EspecialidadController {
    @Autowired
    private IEspecialidadService especialidadService;

    @Operation(summary = "Listar todas las especialidades", description = "Lista todas la especialidades de la clinica")
    @ApiResponse(responseCode = "200", description = "Especialidad")

    @PermitAll
    @GetMapping
    public ResponseEntity<List<EspecialidadDto>> listarTodasLasEspecialidades(){
        return ResponseEntity.status(HttpStatus.OK).body(especialidadService.listarTodasLasEspecialidades());
    }
    @Operation(summary = "Crear especialidad", description = "Crea una especialidad nueva")
    @ApiResponse(responseCode = "200", description = "Especialidad")

    @PreAuthorize("hasRole('PROFESIONAL')")
    @PostMapping
    public ResponseEntity<EspecialidadDto> crearEspecialidad(@RequestBody String nombre){
        return ResponseEntity.status(HttpStatus.CREATED).body(especialidadService.crearEspecialidad(nombre));
    }
    @Operation(summary = "Modificar especialidad", description = "Modifica la especialidad de un profesional")
    @ApiResponse(responseCode = "200", description = "Especialidad")

    @PreAuthorize("hasRole('PROFESIONAL')")
    @PutMapping("modificar/{especialidadId}")
    public ResponseEntity<EspecialidadDto> modificarEspecialidad(@PathVariable(name = "especialidadId") Long especialidadId ,@RequestBody String nombre){
        return ResponseEntity.status(HttpStatus.OK).body(especialidadService.modificarEspecialidad(especialidadId,nombre));
    }

}
