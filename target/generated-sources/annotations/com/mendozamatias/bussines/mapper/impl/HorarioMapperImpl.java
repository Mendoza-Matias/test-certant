package com.mendozamatias.bussines.mapper.impl;

import com.mendozamatias.domain.dto.especialidad.EspecialidadDto;
import com.mendozamatias.domain.dto.horario.CrearHorarioDto;
import com.mendozamatias.domain.dto.horario.HorarioDto;
import com.mendozamatias.domain.dto.profesional.ProfesionalDto;
import com.mendozamatias.domain.entity.Especialidad;
import com.mendozamatias.domain.entity.Horario;
import com.mendozamatias.domain.entity.Profesional;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-15T09:40:09-0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.10 (Oracle Corporation)"
)
@Component
public class HorarioMapperImpl implements HorarioMapper {

    @Override
    public Horario toEntity(HorarioDto dto) {
        if ( dto == null ) {
            return null;
        }

        Horario horario = new Horario();

        if ( dto.getId() != null ) {
            horario.setId( dto.getId() );
        }
        if ( dto.getDia() != null ) {
            horario.setDia( dto.getDia() );
        }
        if ( dto.getHoraDeInicio() != null ) {
            horario.setHoraDeInicio( dto.getHoraDeInicio() );
        }
        if ( dto.getHoraDeFin() != null ) {
            horario.setHoraDeFin( dto.getHoraDeFin() );
        }
        if ( dto.getEstado() != null ) {
            horario.setEstado( dto.getEstado() );
        }
        if ( dto.getProfesional() != null ) {
            horario.setProfesional( profesionalDtoToProfesional( dto.getProfesional() ) );
        }

        return horario;
    }

    @Override
    public HorarioDto toDto(Horario entity) {
        if ( entity == null ) {
            return null;
        }

        HorarioDto horarioDto = new HorarioDto();

        if ( entity.getId() != null ) {
            horarioDto.setId( entity.getId() );
        }
        if ( entity.getDia() != null ) {
            horarioDto.setDia( entity.getDia() );
        }
        if ( entity.getHoraDeInicio() != null ) {
            horarioDto.setHoraDeInicio( entity.getHoraDeInicio() );
        }
        if ( entity.getHoraDeFin() != null ) {
            horarioDto.setHoraDeFin( entity.getHoraDeFin() );
        }
        if ( entity.getEstado() != null ) {
            horarioDto.setEstado( entity.getEstado() );
        }
        if ( entity.getProfesional() != null ) {
            horarioDto.setProfesional( profesionalToProfesionalDto( entity.getProfesional() ) );
        }

        return horarioDto;
    }

    @Override
    public List<Horario> toEntityList(List<HorarioDto> dtos) {
        if ( dtos == null ) {
            return null;
        }

        List<Horario> list = new ArrayList<Horario>( dtos.size() );
        for ( HorarioDto horarioDto : dtos ) {
            list.add( toEntity( horarioDto ) );
        }

        return list;
    }

    @Override
    public List<HorarioDto> toDtoList(List<Horario> entities) {
        if ( entities == null ) {
            return null;
        }

        List<HorarioDto> list = new ArrayList<HorarioDto>( entities.size() );
        for ( Horario horario : entities ) {
            list.add( toDto( horario ) );
        }

        return list;
    }

    @Override
    public Horario toHorarioOfCrearHorarioDto(CrearHorarioDto crearHorarioDto) {
        if ( crearHorarioDto == null ) {
            return null;
        }

        Horario horario = new Horario();

        if ( crearHorarioDto.getDia() != null ) {
            horario.setDia( crearHorarioDto.getDia() );
        }
        if ( crearHorarioDto.getHoraDeInicio() != null ) {
            horario.setHoraDeInicio( crearHorarioDto.getHoraDeInicio() );
        }
        if ( crearHorarioDto.getHoraDeFin() != null ) {
            horario.setHoraDeFin( crearHorarioDto.getHoraDeFin() );
        }

        return horario;
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

    protected Profesional profesionalDtoToProfesional(ProfesionalDto profesionalDto) {
        if ( profesionalDto == null ) {
            return null;
        }

        Profesional profesional = new Profesional();

        if ( profesionalDto.getId() != null ) {
            profesional.setId( profesionalDto.getId() );
        }
        if ( profesionalDto.getNombre() != null ) {
            profesional.setNombre( profesionalDto.getNombre() );
        }
        if ( profesionalDto.getApellido() != null ) {
            profesional.setApellido( profesionalDto.getApellido() );
        }
        if ( profesionalDto.getEmail() != null ) {
            profesional.setEmail( profesionalDto.getEmail() );
        }
        if ( profesionalDto.getEspecialidad() != null ) {
            profesional.setEspecialidad( especialidadDtoToEspecialidad( profesionalDto.getEspecialidad() ) );
        }

        return profesional;
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

    protected ProfesionalDto profesionalToProfesionalDto(Profesional profesional) {
        if ( profesional == null ) {
            return null;
        }

        ProfesionalDto profesionalDto = new ProfesionalDto();

        if ( profesional.getId() != null ) {
            profesionalDto.setId( profesional.getId() );
        }
        if ( profesional.getNombre() != null ) {
            profesionalDto.setNombre( profesional.getNombre() );
        }
        if ( profesional.getApellido() != null ) {
            profesionalDto.setApellido( profesional.getApellido() );
        }
        if ( profesional.getEmail() != null ) {
            profesionalDto.setEmail( profesional.getEmail() );
        }
        if ( profesional.getEspecialidad() != null ) {
            profesionalDto.setEspecialidad( especialidadToEspecialidadDto( profesional.getEspecialidad() ) );
        }

        return profesionalDto;
    }
}
