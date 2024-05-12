package com.mendozamatias.domain.entity;

import com.mendozamatias.domain.entity.enums.EstadoTurno;
import com.mendozamatias.domain.validation.DateValidation;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "horarios")


@AllArgsConstructor
@NoArgsConstructor
@Data
public class Horario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @DateValidation
    @Column(name = "dia")
    private LocalDate dia;

    @Column(name = "hora_inicio")
    private LocalTime horaDeInicio;

    @Column(name = "hora_fin")
    private LocalTime horaDeFin;

    @Column(name = "estado_turno")
    @Enumerated(EnumType.STRING)
    private EstadoTurno estado;

    @ManyToOne
    private Profesional profesional;
}
