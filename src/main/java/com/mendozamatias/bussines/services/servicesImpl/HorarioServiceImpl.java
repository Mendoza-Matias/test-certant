package com.mendozamatias.bussines.services.servicesImpl;

import com.mendozamatias.bussines.mapper.impl.HorarioMapper;
import com.mendozamatias.bussines.services.IHorarioService;
import com.mendozamatias.domain.dto.horario.CrearHorarioDto;
import com.mendozamatias.domain.dto.horario.HorarioDto;
import com.mendozamatias.domain.entity.Horario;
import com.mendozamatias.domain.entity.Profesional;
import com.mendozamatias.domain.entity.enums.EstadoTurno;
import com.mendozamatias.domain.exception.NotFoundException;
import com.mendozamatias.domain.repository.IHorarioRepository;
import com.mendozamatias.domain.repository.IProfesionalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Service
public class HorarioServiceImpl implements IHorarioService {
    @Autowired
    private IHorarioRepository horarioRepository;

    @Autowired
    private IProfesionalRepository profesionalRepository;

    @Autowired
    private HorarioMapper horarioMapper;

    @Override
    public List<HorarioDto> listarTodosLosHorariosDisponiblesDeUnEspecialista (Long profesionalId) {
        return horarioMapper.toDtoList(horarioRepository.findAllByProfesionalId(profesionalId));
    }

    @Override
    public HorarioDto crearUnHorario(Long profesionalId,CrearHorarioDto crearHorarioDto) {
        Profesional profesional = profesionalRepository.findById(profesionalId).orElseThrow(()-> new NotFoundException("Profesional no encontrado"));

        Horario horario = horarioMapper.toHorarioOfCrearHorarioDto(crearHorarioDto);
        horario.setEstado(EstadoTurno.DISPONIBLE);
        horario.setProfesional(profesional);

        return horarioMapper.toDto(horarioRepository.save(horario));
    }
}
