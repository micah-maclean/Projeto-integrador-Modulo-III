package com.senac.meditech.service;

import com.senac.meditech.data.PacienteEntity;
import com.senac.meditech.data.PacienteRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PacienteService {
    @Autowired
    PacienteRepository PacienteRepository;
    
    public PacienteEntity criarPaciente(PacienteEntity paciente) {
        paciente.setId(null);
        PacienteRepository.save(paciente);
        return paciente;
    }
    
    public PacienteEntity getPacienteById(Integer id) {
        return PacienteRepository.findById(id).orElse(null);
    }
    
    public List<PacienteEntity> listarTodosPacientes() {
        return PacienteRepository.findAll();
    }  
}
