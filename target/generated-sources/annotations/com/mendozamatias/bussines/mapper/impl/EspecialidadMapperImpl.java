package com.mendozamatias.bussines.mapper.impl;

import com.mendozamatias.domain.dto.especialidad.EspecialidadDto;
import com.mendozamatias.domain.entity.Especialidad;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-15T11:00:31-0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.10 (Oracle Corporation)"
)
@Component
public class EspecialidadMapperImpl implements EspecialidadMapper {

    @Override
    public Especialidad toEntity(EspecialidadDto dto) {
        if ( dto == null ) {
            return null;
        }

        Especialidad.EspecialidadBuilder especialidad = Especialidad.builder();

        if ( dto.getId() != null ) {
            especialidad.id( dto.getId() );
        }
        if ( dto.getNombre() != null ) {
            especialidad.nombre( dto.getNombre() );
        }

        return especialidad.build();
    }

    @Override
    public EspecialidadDto toDto(Especialidad entity) {
        if ( entity == null ) {
            return null;
        }

        EspecialidadDto especialidadDto = new EspecialidadDto();

        if ( entity.getId() != null ) {
            especialidadDto.setId( entity.getId() );
        }
        if ( entity.getNombre() != null ) {
            especialidadDto.setNombre( entity.getNombre() );
        }

        return especialidadDto;
    }

    @Override
    public List<Especialidad> toEntityList(List<EspecialidadDto> dtos) {
        if ( dtos == null ) {
            return null;
        }

        List<Especialidad> list = new ArrayList<Especialidad>( dtos.size() );
        for ( EspecialidadDto especialidadDto : dtos ) {
            list.add( toEntity( especialidadDto ) );
        }

        return list;
    }

    @Override
    public List<EspecialidadDto> toDtoList(List<Especialidad> entities) {
        if ( entities == null ) {
            return null;
        }

        List<EspecialidadDto> list = new ArrayList<EspecialidadDto>( entities.size() );
        for ( Especialidad especialidad : entities ) {
            list.add( toDto( especialidad ) );
        }

        return list;
    }
}
