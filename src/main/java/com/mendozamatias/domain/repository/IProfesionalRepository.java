package com.mendozamatias.domain.repository;

import com.mendozamatias.domain.entity.Profesional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IProfesionalRepository extends JpaRepository<Profesional,Long> {
    Optional<Profesional> findByEmail(String email);
    boolean existsByDni(int dni);
}
