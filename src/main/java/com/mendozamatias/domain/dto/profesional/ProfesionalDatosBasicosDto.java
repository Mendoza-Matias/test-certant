package com.mendozamatias.domain.dto.profesional;

import com.mendozamatias.domain.dto.especialidad.EspecialidadDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProfesionalDatosBasicosDto {

    private Long id;

    private String nombre;

    private EspecialidadDto especialidad;
}
