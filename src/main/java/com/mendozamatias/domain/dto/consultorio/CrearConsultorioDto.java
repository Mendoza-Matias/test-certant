package com.mendozamatias.domain.dto.consultorio;

import com.mendozamatias.domain.dto.profesional.ProfesionalDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CrearConsultorioDto {

    private int numero;

    private ProfesionalDto profesional;
}
