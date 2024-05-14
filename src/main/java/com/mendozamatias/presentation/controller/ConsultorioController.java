package com.mendozamatias.presentation.controller;

import com.mendozamatias.bussines.services.IConsultorioService;
import com.mendozamatias.domain.dto.consultorio.ConsultorioDto;
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

@Tag(name = "4. Consultorio ", description = "API para la gestión de Consultorios de la clinica")

@RestController
@RequestMapping("/api/consultorios")
public class ConsultorioController {
    @Autowired
    private IConsultorioService consultorioService;

    @Operation(summary = "Listar todos los consultorios", description = "Lista todos los consultorios de la clinica")
    @ApiResponse(responseCode = "200", description = "Consultorio")

    @PermitAll
    @GetMapping
    public ResponseEntity<List<ConsultorioDto>> listarTodosLosConsultorios(){
        return ResponseEntity.status(HttpStatus.OK).body(consultorioService.listarTodosLosConsultorios());
    }

    @Operation(summary = "Crear un consultorio", description = "Crea un consultorio")
    @ApiResponse(responseCode = "200", description = "Consultorio")

    @PreAuthorize("hasRole('PROFESIONAL')")
    @PostMapping
    public ResponseEntity<ConsultorioDto> crearUnConsultorio(@RequestBody int numero){
        return ResponseEntity.status(HttpStatus.CREATED).body(consultorioService.crearConsultorio(numero));
    }
    @Operation(summary = "Asignar un profesional", description = "Asigna un profesional a un consultorio")
    @ApiResponse(responseCode = "200", description = "Consultorio")

    @PreAuthorize("hasRole('PROFESIONAL')")
    @PostMapping("asignar/{consultorioId}/{profesionalId}")
    public ResponseEntity<ConsultorioDto> asignarProfesional(@PathVariable(name = "consultorioId") Long consultorioId,@PathVariable(name = "profesionalId") Long profesionalId){
        return ResponseEntity.status(HttpStatus.OK).body(consultorioService.asignarProfesional(consultorioId,profesionalId));
    }
    @Operation(summary = "Modificar profesional de consultorio", description = "Modifica el profesional asignado en un consultorio")
    @ApiResponse(responseCode = "200", description = "Consultorio")

    @PreAuthorize("hasRole('PROFESIONAL')")
    @PutMapping("modificar/{consultorioId}/{profesionalId}")
    public ResponseEntity<ConsultorioDto> modificarProfesionalDeConsultorio (@PathVariable(name = "consultorioId") Long consultorioId,@PathVariable(name = "profesionalId") Long profesionalId){
        return ResponseEntity.status(HttpStatus.OK).body(consultorioService.modificarProfesionalDeConsultorio(consultorioId,profesionalId));
    }
}
