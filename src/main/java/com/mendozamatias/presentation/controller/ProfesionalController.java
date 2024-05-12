package com.mendozamatias.presentation.controller;

import com.mendozamatias.bussines.services.IProfesionalService;
import com.mendozamatias.domain.dto.profesional.CrearProfesionalDto;
import com.mendozamatias.domain.dto.profesional.ProfesionalDto;
import jakarta.annotation.security.PermitAll;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/profesionales")
public class ProfesionalController {

    @Autowired
    private IProfesionalService profesionalService;

    @PermitAll
    @GetMapping
    public ResponseEntity<List<ProfesionalDto>> listarTodosLosProfesionales(){
        return ResponseEntity.status(HttpStatus.OK).body(profesionalService.listarTodosLosProfesionales());
    }

    @PermitAll
    @PostMapping("{especialidadId}")
    public ResponseEntity<ProfesionalDto> crearUnProfesional(@PathVariable(name = "especialidadId")Long especialidadId,@RequestBody CrearProfesionalDto crearProfesionalDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(profesionalService.crearUnProfesional(especialidadId,crearProfesionalDto));
    }

}
