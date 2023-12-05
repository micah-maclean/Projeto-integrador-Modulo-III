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
@Table(name="medicos")
public class MedicoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) 
    private Integer id;
    
    @NotBlank(message="Nome obrigatório")
    private String nome;
    
    @NotBlank(message="Telefone obrigatório")
    private String telefone;
    
    @NotBlank(message="CPF obrigatório")
    private String cpf;
    
    @NotBlank(message="E-mail obrigatório")
    private String email;
    
    @NotNull(message="Data de nascimento obrigatório")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dataNascimento;
    
    @NotBlank(message="CMR obrigatório")
    private String cmr;
    
    @NotBlank(message="Especialidade obrigatória")
    private String especialidade;  
}
