package com.mendozamatias.presentation.controller;

import com.mendozamatias.bussines.services.IEspecialidadService;
import com.mendozamatias.domain.dto.especialidad.EspecialidadDto;
import jakarta.annotation.security.PermitAll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/especialidades")
public class EspecialidadController {
    @Autowired
    private IEspecialidadService especialidadService;
    @PermitAll
    @GetMapping
    public ResponseEntity<List<EspecialidadDto>> listarTodasLasEspecialidades(){
        return ResponseEntity.status(HttpStatus.OK).body(especialidadService.listarTodasLasEspecialidades());
    }
    @PreAuthorize("hasRole('PROFESIONAL')")
    @PostMapping
    public ResponseEntity<EspecialidadDto> crearEspecialidad(@RequestBody String nombre){
        return ResponseEntity.status(HttpStatus.CREATED).body(especialidadService.crearEspecialidad(nombre));
    }
    @PreAuthorize("hasRole('PROFESIONAL')")
    @PutMapping("modificar/{especialidadId}")
    public ResponseEntity<EspecialidadDto> modificarEspecialidad(@PathVariable(name = "especialidadId") Long especialidadId ,@RequestBody String nombre){
        return ResponseEntity.status(HttpStatus.OK).body(especialidadService.modificarEspecialidad(especialidadId,nombre));
    }

}
