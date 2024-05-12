package com.mendozamatias.bussines.services.servicesImpl;

import com.mendozamatias.bussines.mapper.impl.ProfesionalMapper;
import com.mendozamatias.bussines.services.IProfesionalService;
import com.mendozamatias.domain.dto.profesional.CrearProfesionalDto;
import com.mendozamatias.domain.dto.profesional.ProfesionalDto;
import com.mendozamatias.domain.entity.Especialidad;
import com.mendozamatias.domain.entity.Profesional;
import com.mendozamatias.domain.entity.enums.Rol;
import com.mendozamatias.domain.exception.NotFoundException;
import com.mendozamatias.domain.exception.ProfesionalException;
import com.mendozamatias.domain.repository.IEspecialidadRepository;
import com.mendozamatias.domain.repository.IProfesionalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfesionalServiceImpl implements IProfesionalService {
    @Autowired
    private IProfesionalRepository profesionalRepository;
    @Autowired
    private IEspecialidadRepository especialidadRepository;
    @Autowired
    private ProfesionalMapper profesionalMapper;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public List<ProfesionalDto> listarTodosLosProfesionales() {
        return profesionalMapper.toDtoList(profesionalRepository.findAll());
    }

    @Override
    public ProfesionalDto crearUnProfesional(Long especialidadId , CrearProfesionalDto crearProfesionalDto) {

        if(existeProfesionalConEsteDni(crearProfesionalDto.getDni())){
            throw new ProfesionalException("Ya existe un profesional con estos datos");
        }

        Especialidad especialidad = especialidadRepository.findById(especialidadId).orElseThrow(()-> new NotFoundException("Especialidad no encontrada"));

        Profesional profesional = profesionalMapper.toProfesionalOfCrearProfesionalDto(crearProfesionalDto);
        profesional.setClave(passwordEncoder.encode(crearProfesionalDto.getClave()));
        profesional.setRol(Rol.PROFESIONAL);
        profesional.setEspecialidad(especialidad);

        return profesionalMapper.toDto(profesionalRepository.save(profesional));
    }

    @Override
    public boolean existeProfesionalConEsteDni(int dni) {
        return profesionalRepository.existsByDni(dni);
    }
}
