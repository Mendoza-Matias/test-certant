package com.mendozamatias.presentation.advise;

import com.mendozamatias.domain.dto.generic.ExceptionErrorDto;
import com.mendozamatias.domain.exception.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ControlHandlerException {

    @ExceptionHandler(value = NotFoundException.class)
    @ResponseBody
    public ResponseEntity<ExceptionErrorDto> handleNotFoundException(NotFoundException exception){
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(new ExceptionErrorDto(exception.getMessage()));
    }

    @ExceptionHandler(value = PacienteException.class)
    @ResponseBody
    public ResponseEntity<ExceptionErrorDto> handlePacienteException(PacienteException exception){
        return ResponseEntity.status(HttpStatus.CONFLICT).body(new ExceptionErrorDto(exception.getMessage()));
    }

    @ExceptionHandler(value = TurnoException.class)
    @ResponseBody
    public ResponseEntity<ExceptionErrorDto> handleTurnoException(TurnoException exception){
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(new ExceptionErrorDto(exception.getMessage()));
    }

    @ExceptionHandler(value = ProfesionalException.class)
    @ResponseBody
    public ResponseEntity<ExceptionErrorDto> handleProfesionalException(ProfesionalException exception){
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(new ExceptionErrorDto(exception.getMessage()));
    }

    @ExceptionHandler(value = ConsultorioException.class)
    @ResponseBody
    public ResponseEntity<ExceptionErrorDto> handleConsultorioException(ConsultorioException exception){
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(new ExceptionErrorDto(exception.getMessage()));
    }

    @ExceptionHandler(value = EspecialidadException.class)
    @ResponseBody
    public ResponseEntity<ExceptionErrorDto> handleEspecialidadException(EspecialidadException exception){
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(new ExceptionErrorDto(exception.getMessage()));
    }

    @ExceptionHandler(value = HorarioException.class)
    @ResponseBody
    public ResponseEntity<ExceptionErrorDto> handleHorarioException(HorarioException exception){
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(new ExceptionErrorDto(exception.getMessage()));
    }


}
