package com.mendozamatias.domain.dto.horario;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.mendozamatias.domain.dto.profesional.ProfesionalDto;
import com.mendozamatias.domain.entity.enums.EstadoTurno;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class HorarioDto {

    private Long id;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate dia;

    @JsonFormat(pattern = "HH:mm")
    private LocalTime horaDeInicio;

    @JsonFormat(pattern = "HH:mm")
    private LocalTime horaDeFin;

    private EstadoTurno estado;

    private ProfesionalDto profesional;
}
