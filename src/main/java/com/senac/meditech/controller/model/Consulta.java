/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.senac.meditech.controller.model;

import java.time.LocalDate;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author kikam
 */
public class Consulta {
    private int id;
    private int medicoId;
    private int pacienteId;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date data;
    private String horario;

    public Consulta(int id, int medicoId, int pacienteId, Date data, String horario) {
        this.id = id;
        this.medicoId = medicoId;
        this.pacienteId = pacienteId;
        this.data = data;
        this.horario = horario;
    }

    public Consulta() {
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMedicoId() {
        return medicoId;
    }

    public void setMedicoId(int medicoId) {
        this.medicoId = medicoId;
    }

    public int getPacienteId() {
        return pacienteId;
    }

    public void setPacienteId(int pacienteId) {
        this.pacienteId = pacienteId;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }
    
    
    
}
