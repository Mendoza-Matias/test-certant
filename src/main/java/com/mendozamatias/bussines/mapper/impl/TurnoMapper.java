package com.mendozamatias.bussines.mapper.impl;

import com.mendozamatias.bussines.mapper.IMapper;
import com.mendozamatias.domain.dto.turno.TurnoDto;
import com.mendozamatias.domain.entity.Turno;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring" , nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface TurnoMapper extends IMapper <Turno, TurnoDto> {
}
