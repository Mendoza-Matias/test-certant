package com.mendozamatias.bussines.services;

import com.mendozamatias.domain.dto.paciente.CrearPacienteDto;
import com.mendozamatias.domain.dto.paciente.PacienteDto;

import java.util.List;

public interface IPacienteService {
    List<PacienteDto> listarTodosLosPaciente();
    PacienteDto crearUnPaciente(CrearPacienteDto crearPacienteDto);

    boolean existePacienteConDni(int dni);
}
