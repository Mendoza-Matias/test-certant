package com.mendozamatias.presentation.controller;

import com.mendozamatias.bussines.services.ITurnoService;
import com.mendozamatias.domain.dto.turno.TurnoDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.security.PermitAll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@Tag(name = "6. Turnos ", description = "API para la gestión de Turnos de los Pacientes de que se atienden en la clinica")

@RestController
@RequestMapping("/api/turnos")
public class TurnoController {
    @Autowired
    private ITurnoService turnoService;

    @Operation(summary = "Solicitar turno", description = "Devuelve un Turno")
    @ApiResponse(responseCode = "200", description = "Turnos")

    @PermitAll
    @PostMapping("{horarioId}/{pacienteId}")
    public ResponseEntity<TurnoDto> solicitarTurno(@PathVariable(name = "horarioId")Long horarioId, @PathVariable(name = "pacienteId")Long pacienteId){
        return ResponseEntity.status(HttpStatus.CREATED).body(turnoService.solicitarTurno(horarioId,pacienteId));
    }
    @Operation(summary = "Listar todos los turnos por ID de paciente ", description = "Lista todos los turnos por ID")
    @ApiResponse(responseCode = "200", description = "Turnos")

    @PermitAll
    @GetMapping("paciente/{pacienteId}")
    public ResponseEntity<List<TurnoDto>> listarTodosLosTurnosByPacienteId(@PathVariable(name="pacienteId")Long pacienteId){
        return ResponseEntity.status(HttpStatus.OK).body(turnoService.listarTodosLosTurnosByPacienteId(pacienteId));
    }
    @Operation(summary = "Listar todos los turnos por especialidad de paciente ", description = "Lista todos los turnos por el nombre de una especialidad")
    @ApiResponse(responseCode = "200", description = "Turnos")

    @PermitAll
    @GetMapping("especialidad/{especialidad}")
    public ResponseEntity<List<TurnoDto>> listarTurnosPorDeEspecialidad(@PathVariable(name = "especialidad") String nombreEspecialidad){
        return ResponseEntity.status(HttpStatus.OK).body(turnoService.listarTurnosPorNombreDeEspecialidad(nombreEspecialidad));
    }

    @Operation(summary = "Listar todos los turnos de un paciente por el nombre del profesional", description = "Lista todos los turnos por el nombre del profesional")
    @ApiResponse(responseCode = "200", description = "Turnos")

    @PermitAll
    @GetMapping("profesional/{profesional}")
    public ResponseEntity<List<TurnoDto>> listarTurnosPorDeProfesional(@PathVariable(name = "profesional") String nombreProfesional){
        return ResponseEntity.status(HttpStatus.OK).body(turnoService.listarTurnosPorNombreDeProfesional(nombreProfesional));
    }

    @Operation(summary = "Cancelar turno", description = "Modifica el estado de un turno a cancelado")
    @ApiResponse(responseCode = "200", description = "Turnos")

    @PermitAll
    @PutMapping("cancelar/{turnoId}")
    public ResponseEntity<TurnoDto> cancelarTurno(@PathVariable(name = "turnoId") Long turnoId){
        return ResponseEntity.status(HttpStatus.OK).body(turnoService.cancelarTurno(turnoId));
    }

    @Operation(summary = "Cambiar estado de turno a atendido", description = "Modifica el estado de un turno")
    @ApiResponse(responseCode = "200", description = "Turnos")

    @PreAuthorize("hasRole('PROFESIONAL')")
    @PutMapping("atendido/{turnoId}")
    public ResponseEntity<TurnoDto> modificarEstadoAAtendido(@PathVariable(name = "turnoId")Long turnoId){
        return ResponseEntity.status(HttpStatus.OK).body(turnoService.modificarEstadoAAtendido(turnoId));
    }
}
