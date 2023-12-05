package com.senac.meditech.controller;

import com.senac.meditech.data.ConsultaEntity;
import com.senac.meditech.service.ConsultaService;
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
@RequestMapping("/consulta")  
public class ConsultaController {
    @Autowired 
    ConsultaService consultaService; 
    
   @GetMapping("/listar") 
   public ResponseEntity<List> getAllConsultas() {
       List<ConsultaEntity> Consultas = consultaService.listarTodasConsultas();
       return new ResponseEntity<>(Consultas, HttpStatus.OK);
   } 
   
   @GetMapping("/pesquisar/{id}")
   public ResponseEntity<ConsultaEntity> getConsultaById(@PathVariable Integer id) {
       ConsultaEntity consulta = consultaService.getConsultaById(id);
       return new ResponseEntity<>(consulta, HttpStatus.OK);
   }
   
   @PostMapping("/adicionar")
   public ResponseEntity<ConsultaEntity> addConsulta(@Valid @RequestBody ConsultaEntity consulta) {
       ConsultaEntity novoConsulta = consultaService.criarConsulta(consulta);
       return new ResponseEntity<>(novoConsulta, HttpStatus.CREATED);
   }
}
