package com.mendozamatias.presentation.controller;

import com.mendozamatias.bussines.services.IConsultorioService;
import com.mendozamatias.domain.dto.consultorio.ConsultorioDto;
import jakarta.annotation.security.PermitAll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/consultorios")
public class ConsultorioController {
    @Autowired
    private IConsultorioService consultorioService;

    @PermitAll
    @GetMapping
    public ResponseEntity<List<ConsultorioDto>> listarTodosLosConsultorios(){
        return ResponseEntity.status(HttpStatus.OK).body(consultorioService.listarTodosLosConsultorios());
    }
    @PreAuthorize("hasRole('PROFESIONAL')")
    @PostMapping
    public ResponseEntity<ConsultorioDto> crearUnConsultorio(@RequestBody int numero){
        return ResponseEntity.status(HttpStatus.CREATED).body(consultorioService.crearConsultorio(numero));
    }
    @PreAuthorize("hasRole('PROFESIONAL')")
    @PostMapping("asignar/{consultorioId}/{profesionalId}")
    public ResponseEntity<ConsultorioDto> asignarProfesional(@PathVariable(name = "consultorioId") Long consultorioId,@PathVariable(name = "profesionalId") Long profesionalId){
        return ResponseEntity.status(HttpStatus.OK).body(consultorioService.asignarProfesional(consultorioId,profesionalId));
    }
    @PreAuthorize("hasRole('PROFESIONAL')")
    @PutMapping("modificar/{consultorioId}/{profesionalId}")
    public ResponseEntity<ConsultorioDto> modificarProfesionalDeConsultorio (@PathVariable(name = "consultorioId") Long consultorioId,@PathVariable(name = "profesionalId") Long profesionalId){
        return ResponseEntity.status(HttpStatus.OK).body(consultorioService.modificarProfesionalDeConsultorio(consultorioId,profesionalId));
    }
}
