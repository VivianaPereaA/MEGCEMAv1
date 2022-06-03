package com.tii.springboot.app.controller;

import com.tii.springboot.app.models.entity.Paciente;
import com.tii.springboot.app.models.service.IPacienteService;
import com.tii.springboot.app.util.paginator.PageRender;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@SessionAttributes("paciente")
public class PacienteController {

    @Autowired
    private IPacienteService pacienteService;

    @GetMapping("/verPaciente/{id}")
    public String verPaciente(@PathVariable(value = "id") Long id, Map<String, Object> model, RedirectAttributes flash) {

        Paciente paciente = pacienteService.findOnePaciente(id);
        if (paciente == null) {
            flash.addFlashAttribute("error", "El Paciente no existe en la BD");
            return "redirect:/listarPacientes";
        }
        model.put("paciente", paciente);
        model.put("titulo", "Detalle del Paciente: " + paciente.getNombre());

        return "verPaciente";
    }

    @RequestMapping(value = "/listarPacientes", method = RequestMethod.GET)
    public String listarPaciente(@RequestParam(name="page", defaultValue = "0")int page, Model model) {
        
        Pageable pageRequest=PageRequest.of(page, 5);
        
        Page <Paciente> pacientes = pacienteService.findAllPaciente(pageRequest);
        
        PageRender <Paciente> pageRender = new PageRender<Paciente>("/listarPacientes", pacientes);
              
        model.addAttribute("titulo", "Listado de Pacientes");
        model.addAttribute("pacientes", pacienteService.findAllPaciente());
        model.addAttribute("page", pageRender);
        return "listarPacientes";
    }

    @RequestMapping(value = "/formPaciente")
    public String crearPaciente(Map<String, Object> model) {
        Paciente paciente = new Paciente();
        model.put("paciente", paciente);
        model.put("titulo", "Formulario de Paciente");
        return "formPaciente";
    }

    @RequestMapping(value = "/formPaciente/{id}")
    public String editarPaciente(@PathVariable(value = "id") Long id,
            Map<String, Object> model, RedirectAttributes flash) {
        
        Paciente paciente = null;

        if (id > 0) {
            paciente = pacienteService.findOnePaciente(id);
            if (paciente == null) {
                flash.addFlashAttribute("error", "El ID del Paciente no existe en la base de datos");
                return "redirect:/listarPacientes";
            }
        } else {
            flash.addFlashAttribute("error", "El ID del Paciente no puede ser 0");
            return "redirect:/listarPacientes";
        }
        model.put("paciente", paciente);
        model.put("titulo", "Editar Paciente");

        return "formPaciente";
    }

    @RequestMapping(value = "/formPaciente", method = RequestMethod.POST)
    public String guardarPaciente(@Valid Paciente paciente, BindingResult result, Model model,
            RedirectAttributes flash, SessionStatus status) {
        if (result.hasErrors()) {
            model.addAttribute("titulo", "Formulario del Paciente");
            return "formPaciente";
        }

        String mensajeFlash = (paciente.getId()!= null) ? "Paciente editado con exito!" : "Paciente creado con exito!";
        pacienteService.savePaciente(paciente);
        status.setComplete();
        flash.addFlashAttribute("success", mensajeFlash);
        return "redirect:listarPacientes";
    }

   /* @RequestMapping(value = "/eliminar/{id}")
    public String eliminarPaciente(@PathVariable(value = "id") Long id, RedirectAttributes flash) {

        if (id > 0) {
            pacienteService.eliminarPaciente(id);
            flash.addFlashAttribute("success", "Paciente eliminado con exito!");

        }

        return "redirect:/listarPacientes";
    }
*/
}
