package com.senac.meditech.data;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.util.Date;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

@Data
@Entity
@Table(name="consultas")
public class ConsultaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) 
    private Integer id;

    @NotNull(message="MedicoID obrigatório")
    private Integer medicoId;
    
    @NotNull(message="PacienteID obrigatório")
    private Integer pacienteId;
    
    @NotNull(message="Data obrigatório")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date data;
    
    @NotBlank(message="Horário obrigatória")
    private String horario;
}
