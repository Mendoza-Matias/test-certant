package com.mendozamatias.bussines.mapper.impl;

import com.mendozamatias.domain.dto.consultorio.ConsultorioDto;
import com.mendozamatias.domain.dto.especialidad.EspecialidadDto;
import com.mendozamatias.domain.dto.profesional.ProfesionalDto;
import com.mendozamatias.domain.entity.Consultorio;
import com.mendozamatias.domain.entity.Especialidad;
import com.mendozamatias.domain.entity.Profesional;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-15T08:22:34-0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.10 (Oracle Corporation)"
)
@Component
public class ConsultorioMapperImpl implements ConsultorioMapper {

    @Override
    public Consultorio toEntity(ConsultorioDto dto) {
        if ( dto == null ) {
            return null;
        }

        Consultorio.ConsultorioBuilder consultorio = Consultorio.builder();

        if ( dto.getId() != null ) {
            consultorio.id( dto.getId() );
        }
        consultorio.numero( dto.getNumero() );
        if ( dto.getProfesional() != null ) {
            consultorio.profesional( profesionalDtoToProfesional( dto.getProfesional() ) );
        }

        return consultorio.build();
    }

    @Override
    public ConsultorioDto toDto(Consultorio entity) {
        if ( entity == null ) {
            return null;
        }

        ConsultorioDto consultorioDto = new ConsultorioDto();

        if ( entity.getId() != null ) {
            consultorioDto.setId( entity.getId() );
        }
        consultorioDto.setNumero( entity.getNumero() );
        if ( entity.getProfesional() != null ) {
            consultorioDto.setProfesional( profesionalToProfesionalDto( entity.getProfesional() ) );
        }

        return consultorioDto;
    }

    @Override
    public List<Consultorio> toEntityList(List<ConsultorioDto> dtos) {
        if ( dtos == null ) {
            return null;
        }

        List<Consultorio> list = new ArrayList<Consultorio>( dtos.size() );
        for ( ConsultorioDto consultorioDto : dtos ) {
            list.add( toEntity( consultorioDto ) );
        }

        return list;
    }

    @Override
    public List<ConsultorioDto> toDtoList(List<Consultorio> entities) {
        if ( entities == null ) {
            return null;
        }

        List<ConsultorioDto> list = new ArrayList<ConsultorioDto>( entities.size() );
        for ( Consultorio consultorio : entities ) {
            list.add( toDto( consultorio ) );
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
