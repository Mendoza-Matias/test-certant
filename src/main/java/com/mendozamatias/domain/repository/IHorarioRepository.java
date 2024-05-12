package com.mendozamatias.domain.repository;

import com.mendozamatias.domain.entity.Horario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IHorarioRepository extends JpaRepository<Horario,Long> {
    List <Horario> findAllByProfesionalId (Long profesionalId);
}
