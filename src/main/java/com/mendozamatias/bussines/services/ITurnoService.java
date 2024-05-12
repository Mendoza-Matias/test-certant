package com.mendozamatias.bussines.services;

import com.mendozamatias.domain.dto.turno.TurnoDto;

import java.time.LocalDateTime;
import java.util.List;

public interface ITurnoService{

    TurnoDto listarUnTurno(Long turnoId);
    TurnoDto solicitarTurno(Long horarioId, Long pacienteId);
    List<TurnoDto> listarTodosLosTurnosByPacienteId(Long pacienteId);
    List<TurnoDto> listarTurnosPorNombreDeEspecialidad(String especialidad);
    List<TurnoDto>  listarTurnosPorNombreDeProfesional(String profesional);
    TurnoDto cancelarTurno(Long turnoId);
    TurnoDto modificarEstadoAAtendido(Long turnoId);

}
