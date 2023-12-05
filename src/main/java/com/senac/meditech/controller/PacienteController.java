package com.senac.meditech.controller;

import com.senac.meditech.data.PacienteEntity;
import com.senac.meditech.service.PacienteService;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController 
@RequestMapping("/paciente")  
public class PacienteController {
    @Autowired 
    PacienteService pacienteService; 
    
   @GetMapping("/listar") 
   public ResponseEntity<List> getAllPacientes() {
       List<PacienteEntity> pacientes = pacienteService.listarTodosPacientes();
       return new ResponseEntity<>(pacientes, HttpStatus.OK);
   } 
   
   @GetMapping("/pesquisar/{id}")
   public ResponseEntity<PacienteEntity> getPacienteById(@PathVariable Integer id) {
       PacienteEntity paciente = pacienteService.getPacienteById(id);
       return new ResponseEntity<>(paciente, HttpStatus.OK);
   }
   
   @PostMapping("/adicionar")
   public ResponseEntity<PacienteEntity> addPaciente(@Valid @RequestBody PacienteEntity paciente) {
       PacienteEntity novoPaciente = pacienteService.criarPaciente(paciente);
       return new ResponseEntity<>(novoPaciente, HttpStatus.CREATED);
   }
}
