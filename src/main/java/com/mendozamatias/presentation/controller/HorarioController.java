package com.mendozamatias.presentation.controller;

import com.mendozamatias.bussines.services.IHorarioService;
import com.mendozamatias.domain.dto.horario.CrearHorarioDto;
import com.mendozamatias.domain.dto.horario.HorarioDto;
import jakarta.annotation.security.PermitAll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/horarios")
public class HorarioController {

    @Autowired
    private IHorarioService horarioService;

    @PermitAll
    @GetMapping("{profesionalId}")
    public ResponseEntity<List<HorarioDto>> listarTodosLosHorariosByEspecialista (@PathVariable(name = "profesionalId")Long profesionalId){
        return ResponseEntity.status(HttpStatus.OK).body(horarioService.listarTodosLosHorariosDisponiblesDeUnEspecialista(profesionalId));
    }

    @PreAuthorize("hasRole('PROFESIONAL')")
    @PostMapping("crear/{profesionalId}")
    public ResponseEntity<HorarioDto> crearUnHorario(@PathVariable(name = "profesionalId") Long profesionalId , @RequestBody CrearHorarioDto crearHorarioDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(horarioService.crearUnHorario(profesionalId,crearHorarioDto));
    }
}
