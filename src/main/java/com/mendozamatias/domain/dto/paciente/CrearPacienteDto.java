package com.mendozamatias.domain.dto.paciente;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CrearPacienteDto {

    private String nombre;

    private String apellido;

    private int dni;

    private int edad;

    private String email;

    private String clave;
}
