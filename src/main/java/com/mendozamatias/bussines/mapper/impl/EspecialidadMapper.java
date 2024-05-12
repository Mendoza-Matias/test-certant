package com.mendozamatias.bussines.mapper.impl;

import com.mendozamatias.bussines.mapper.IMapper;
import com.mendozamatias.domain.dto.especialidad.EspecialidadDto;
import com.mendozamatias.domain.entity.Especialidad;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring" , nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface EspecialidadMapper extends IMapper<Especialidad, EspecialidadDto> {
}
