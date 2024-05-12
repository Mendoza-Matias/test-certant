package com.mendozamatias.domain.dto.turno;

import com.mendozamatias.domain.dto.horario.HorarioDatosBasicosDto;
import com.mendozamatias.domain.dto.paciente.PacienteDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TurnoDto {

    private Long id;

    private PacienteDto paciente;

    private HorarioDatosBasicosDto horario;
}
