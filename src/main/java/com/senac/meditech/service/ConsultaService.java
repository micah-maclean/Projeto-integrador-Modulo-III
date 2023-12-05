package com.senac.meditech.service;

import com.senac.meditech.data.ConsultaEntity;
import com.senac.meditech.data.ConsultaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConsultaService {
    @Autowired
    ConsultaRepository consultaRepository;
    
    public ConsultaEntity criarConsulta(ConsultaEntity consulta) {
        consulta.setId(null);
        consultaRepository.save(consulta);
        return consulta;
    }
    
    public ConsultaEntity getConsultaById(Integer id) {
        return consultaRepository.findById(id).orElse(null);
    }
    
    public List<ConsultaEntity> listarTodasConsultas() {
        return consultaRepository.findAll();
    }  
    
    public List<ConsultaEntity> getConsultaByMedicoId(Integer id) {
        return consultaRepository.findByMedicoId(id);
    }
    
    public List<ConsultaEntity> getConsultaByPacienteId(Integer id) {
        return consultaRepository.findByPacienteId(id);
    }
}
