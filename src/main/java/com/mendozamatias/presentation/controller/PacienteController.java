package com.mendozamatias.presentation.controller;

import com.mendozamatias.bussines.services.IPacienteService;
import com.mendozamatias.domain.dto.paciente.CrearPacienteDto;
import com.mendozamatias.domain.dto.paciente.PacienteDto;
import jakarta.annotation.security.PermitAll;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pacientes")
public class PacienteController {

    @Autowired
    private IPacienteService pacienteService;

    @PreAuthorize("hasRole('PROFESIONAL')")
    @GetMapping
    public ResponseEntity<List<PacienteDto>> listarTodosLosPacientes(){
        return ResponseEntity.status(HttpStatus.OK).body(pacienteService.listarTodosLosPaciente());
    }

    @PermitAll
    @PostMapping
    public ResponseEntity<PacienteDto> crearUnPaciente(@RequestBody CrearPacienteDto crearPacienteDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(pacienteService.crearUnPaciente(crearPacienteDto));
    }
}
