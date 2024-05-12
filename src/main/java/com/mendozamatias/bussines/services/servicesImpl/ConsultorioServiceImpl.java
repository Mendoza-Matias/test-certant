package com.mendozamatias.bussines.services.servicesImpl;

import com.mendozamatias.bussines.mapper.impl.ConsultorioMapper;
import com.mendozamatias.bussines.services.IConsultorioService;
import com.mendozamatias.domain.dto.consultorio.ConsultorioDto;
import com.mendozamatias.domain.entity.Consultorio;
import com.mendozamatias.domain.entity.Profesional;
import com.mendozamatias.domain.exception.ConsultorioException;
import com.mendozamatias.domain.exception.NotFoundException;
import com.mendozamatias.domain.repository.IConsultorioRepository;
import com.mendozamatias.domain.repository.IProfesionalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ConsultorioServiceImpl implements IConsultorioService {

    @Autowired
    private IConsultorioRepository consultorioRepository;

    @Autowired
    private IProfesionalRepository profesionalRepository;

    @Autowired
    private ConsultorioMapper consultorioMapper;

    @Override
    public List<ConsultorioDto> listarTodosLosConsultorios() {
        return consultorioMapper.toDtoList(consultorioRepository.findAll());
    }

    @Override
    public ConsultorioDto crearConsultorio(int numero) {
        if(existeConsultorioConNumero(numero)){
            throw new ConsultorioException("Ya existe el consultorio " + numero);
        }
        Consultorio consultorio = Consultorio.builder()
                .numero(numero)
                .build();
        return consultorioMapper.toDto(consultorioRepository.save(consultorio));
    }

    @Override
    public ConsultorioDto asignarProfesional(Long consultorioId , Long profesionalId) {

        Consultorio consultorio = consultorioRepository.findById(consultorioId).orElseThrow(()-> new NotFoundException("Consultorio no encontrado"));
        Profesional profesional = profesionalRepository.findById(profesionalId).orElseThrow(()-> new NotFoundException("Profesional no encontrado"));

        consultorio.setProfesional(profesional);

        return consultorioMapper.toDto(consultorioRepository.save(consultorio));
    }

    @Override
    public ConsultorioDto modificarProfesionalDeConsultorio(Long consultorioId, Long profesionalId) {

        Consultorio consultorio = consultorioRepository.findById(consultorioId).orElseThrow(()-> new NotFoundException("Consultorio no encontrado"));
        Profesional profesional = profesionalRepository.findById(profesionalId).orElseThrow(()-> new NotFoundException("Profesional no encontrado"));

        consultorio.setProfesional(profesional);

        return consultorioMapper.toDto(consultorioRepository.save(consultorio));
    }

    @Override
    public boolean existeConsultorioConNumero(int numero) {
        return consultorioRepository.existsByNumero(numero);
    }
}
