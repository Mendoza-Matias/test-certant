package com.mendozamatias.presentation.controller;

import com.mendozamatias.bussines.services.IPacienteService;
import com.mendozamatias.domain.dto.paciente.CrearPacienteDto;
import com.mendozamatias.domain.dto.paciente.PacienteDto;
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

@Tag(name = "2. Pacientes ", description = "API para la gestión de Pacientes atendidos en la clinica")

@RestController
@RequestMapping("/api/pacientes")
public class PacienteController {

    @Autowired
    private IPacienteService pacienteService;

    @Operation(summary = "Listar a todos los pacientes", description = "Lista todos los pacientes que se atienden en la clinica")
    @ApiResponse(responseCode = "200", description = "Paciente")

    @PreAuthorize("hasRole('PROFESIONAL')")
    @GetMapping
    public ResponseEntity<List<PacienteDto>> listarTodosLosPacientes(){
        return ResponseEntity.status(HttpStatus.OK).body(pacienteService.listarTodosLosPaciente());
    }

    @Operation(summary = "Crear un paciente", description = "Crea un paciente")
    @ApiResponse(responseCode = "200", description = "Paciente")

    @PermitAll
    @PostMapping
    public ResponseEntity<PacienteDto> crearUnPaciente(@RequestBody CrearPacienteDto crearPacienteDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(pacienteService.crearUnPaciente(crearPacienteDto));
    }
}
