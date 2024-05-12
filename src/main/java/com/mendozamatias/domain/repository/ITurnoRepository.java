package com.mendozamatias.domain.repository;

import com.mendozamatias.domain.entity.Turno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ITurnoRepository extends JpaRepository<Turno,Long> {
    List<Turno> findAllByPacienteId(Long pacienteId);
    List<Turno> findAllByHorario_Profesional_EspecialidadNombre(String especialidad);
    List<Turno> findAllByHorario_ProfesionalNombre(String profesional);
}
