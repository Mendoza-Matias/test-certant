package com.mendozamatias.bussines.services.servicesImpl;

import com.mendozamatias.bussines.mapper.impl.EspecialidadMapper;
import com.mendozamatias.bussines.services.IEspecialidadService;
import com.mendozamatias.domain.dto.especialidad.EspecialidadDto;
import com.mendozamatias.domain.entity.Especialidad;
import com.mendozamatias.domain.exception.EspecialidadException;
import com.mendozamatias.domain.exception.NotFoundException;
import com.mendozamatias.domain.repository.IEspecialidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EspecialidadServiceImpl implements IEspecialidadService {

    @Autowired
    private IEspecialidadRepository especialidadRepository;

    @Autowired
    private EspecialidadMapper especialidadMapper;

    @Override
    public List<EspecialidadDto> listarTodasLasEspecialidades() {
        return especialidadMapper.toDtoList(especialidadRepository.findAll());
    }

    @Override
    public EspecialidadDto crearEspecialidad(String nombre) {

        if(existeEspecialidadConNombre(nombre)){
            throw new EspecialidadException("La especialidad " + nombre + " ya existe.");
        }

        Especialidad especialidad = Especialidad.builder()
                .nombre(nombre)
                .build();

        return especialidadMapper.toDto(especialidadRepository.save(especialidad));
    }

    @Override
    public EspecialidadDto modificarEspecialidad(Long especialidadId, String nombre) {
        Especialidad especialidad = especialidadRepository.findById(especialidadId).orElseThrow(()-> new NotFoundException("Especialidad no encontrada"));
        especialidad.setNombre(nombre);
        return especialidadMapper.toDto(especialidadRepository.save(especialidad));
    }

    @Override
    public boolean existeEspecialidadConNombre(String nombre) {
        return especialidadRepository.existsByNombre(nombre);
    }
}
