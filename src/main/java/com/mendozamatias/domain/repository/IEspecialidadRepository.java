package com.mendozamatias.domain.repository;

import com.mendozamatias.domain.entity.Especialidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEspecialidadRepository extends JpaRepository<Especialidad,Long> {

    boolean existsByNombre(String nombre);
}
