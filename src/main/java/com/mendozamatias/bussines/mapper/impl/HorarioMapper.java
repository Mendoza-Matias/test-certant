package com.mendozamatias.bussines.mapper.impl;

import com.mendozamatias.bussines.mapper.IMapper;
import com.mendozamatias.domain.dto.horario.CrearHorarioDto;
import com.mendozamatias.domain.dto.horario.HorarioDto;
import com.mendozamatias.domain.entity.Horario;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring" , nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface HorarioMapper extends IMapper<Horario, HorarioDto> {
    Horario toHorarioOfCrearHorarioDto(CrearHorarioDto crearHorarioDto);
}
