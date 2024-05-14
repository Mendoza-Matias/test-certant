package com.mendozamatias.bussines.mapper.impl;

import com.mendozamatias.domain.dto.especialidad.EspecialidadDto;
import com.mendozamatias.domain.dto.profesional.CrearProfesionalDto;
import com.mendozamatias.domain.dto.profesional.ProfesionalDto;
import com.mendozamatias.domain.entity.Especialidad;
import com.mendozamatias.domain.entity.Profesional;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-14T10:02:56-0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.10 (Oracle Corporation)"
)
@Component
public class ProfesionalMapperImpl implements ProfesionalMapper {

    @Override
    public Profesional toEntity(ProfesionalDto dto) {
        if ( dto == null ) {
            return null;
        }

        Profesional profesional = new Profesional();

        if ( dto.getId() != null ) {
            profesional.setId( dto.getId() );
        }
        if ( dto.getNombre() != null ) {
            profesional.setNombre( dto.getNombre() );
        }
        if ( dto.getApellido() != null ) {
            profesional.setApellido( dto.getApellido() );
        }
        if ( dto.getEspecialidad() != null ) {
            profesional.setEspecialidad( especialidadDtoToEspecialidad( dto.getEspecialidad() ) );
        }

        return profesional;
    }

    @Override
    public ProfesionalDto toDto(Profesional entity) {
        if ( entity == null ) {
            return null;
        }

        ProfesionalDto profesionalDto = new ProfesionalDto();

        if ( entity.getId() != null ) {
            profesionalDto.setId( entity.getId() );
        }
        if ( entity.getNombre() != null ) {
            profesionalDto.setNombre( entity.getNombre() );
        }
        if ( entity.getApellido() != null ) {
            profesionalDto.setApellido( entity.getApellido() );
        }
        if ( entity.getEspecialidad() != null ) {
            profesionalDto.setEspecialidad( especialidadToEspecialidadDto( entity.getEspecialidad() ) );
        }

        return profesionalDto;
    }

    @Override
    public List<Profesional> toEntityList(List<ProfesionalDto> dtos) {
        if ( dtos == null ) {
            return null;
        }

        List<Profesional> list = new ArrayList<Profesional>( dtos.size() );
        for ( ProfesionalDto profesionalDto : dtos ) {
            list.add( toEntity( profesionalDto ) );
        }

        return list;
    }

    @Override
    public List<ProfesionalDto> toDtoList(List<Profesional> entities) {
        if ( entities == null ) {
            return null;
        }

        List<ProfesionalDto> list = new ArrayList<ProfesionalDto>( entities.size() );
        for ( Profesional profesional : entities ) {
            list.add( toDto( profesional ) );
        }

        return list;
    }

    @Override
    public Profesional toProfesionalOfCrearProfesionalDto(CrearProfesionalDto crearProfesionalDto) {
        if ( crearProfesionalDto == null ) {
            return null;
        }

        Profesional profesional = new Profesional();

        if ( crearProfesionalDto.getNombre() != null ) {
            profesional.setNombre( crearProfesionalDto.getNombre() );
        }
        if ( crearProfesionalDto.getApellido() != null ) {
            profesional.setApellido( crearProfesionalDto.getApellido() );
        }
        profesional.setDni( crearProfesionalDto.getDni() );
        if ( crearProfesionalDto.getEmail() != null ) {
            profesional.setEmail( crearProfesionalDto.getEmail() );
        }
        if ( crearProfesionalDto.getClave() != null ) {
            profesional.setClave( crearProfesionalDto.getClave() );
        }

        return profesional;
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
}
