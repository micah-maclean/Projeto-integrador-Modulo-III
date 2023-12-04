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
public class Paciente extends Pessoa {
    private String numeroSUS;

    public Paciente(String numeroSUS, int id, String nome, String telefone, String cpf, Date dataNascimento, String email) {
        super(id, nome, telefone, cpf, dataNascimento, email);
        this.numeroSUS = numeroSUS;
    }

    public Paciente() {
    }

    public String getNumeroSUS() {
        return numeroSUS;
    }

    public void setNumeroSUS(String numeroSUS) {
        this.numeroSUS = numeroSUS;
    }
    
    
}
