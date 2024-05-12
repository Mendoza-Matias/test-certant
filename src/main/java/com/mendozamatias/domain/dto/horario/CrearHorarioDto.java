package com.mendozamatias.domain.dto.horario;

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
public class CrearHorarioDto {

    private LocalDate dia;

    private LocalTime horaDeInicio;

    private LocalTime horaDeFin;
}
