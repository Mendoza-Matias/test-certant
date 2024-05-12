package com.mendozamatias.bussines.mapper.impl;

import com.mendozamatias.bussines.mapper.IMapper;
import com.mendozamatias.domain.dto.consultorio.ConsultorioDto;
import com.mendozamatias.domain.entity.Consultorio;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface ConsultorioMapper extends IMapper<Consultorio,ConsultorioDto> {
}
