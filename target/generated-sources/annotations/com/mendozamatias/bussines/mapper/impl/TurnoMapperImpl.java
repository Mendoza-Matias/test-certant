package com.mendozamatias.bussines.mapper.impl;

import com.mendozamatias.domain.dto.especialidad.EspecialidadDto;
import com.mendozamatias.domain.dto.horario.HorarioDatosBasicosDto;
import com.mendozamatias.domain.dto.paciente.PacienteDto;
import com.mendozamatias.domain.dto.profesional.ProfesionalDatosBasicosDto;
import com.mendozamatias.domain.dto.turno.TurnoDto;
import com.mendozamatias.domain.entity.Especialidad;
import com.mendozamatias.domain.entity.Horario;
import com.mendozamatias.domain.entity.Paciente;
import com.mendozamatias.domain.entity.Profesional;
import com.mendozamatias.domain.entity.Turno;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-15T08:22:32-0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.10 (Oracle Corporation)"
)
@Component
public class TurnoMapperImpl implements TurnoMapper {

    @Override
    public Turno toEntity(TurnoDto dto) {
        if ( dto == null ) {
            return null;
        }

        Turno.TurnoBuilder turno = Turno.builder();

        if ( dto.getId() != null ) {
            turno.id( dto.getId() );
        }
        if ( dto.getHorario() != null ) {
            turno.horario( horarioDatosBasicosDtoToHorario( dto.getHorario() ) );
        }
        if ( dto.getPaciente() != null ) {
            turno.paciente( pacienteDtoToPaciente( dto.getPaciente() ) );
        }

        return turno.build();
    }

    @Override
    public TurnoDto toDto(Turno entity) {
        if ( entity == null ) {
            return null;
        }

        TurnoDto turnoDto = new TurnoDto();

        if ( entity.getId() != null ) {
            turnoDto.setId( entity.getId() );
        }
        if ( entity.getPaciente() != null ) {
            turnoDto.setPaciente( pacienteToPacienteDto( entity.getPaciente() ) );
        }
        if ( entity.getHorario() != null ) {
            turnoDto.setHorario( horarioToHorarioDatosBasicosDto( entity.getHorario() ) );
        }

        return turnoDto;
    }

    @Override
    public List<Turno> toEntityList(List<TurnoDto> dtos) {
        if ( dtos == null ) {
            return null;
        }

        List<Turno> list = new ArrayList<Turno>( dtos.size() );
        for ( TurnoDto turnoDto : dtos ) {
            list.add( toEntity( turnoDto ) );
        }

        return list;
    }

    @Override
    public List<TurnoDto> toDtoList(List<Turno> entities) {
        if ( entities == null ) {
            return null;
        }

        List<TurnoDto> list = new ArrayList<TurnoDto>( entities.size() );
        for ( Turno turno : entities ) {
            list.add( toDto( turno ) );
        }

        return list;
    }

    protected Especialidad especialidadDtoToEspecialidad(EspecialidadDto especialidadDto) {
        if ( especialidadDto == null ) {
            return null;
        }

        Especialidad.EspecialidadBuilder especialidad = Especialidad.builder();

        if ( especialidadDto.getId() != null ) {
            especialidad.id( especialidadDto.getId() );
        }
        if ( especialidadDto.getNombre() != null ) {
            especialidad.nombre( especialidadDto.getNombre() );
        }

        return especialidad.build();
    }

    protected Profesional profesionalDatosBasicosDtoToProfesional(ProfesionalDatosBasicosDto profesionalDatosBasicosDto) {
        if ( profesionalDatosBasicosDto == null ) {
            return null;
        }

        Profesional profesional = new Profesional();

        if ( profesionalDatosBasicosDto.getId() != null ) {
            profesional.setId( profesionalDatosBasicosDto.getId() );
        }
        if ( profesionalDatosBasicosDto.getNombre() != null ) {
            profesional.setNombre( profesionalDatosBasicosDto.getNombre() );
        }
        if ( profesionalDatosBasicosDto.getEspecialidad() != null ) {
            profesional.setEspecialidad( especialidadDtoToEspecialidad( profesionalDatosBasicosDto.getEspecialidad() ) );
        }

        return profesional;
    }

    protected Horario horarioDatosBasicosDtoToHorario(HorarioDatosBasicosDto horarioDatosBasicosDto) {
        if ( horarioDatosBasicosDto == null ) {
            return null;
        }

        Horario horario = new Horario();

        if ( horarioDatosBasicosDto.getId() != null ) {
            horario.setId( horarioDatosBasicosDto.getId() );
        }
        if ( horarioDatosBasicosDto.getHoraDeInicio() != null ) {
            horario.setHoraDeInicio( horarioDatosBasicosDto.getHoraDeInicio() );
        }
        if ( horarioDatosBasicosDto.getEstado() != null ) {
            horario.setEstado( horarioDatosBasicosDto.getEstado() );
        }
        if ( horarioDatosBasicosDto.getProfesional() != null ) {
            horario.setProfesional( profesionalDatosBasicosDtoToProfesional( horarioDatosBasicosDto.getProfesional() ) );
        }

        return horario;
    }

    protected Paciente pacienteDtoToPaciente(PacienteDto pacienteDto) {
        if ( pacienteDto == null ) {
            return null;
        }

        Paciente paciente = new Paciente();

        if ( pacienteDto.getId() != null ) {
            paciente.setId( pacienteDto.getId() );
        }
        if ( pacienteDto.getNombre() != null ) {
            paciente.setNombre( pacienteDto.getNombre() );
        }
        if ( pacienteDto.getApellido() != null ) {
            paciente.setApellido( pacienteDto.getApellido() );
        }
        paciente.setDni( (long) pacienteDto.getDni() );
        paciente.setEdad( pacienteDto.getEdad() );

        return paciente;
    }

    protected PacienteDto pacienteToPacienteDto(Paciente paciente) {
        if ( paciente == null ) {
            return null;
        }

        PacienteDto pacienteDto = new PacienteDto();

        if ( paciente.getId() != null ) {
            pacienteDto.setId( paciente.getId() );
        }
        if ( paciente.getNombre() != null ) {
            pacienteDto.setNombre( paciente.getNombre() );
        }
        if ( paciente.getApellido() != null ) {
            pacienteDto.setApellido( paciente.getApellido() );
        }
        if ( paciente.getDni() != null ) {
            pacienteDto.setDni( paciente.getDni().intValue() );
        }
        pacienteDto.setEdad( paciente.getEdad() );

        return pacienteDto;
    }

    protected EspecialidadDto especialidadToEspecialidadDto(Especialidad especialidad) {
        if ( especialidad == null ) {
            return null;
        }

        EspecialidadDto especialidadDto = new EspecialidadDto();

        if ( especialidad.getId() != null ) {
            especialidadDto.setId( especialidad.getId() );
        }
        if ( especialidad.getNombre() != null ) {
            especialidadDto.setNombre( especialidad.getNombre() );
        }

        return especialidadDto;
    }

    protected ProfesionalDatosBasicosDto profesionalToProfesionalDatosBasicosDto(Profesional profesional) {
        if ( profesional == null ) {
            return null;
        }

        ProfesionalDatosBasicosDto profesionalDatosBasicosDto = new ProfesionalDatosBasicosDto();

        if ( profesional.getId() != null ) {
            profesionalDatosBasicosDto.setId( profesional.getId() );
        }
        if ( profesional.getNombre() != null ) {
            profesionalDatosBasicosDto.setNombre( profesional.getNombre() );
        }
        if ( profesional.getEspecialidad() != null ) {
            profesionalDatosBasicosDto.setEspecialidad( especialidadToEspecialidadDto( profesional.getEspecialidad() ) );
        }

        return profesionalDatosBasicosDto;
    }

    protected HorarioDatosBasicosDto horarioToHorarioDatosBasicosDto(Horario horario) {
        if ( horario == null ) {
            return null;
        }

        HorarioDatosBasicosDto horarioDatosBasicosDto = new HorarioDatosBasicosDto();

        if ( horario.getId() != null ) {
            horarioDatosBasicosDto.setId( horario.getId() );
        }
        if ( horario.getHoraDeInicio() != null ) {
            horarioDatosBasicosDto.setHoraDeInicio( horario.getHoraDeInicio() );
        }
        if ( horario.getEstado() != null ) {
            horarioDatosBasicosDto.setEstado( horario.getEstado() );
        }
        if ( horario.getProfesional() != null ) {
            horarioDatosBasicosDto.setProfesional( profesionalToProfesionalDatosBasicosDto( horario.getProfesional() ) );
        }

        return horarioDatosBasicosDto;
    }
}
