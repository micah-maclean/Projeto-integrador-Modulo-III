package com.senac.meditech.controller;

import com.senac.meditech.data.MedicoEntity;
import com.senac.meditech.service.MedicoService;
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
@RequestMapping("/medico")  
public class MedicoController {
    @Autowired 
    MedicoService medicoService; 
    
   @GetMapping("/listar") 
   public ResponseEntity<List> getAllMedicos() {
       List<MedicoEntity> medicos = medicoService.listarTodosMedicos();
       return new ResponseEntity<>(medicos, HttpStatus.OK);
   } 
   
   @GetMapping("/pesquisar/{id}")
   public ResponseEntity<MedicoEntity> getMedicoById(@PathVariable Integer id) {
       MedicoEntity medico = medicoService.getMedicoById(id);
       return new ResponseEntity<>(medico, HttpStatus.OK);
   }
   
   @PostMapping("/adicionar")
   public ResponseEntity<MedicoEntity> addMedico(@Valid @RequestBody MedicoEntity medico) {
       MedicoEntity novoMedico = medicoService.criarMedico(medico);
       return new ResponseEntity<>(novoMedico, HttpStatus.CREATED);
   }
}
