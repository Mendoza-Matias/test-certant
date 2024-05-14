package com.mendozamatias.domain.dto.horario;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.mendozamatias.domain.dto.profesional.ProfesionalDatosBasicosDto;
import com.mendozamatias.domain.entity.enums.EstadoTurno;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class HorarioDatosBasicosDto {

    private Long id;

    @JsonFormat(pattern = "HH:mm")
    private LocalTime horaDeInicio;

    private EstadoTurno estado;

    private ProfesionalDatosBasicosDto profesional;
}
