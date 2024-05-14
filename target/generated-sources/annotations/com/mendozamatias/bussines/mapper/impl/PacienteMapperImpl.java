package com.mendozamatias.bussines.mapper.impl;

import com.mendozamatias.domain.dto.paciente.CrearPacienteDto;
import com.mendozamatias.domain.dto.paciente.PacienteDto;
import com.mendozamatias.domain.entity.Paciente;
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
public class PacienteMapperImpl implements PacienteMapper {

    @Override
    public Paciente toEntity(PacienteDto dto) {
        if ( dto == null ) {
            return null;
        }

        Paciente paciente = new Paciente();

        if ( dto.getId() != null ) {
            paciente.setId( dto.getId() );
        }
        if ( dto.getNombre() != null ) {
            paciente.setNombre( dto.getNombre() );
        }
        if ( dto.getApellido() != null ) {
            paciente.setApellido( dto.getApellido() );
        }
        paciente.setDni( (long) dto.getDni() );
        paciente.setEdad( dto.getEdad() );

        return paciente;
    }

    @Override
    public PacienteDto toDto(Paciente entity) {
        if ( entity == null ) {
            return null;
        }

        PacienteDto pacienteDto = new PacienteDto();

        if ( entity.getId() != null ) {
            pacienteDto.setId( entity.getId() );
        }
        if ( entity.getNombre() != null ) {
            pacienteDto.setNombre( entity.getNombre() );
        }
        if ( entity.getApellido() != null ) {
            pacienteDto.setApellido( entity.getApellido() );
        }
        if ( entity.getDni() != null ) {
            pacienteDto.setDni( entity.getDni().intValue() );
        }
        pacienteDto.setEdad( entity.getEdad() );

        return pacienteDto;
    }

    @Override
    public List<Paciente> toEntityList(List<PacienteDto> dtos) {
        if ( dtos == null ) {
            return null;
        }

        List<Paciente> list = new ArrayList<Paciente>( dtos.size() );
        for ( PacienteDto pacienteDto : dtos ) {
            list.add( toEntity( pacienteDto ) );
        }

        return list;
    }

    @Override
    public List<PacienteDto> toDtoList(List<Paciente> entities) {
        if ( entities == null ) {
            return null;
        }

        List<PacienteDto> list = new ArrayList<PacienteDto>( entities.size() );
        for ( Paciente paciente : entities ) {
            list.add( toDto( paciente ) );
        }

        return list;
    }

    @Override
    public Paciente toPacienteOfCrearPacienteDto(CrearPacienteDto crearPacienteDto) {
        if ( crearPacienteDto == null ) {
            return null;
        }

        Paciente paciente = new Paciente();

        if ( crearPacienteDto.getNombre() != null ) {
            paciente.setNombre( crearPacienteDto.getNombre() );
        }
        if ( crearPacienteDto.getApellido() != null ) {
            paciente.setApellido( crearPacienteDto.getApellido() );
        }
        paciente.setDni( (long) crearPacienteDto.getDni() );
        paciente.setEdad( crearPacienteDto.getEdad() );
        if ( crearPacienteDto.getEmail() != null ) {
            paciente.setEmail( crearPacienteDto.getEmail() );
        }
        if ( crearPacienteDto.getClave() != null ) {
            paciente.setClave( crearPacienteDto.getClave() );
        }

        return paciente;
    }
}
