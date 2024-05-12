package com.mendozamatias.bussines.services;

import com.mendozamatias.domain.dto.horario.CrearHorarioDto;
import com.mendozamatias.domain.dto.horario.HorarioDto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface IHorarioService {

    List<HorarioDto> listarTodosLosHorariosDisponiblesDeUnEspecialista (Long profesionalId);
    HorarioDto crearUnHorario(Long profesionalDni , CrearHorarioDto crearHorarioDto);
}
