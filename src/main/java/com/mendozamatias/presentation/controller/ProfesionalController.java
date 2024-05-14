package com.mendozamatias.presentation.controller;

import com.mendozamatias.bussines.services.IProfesionalService;
import com.mendozamatias.domain.dto.profesional.CrearProfesionalDto;
import com.mendozamatias.domain.dto.profesional.ProfesionalDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.security.PermitAll;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "1. Profesionales ", description = "API para la gestión de Profesionales de la clinica")

@RestController
@RequestMapping("/api/profesionales")
public class ProfesionalController {

    @Autowired
    private IProfesionalService profesionalService;

    @Operation(summary = "Listar todos los profesionales", description = "Lista todos los profesionales de la clinica")
    @ApiResponse(responseCode = "200", description = "Profesional")

    @PermitAll
    @GetMapping
    public ResponseEntity<List<ProfesionalDto>> listarTodosLosProfesionales(){
        return ResponseEntity.status(HttpStatus.OK).body(profesionalService.listarTodosLosProfesionales());
    }
    @Operation(summary = "Crear un profesional", description = "Crea un profesional")
    @ApiResponse(responseCode = "200", description = "Profesional")

    @PermitAll
    @PostMapping("{especialidadId}")
    public ResponseEntity<ProfesionalDto> crearUnProfesional(@PathVariable(name = "especialidadId")Long especialidadId,@RequestBody CrearProfesionalDto crearProfesionalDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(profesionalService.crearUnProfesional(especialidadId,crearProfesionalDto));
    }

    @Operation(summary = "Modificar clave", description = "Modifica la clave de un profesional")
    @ApiResponse(responseCode = "200", description = "Profesional")

    @PreAuthorize("hasRole('PROFESIONAL')")
    @PutMapping("clave/{profesionalId}")
    public ResponseEntity<ProfesionalDto> modificarClave(@PathVariable(name = "profesionalId")Long profesionalId,@RequestBody String clave){
        return ResponseEntity.status(HttpStatus.OK).body(profesionalService.modificarClave(profesionalId,clave));
    }

}
