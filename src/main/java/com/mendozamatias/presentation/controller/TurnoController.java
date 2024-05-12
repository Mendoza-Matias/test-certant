package com.mendozamatias.presentation.controller;

import com.mendozamatias.bussines.services.ITurnoService;
import com.mendozamatias.domain.dto.turno.TurnoDto;
import jakarta.annotation.security.PermitAll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/turnos")
public class TurnoController {
    @Autowired
    private ITurnoService turnoService;

    @PreAuthorize("hasRole('PACIENTE')")
    @PostMapping("{horarioId}/{pacienteId}")
    public ResponseEntity<TurnoDto> solicitarTurno(@PathVariable(name = "horarioId")Long horarioId, @PathVariable(name = "pacienteId")Long pacienteId){
        return ResponseEntity.status(HttpStatus.CREATED).body(turnoService.solicitarTurno(horarioId,pacienteId));
    }

    @PermitAll
    @GetMapping("paciente/{pacienteId}")
    public ResponseEntity<List<TurnoDto>> listarTodosLosTurnosByPacienteId(@PathVariable(name="pacienteId")Long pacienteId){
        return ResponseEntity.status(HttpStatus.OK).body(turnoService.listarTodosLosTurnosByPacienteId(pacienteId));
    }

    @PermitAll
    @GetMapping("especialidad/{especialidad}")
    public ResponseEntity<List<TurnoDto>> listarTurnosPorDeEspecialidad(@PathVariable(name = "especialidad") String nombreEspecialidad){
        return ResponseEntity.status(HttpStatus.OK).body(turnoService.listarTurnosPorNombreDeEspecialidad(nombreEspecialidad));
    }

    @PermitAll
    @GetMapping("profesional/{profesional}")
    public ResponseEntity<List<TurnoDto>> listarTurnosPorDeProfesional(@PathVariable(name = "profesional") String nombreProfesional){
        return ResponseEntity.status(HttpStatus.OK).body(turnoService.listarTurnosPorNombreDeProfesional(nombreProfesional));
    }
    @PermitAll
    @PutMapping("cancelar/{turnoId}")
    public ResponseEntity<TurnoDto> cancelarTurno(@PathVariable(name = "turnoId") Long turnoId){
        return ResponseEntity.status(HttpStatus.OK).body(turnoService.cancelarTurno(turnoId));
    }
    @PermitAll
    @PutMapping("atendido/{turnoId}")
    public ResponseEntity<TurnoDto> modificarEstadoAAtendido(@PathVariable(name = "turnoId")Long turnoId){
        return ResponseEntity.status(HttpStatus.OK).body(turnoService.modificarEstadoAAtendido(turnoId));
    }
}
