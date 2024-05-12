package com.mendozamatias.domain.repository;

import com.mendozamatias.domain.entity.Consultorio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IConsultorioRepository extends JpaRepository<Consultorio,Long> {
    boolean existsByNumero(int numero);
}
