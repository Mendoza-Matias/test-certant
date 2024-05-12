package com.mendozamatias.bussines.services;

import com.mendozamatias.domain.dto.especialidad.EspecialidadDto;

import java.util.List;

public interface IEspecialidadService {

    List<EspecialidadDto> listarTodasLasEspecialidades();
    EspecialidadDto crearEspecialidad(String nombre);
    EspecialidadDto modificarEspecialidad(Long especialidadId , String nombre);
    boolean existeEspecialidadConNombre(String nombre);
}
