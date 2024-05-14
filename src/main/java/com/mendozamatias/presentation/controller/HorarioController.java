package com.mendozamatias.presentation.controller;

import com.mendozamatias.bussines.services.IHorarioService;
import com.mendozamatias.domain.dto.horario.CrearHorarioDto;
import com.mendozamatias.domain.dto.horario.HorarioDto;
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

@Tag(name = "5. Horarios ", description = "API para la gestión de los Horarios de los Profesionales de la clinica")

@RestController
@RequestMapping("/api/horarios")
public class HorarioController {

    @Autowired
    private IHorarioService horarioService;

    @Operation(summary = "Listar todos los horarios por especialidad", description = "Lista todos los horarios de atención un especialista")
    @ApiResponse(responseCode = "200", description = "Horario")

    @PermitAll
    @GetMapping("{profesionalId}")
    public ResponseEntity<List<HorarioDto>> listarTodosLosHorariosByEspecialista (@PathVariable(name = "profesionalId")Long profesionalId){
        return ResponseEntity.status(HttpStatus.OK).body(horarioService.listarTodosLosHorariosDisponiblesDeUnEspecialista(profesionalId));
    }
    @Operation(summary = "Crear un horario", description = "Crea un horario")
    @ApiResponse(responseCode = "200", description = "Horario")

    @PreAuthorize("hasRole('PROFESIONAL')")
    @PostMapping("crear/{profesionalId}")
    public ResponseEntity<HorarioDto> crearUnHorario(@PathVariable(name = "profesionalId") Long profesionalId , @RequestBody CrearHorarioDto crearHorarioDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(horarioService.crearUnHorario(profesionalId,crearHorarioDto));
    }
}
