package com.senac.meditech.service;

import com.senac.meditech.data.MedicoEntity;
import com.senac.meditech.data.MedicoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MedicoService {
    @Autowired
    MedicoRepository MedicoRepository;
    
    public MedicoEntity criarMedico(MedicoEntity medico) {
        medico.setId(null);
        MedicoRepository.save(medico);
        return medico;
    }
    
    public MedicoEntity getMedicoById(Integer id) {
        return MedicoRepository.findById(id).orElse(null);
    }
    
    public List<MedicoEntity> listarTodosMedicos() {
        return MedicoRepository.findAll();
    }  
}
