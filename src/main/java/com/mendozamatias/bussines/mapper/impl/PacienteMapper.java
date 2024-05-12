package com.mendozamatias.bussines.mapper.impl;

import com.mendozamatias.bussines.mapper.IMapper;
import com.mendozamatias.domain.dto.paciente.CrearPacienteDto;
import com.mendozamatias.domain.dto.paciente.PacienteDto;
import com.mendozamatias.domain.entity.Paciente;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring" , nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface PacienteMapper extends IMapper<Paciente,PacienteDto> {
    Paciente toPacienteOfCrearPacienteDto(CrearPacienteDto crearPacienteDto);
}
