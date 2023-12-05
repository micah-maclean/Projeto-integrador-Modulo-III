package com.senac.meditech.controller;

import com.senac.meditech.controller.model.Consulta;
import com.senac.meditech.controller.model.Medico;
import com.senac.meditech.controller.model.Paciente;
import com.senac.meditech.data.ConsultaEntity;
import com.senac.meditech.data.MedicoEntity;
import com.senac.meditech.data.PacienteEntity;
import com.senac.meditech.service.MedicoService;
import com.senac.meditech.service.PacienteService;
import com.senac.meditech.service.ConsultaService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RouterController {
//    private final List<Paciente> pacientes = new ArrayList();;
//    private final List<Medico> medicos = new ArrayList(); 
//    private final List<Consulta> consultas = new ArrayList(); 
//    
//    int seqPaciente = 0;
//    int seqMedico = 0;
//    int seqConsulta = 0;
    
    @Autowired 
    MedicoService medicoService;
    @Autowired 
    PacienteService pacienteService;
    @Autowired 
    ConsultaService consultaService;
    
    @GetMapping("/")
    public String getIndex(Model model){
        model.addAttribute("medicos", medicoService.listarTodosMedicos());
        model.addAttribute("pacientes", pacienteService.listarTodosPacientes());
//        model.addAttribute("medicos", medicos);;
//        model.addAttribute("pacientes", pacientes);
        
        return "index";
    }
    
    @GetMapping("/detalhes/{tipo}/{id}")
    public String detalhes(Model model, @PathVariable(value = "tipo")String tipo, @PathVariable(value = "id")Integer id) {
        model.addAttribute("tipo", tipo);
        
        if(tipo.equals("medico")) {
            MedicoEntity medico = medicoService.getMedicoById(id);
            model.addAttribute("entity", medico);
            model.addAttribute("consultas", consultaService.getConsultaByPacienteId(id));
        } else {
            PacienteEntity paciente = pacienteService.getPacienteById(id);
            model.addAttribute("entity", paciente);
            model.addAttribute("consultas", consultaService.getConsultaByPacienteId(id));
        }
        
        //TODO: consulta por id de medico ou por id de paciente
//        model.addAttribute("consultas", consultas);
        
        return "detalhes-pessoa";
    }
    
    @GetMapping("/cadastrar/{tipo}")
    public String cadastrar(Model model, @PathVariable(value = "tipo")String tipo) {
        model.addAttribute("tipo", tipo);
        model.addAttribute("atualizar", false);
        model.addAttribute("url", "cadastrar-" + tipo);
        
        switch(tipo){
            case "medico" -> {
                model.addAttribute("entity", new MedicoEntity());
            }
            case "paciente" -> {
                model.addAttribute("entity", new PacienteEntity());
            }
            case "consulta" -> {
                model.addAttribute("medicos", medicoService.listarTodosMedicos());
                model.addAttribute("pacientes", pacienteService.listarTodosPacientes());
                model.addAttribute("entity", new ConsultaEntity());
            }
        }

        return "cadastro";
    }
        
    @PostMapping("cadastrar-medico")
    public String cadastrarMedico(@ModelAttribute MedicoEntity medico) {
        medicoService.criarMedico(medico);
        
        return "redirect:/detalhes/medico/" + medico.getId();
    }
    
    @PostMapping("cadastrar-paciente")
    public String cadastrarPaciente(@ModelAttribute PacienteEntity paciente) {
        pacienteService.criarPaciente(paciente);
        
        return "redirect:/detalhes/paciente/" + paciente.getId();
    }
    
    @PostMapping("cadastrar-consulta")
    public String cadastrarConsulta(@ModelAttribute ConsultaEntity consulta) {
        consultaService.criarConsulta(consulta);
        
        return "redirect:/detalhes/paciente/" + consulta.getPacienteId(); 
    }    
}
