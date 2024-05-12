package com.mendozamatias.bussines.services.servicesImpl;

import com.mendozamatias.bussines.mapper.impl.TurnoMapper;
import com.mendozamatias.bussines.services.ITurnoService;
import com.mendozamatias.domain.dto.turno.TurnoDto;
import com.mendozamatias.domain.entity.Horario;
import com.mendozamatias.domain.entity.Paciente;
import com.mendozamatias.domain.entity.Turno;
import com.mendozamatias.domain.entity.enums.EstadoTurno;
import com.mendozamatias.domain.exception.HorarioException;
import com.mendozamatias.domain.exception.NotFoundException;
import com.mendozamatias.domain.repository.IHorarioRepository;
import com.mendozamatias.domain.repository.IPacienteRepository;
import com.mendozamatias.domain.repository.ITurnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TurnoServiceImpl implements ITurnoService{
    @Autowired
    private ITurnoRepository turnoRepository;
    @Autowired
    private IHorarioRepository horarioRepository;
    @Autowired
    private IPacienteRepository pacienteRepository;
    @Autowired
    private ClinicaService clinicaService;
    @Autowired
    private TurnoMapper turnoMapper;

    @Override
    public List<TurnoDto> listarTurnosPorNombreDeEspecialidad(String nombreEspecialidad) {
        return turnoMapper.toDtoList(turnoRepository.findAllByHorario_Profesional_EspecialidadNombre(nombreEspecialidad));
    }

    @Override
    public List<TurnoDto> listarTurnosPorNombreDeProfesional(String nombreProfesional) {
        return turnoMapper.toDtoList(turnoRepository.findAllByHorario_ProfesionalNombre(nombreProfesional));
    }

    @Override
    public List<TurnoDto> listarTodosLosTurnosByPacienteId(Long pacienteId) {
        return turnoMapper.toDtoList(turnoRepository.findAllByPacienteId(pacienteId));
    }

    @Override
    public TurnoDto listarUnTurno(Long turnoId) {
        Turno turno = turnoRepository.findById(turnoId).orElseThrow(()-> new NotFoundException("Turno no encontrado"));
        return turnoMapper.toDto(turno);
    }

    @Override
    public TurnoDto solicitarTurno(Long horarioId, Long pacienteId) {

        if(clinicaService.verificarHorarioDeClinica(LocalDateTime.now())){
            throw new HorarioException("Solo se pueden realizar turnos de lunes a sabados , de 08:00 a 23:00");
        }

        Horario horario = horarioRepository.findById(horarioId).orElseThrow(()-> new NotFoundException("Horario no encontrado"));

        if(horario.getEstado() == EstadoTurno.ASIGNADO){
            throw new HorarioException("Este horario ya se encuentra asignado a un turno");
        }

        Paciente paciente = pacienteRepository.findById(pacienteId).orElseThrow(()-> new NotFoundException("Paciente no encontrado"));

        return turnoMapper.toDto(turnoRepository.save(Turno.builder()
                        .paciente(paciente)
                        .horario(horario)
                .build()));
    }

    @Override
    public TurnoDto cancelarTurno(Long turnoId) {

        Turno turno = turnoRepository.findById(turnoId).orElseThrow(()-> new NotFoundException("Turno no encontrado"));

        if(LocalDateTime.now().getHour() < turno.getHorario().getHoraDeInicio().getHour()){
            turno.getHorario().setEstado(EstadoTurno.CANCELADO);
        }
        else
        {
         throw new HorarioException("No es posible cancelar el turno");
        }

        return turnoMapper.toDto(turnoRepository.save(turno));
    }

    @Override
    public TurnoDto modificarEstadoAAtendido(Long turnoId) {
        Turno turno = turnoRepository.findById(turnoId).orElseThrow(()-> new NotFoundException("Turno no encontrado"));
        turno.getHorario().setEstado(EstadoTurno.ATENDIDO);
        return turnoMapper.toDto(turnoRepository.save(turno));
    }


}
