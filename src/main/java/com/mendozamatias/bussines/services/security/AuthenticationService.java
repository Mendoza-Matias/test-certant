package com.mendozamatias.bussines.services.security;

import com.mendozamatias.domain.dto.autenticacion.AuthenticationRequest;
import com.mendozamatias.domain.dto.autenticacion.AuthenticationResponse;
import com.mendozamatias.domain.entity.Profesional;
import com.mendozamatias.domain.exception.NotFoundException;
import com.mendozamatias.domain.repository.IProfesionalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    @Autowired
    private IProfesionalRepository profesionalRepository;

    public AuthenticationResponse auth(AuthenticationRequest authenticationRequest){
        Profesional profesional = profesionalRepository.findByEmail(authenticationRequest.getEmail()).orElseThrow(()-> new NotFoundException("Profesional no encontrado"));

        return AuthenticationResponse.builder()
                .nombre(profesional.getNombre())
                .build();
    }

}
