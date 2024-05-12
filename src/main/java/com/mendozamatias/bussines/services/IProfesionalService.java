package com.mendozamatias.bussines.services;

import com.mendozamatias.domain.dto.profesional.CrearProfesionalDto;
import com.mendozamatias.domain.dto.profesional.ProfesionalDto;

import java.util.List;

public interface IProfesionalService {

    List<ProfesionalDto> listarTodosLosProfesionales();

    ProfesionalDto crearUnProfesional(Long especialidadId , CrearProfesionalDto crearProfesionalDto);

    boolean existeProfesionalConEsteDni(int dni);
}
