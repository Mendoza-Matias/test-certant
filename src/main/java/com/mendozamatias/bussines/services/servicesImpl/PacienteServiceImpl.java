package com.mendozamatias.bussines.services.servicesImpl;

import com.mendozamatias.bussines.mapper.impl.PacienteMapper;
import com.mendozamatias.bussines.services.IPacienteService;
import com.mendozamatias.domain.dto.paciente.CrearPacienteDto;
import com.mendozamatias.domain.dto.paciente.PacienteDto;
import com.mendozamatias.domain.entity.Paciente;
import com.mendozamatias.domain.entity.enums.Rol;
import com.mendozamatias.domain.exception.PacienteException;
import com.mendozamatias.domain.repository.IPacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacienteServiceImpl implements IPacienteService {

    @Autowired
    private IPacienteRepository pacienteRepository;
    @Autowired
    private PacienteMapper pacienteMapper;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public List<PacienteDto> listarTodosLosPaciente() {
        return pacienteMapper.toDtoList(pacienteRepository.findAll());
    }

    @Override
    public PacienteDto crearUnPaciente(CrearPacienteDto crearPacienteDto) {

        if(existePacienteConDni(crearPacienteDto.getDni())){
            throw new PacienteException("Ya existe un paciente con estos datos");
        }

        Paciente paciente = pacienteMapper.toPacienteOfCrearPacienteDto(crearPacienteDto);
        paciente.setClave(passwordEncoder.encode(crearPacienteDto.getClave()));
        paciente.setRol(Rol.PACIENTE);

        return pacienteMapper.toDto(pacienteRepository.save(paciente));
    }

    @Override
    public boolean existePacienteConDni(int dni) {
        return pacienteRepository.existsByDni(dni);
    }
}
