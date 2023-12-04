/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.senac.meditech.controller.model;

import java.util.Date;

/**
 *
 * @author kikam
 */
public class Medico extends Pessoa{
    private String cmr;
    private String especialidade;

    public Medico(String cmr, String especialidade, int id, String nome, String telefone, String cpf, Date dataNascimento, String email) {
        super(id, nome, telefone, cpf, dataNascimento, email);
        this.cmr = cmr;
        this.especialidade = especialidade;
    }

    public Medico() {
    }
    
    public String getCmr() {
        return cmr;
    }

    public void setCmr(String cmr) {
        this.cmr = cmr;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }
    
    
}
