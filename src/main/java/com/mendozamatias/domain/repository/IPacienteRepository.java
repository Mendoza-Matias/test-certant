package com.mendozamatias.domain.repository;

import com.mendozamatias.domain.entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPacienteRepository extends JpaRepository<Paciente,Long> {
    boolean existsByDni(int dni);
}
