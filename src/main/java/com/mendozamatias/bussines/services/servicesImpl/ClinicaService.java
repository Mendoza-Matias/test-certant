package com.mendozamatias.bussines.services.servicesImpl;

import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Service
public class ClinicaService {

    public boolean verificarHorarioDeClinica(LocalDateTime horaActual) {
        return horaActual.getDayOfWeek().getValue() >= DayOfWeek.MONDAY.getValue()
                && horaActual.getDayOfWeek().getValue() <= DayOfWeek.SATURDAY.getValue()
                && horaActual.toLocalTime().isBefore(LocalTime.of(8,0))
                || horaActual.toLocalTime().isAfter(LocalTime.of(23,0));
    }

}
