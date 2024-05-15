package com.mendozamatias.domain.dto.profesional;

import com.mendozamatias.domain.dto.especialidad.EspecialidadDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProfesionalDto {

    private Long id;

    private String nombre;

    private String apellido;

    private String email;

    private EspecialidadDto especialidad;

}
