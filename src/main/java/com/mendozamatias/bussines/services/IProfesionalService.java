package com.mendozamatias.bussines.services;

import com.mendozamatias.domain.dto.profesional.CrearProfesionalDto;
import com.mendozamatias.domain.dto.profesional.ProfesionalDto;
import com.mendozamatias.domain.entity.Profesional;

import java.util.List;

public interface IProfesionalService {

    List<ProfesionalDto> listarTodosLosProfesionales();

    ProfesionalDto crearUnProfesional(Long especialidadId , CrearProfesionalDto crearProfesionalDto);
    ProfesionalDto modificarClave(Long profesionalId,String clave);
    boolean existeProfesionalConEsteDni(int dni);
}
