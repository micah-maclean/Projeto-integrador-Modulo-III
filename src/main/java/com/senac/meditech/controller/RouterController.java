package com.senac.meditech.controller;

import com.senac.meditech.controller.model.Consulta;
import com.senac.meditech.controller.model.Medico;
import com.senac.meditech.controller.model.Paciente;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@Controller
public class RouterController {
    private final List<Paciente> pacientes = new ArrayList();
    private final List<Medico> medicos = new ArrayList(); 
    private final List<Consulta> consultas = new ArrayList(); 
    
    int seqPaciente = 0;
    int seqMedico = 0;
    int seqConsulta = 0;
    
    @GetMapping("/")
    public String getIndex(Model model){
        model.addAttribute("medicos", medicos);
        model.addAttribute("pacientes", pacientes);
        
        return "index";
    }
    
    @GetMapping("/detalhes/{tipo}/{id}")
    public String detalhes(Model model, @PathVariable(value = "tipo")String tipo, @PathVariable(value = "id")Integer id) {
        model.addAttribute("tipo", tipo);
        
        if(tipo.equals("medico")) {
            List<Medico> medico = medicos.stream().filter(a -> a.getId()== id ).collect(Collectors.toList());
            model.addAttribute("entity", medico.get(0));
        } else {
            List<Paciente> paciente = pacientes.stream().filter(a -> a.getId()== id ).collect(Collectors.toList());
            model.addAttribute("entity", paciente.get(0));
        }
        
        model.addAttribute("consultas", consultas);
        
        return "detalhes-pessoa";
    }
    
    @GetMapping("/cadastrar/{tipo}")
    public String cadastrar(Model model, @PathVariable(value = "tipo")String tipo) {
        model.addAttribute("tipo", tipo);
        model.addAttribute("atualizar", false);
        model.addAttribute("url", "cadastrar-" + tipo);
        
        switch(tipo){
            case "medico" -> {
                model.addAttribute("entity", new Medico());
            }
            case "paciente" -> {
                model.addAttribute("entity", new Paciente());
            }
            case "consulta" -> {
                model.addAttribute("medicos", medicos);
                model.addAttribute("pacientes", pacientes);
                model.addAttribute("entity", new Consulta());
            }
        }

        return "cadastro";
    }
    
    @GetMapping("/editar/{tipo}/{id}")
    public String editar(Model model, @PathVariable(value = "tipo")String tipo, @PathVariable(value = "id")Integer id) {
        model.addAttribute("tipo", tipo);
        model.addAttribute("atualizar", true);
        
         switch(tipo){
            case "medico" -> {
                List<Medico> medico = medicos.stream().filter(a -> a.getId()== id ).collect(Collectors.toList());
                model.addAttribute("entity", medico.get(0));
            }
            case "paciente" -> {
                List<Paciente> paciente = pacientes.stream().filter(a -> a.getId()== id ).collect(Collectors.toList());
                model.addAttribute("entity", paciente.get(0));
            }
            case "consulta" -> {
                List<Consulta> consulta = consultas.stream().filter(a -> a.getId()== id ).collect(Collectors.toList());
                model.addAttribute("entity", consulta.get(0));
                
                model.addAttribute("medicos", medicos);
                model.addAttribute("pacientes", pacientes);
            }
        }
        return "cadastro";
    }
    
    @PostMapping("cadastrar-medico")
    public String cadastrarMedico(@ModelAttribute Medico medico) {
        seqMedico = seqMedico + 1;
        medico.setId(seqMedico);
        medicos.add(medico);
        
        return "redirect:/detalhes/medico/" + medico.getId();
    }
    
    @PostMapping("cadastrar-paciente")
    public String cadastrarPaciente(@ModelAttribute Paciente paciente) {
        seqPaciente = seqPaciente + 1;
        paciente.setId(seqPaciente);
        pacientes.add(paciente);
        
        return "redirect:/detalhes/paciente/" + paciente.getId();
    }
    
    @PostMapping("cadastrar-consulta")
    public String cadastrarConsulta(@ModelAttribute Consulta consulta) {
        seqConsulta = seqConsulta + 1;
        consulta.setId(seqConsulta);
        consultas.add(consulta);
        
        return "redirect:/detalhes/paciente/" + consulta.getPacienteId(); 
    }    
}
