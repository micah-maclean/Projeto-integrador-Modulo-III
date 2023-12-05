package com.senac.meditech.data;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsultaRepository extends JpaRepository<ConsultaEntity, Integer>{

    public List<ConsultaEntity> findByMedicoId(Integer medicoId);
    public List<ConsultaEntity> findByPacienteId(Integer pacienteId);
}
