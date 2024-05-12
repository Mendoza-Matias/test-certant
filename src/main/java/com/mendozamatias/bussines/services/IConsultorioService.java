package com.mendozamatias.bussines.services;

import com.mendozamatias.domain.dto.consultorio.ConsultorioDto;

import java.util.List;

public interface IConsultorioService {

    List<ConsultorioDto> listarTodosLosConsultorios();

    ConsultorioDto crearConsultorio(int numero);

    ConsultorioDto asignarProfesional(Long consultorioId , Long profesionalId);

    ConsultorioDto modificarProfesionalDeConsultorio(Long consultorioId,Long profesionalId);

    boolean existeConsultorioConNumero(int numero);
}
