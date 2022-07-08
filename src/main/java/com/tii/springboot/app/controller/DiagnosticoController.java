/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tii.springboot.app.controller;

import com.tii.springboot.app.models.entity.Diagnostico;
import com.tii.springboot.app.models.service.IDiagnosticoService;
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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author VIVIANA CRISTINA
 */
@Controller
@SessionAttributes("diagnostico")
public class DiagnosticoController {
    
    @Autowired
    private IDiagnosticoService diagnosticoService;
    
   @Autowired
   private IPacienteService pacienteService;

    @RequestMapping(value = "/listarDiagnostico", method = RequestMethod.GET)
    public String listarDiagnostico(@RequestParam(name="page", defaultValue ="0") int page, Model model) {
        
        Pageable pageRequest=PageRequest.of(page, 5);
        Page<Diagnostico> diagnosticos =diagnosticoService.findAllDiagnostico(pageRequest);
        
        PageRender<Diagnostico> pageRender = new PageRender<>("/listarDiagnostico", diagnosticos);
        
        model.addAttribute("titulo", "Listado de Diagnosticos");
        model.addAttribute("diagnosticos", diagnosticos);
        model.addAttribute("page", pageRender);

        return "listarDiagnostico";
    }

    @RequestMapping(value = "/formDiagnostico")
    public String crearDiagnostico(Map<String, Object> model, Model model2) {
        Diagnostico diagnostico = new Diagnostico();
        model.put("diagnostico", diagnostico);
        model.put("titulo", "Formulario del Diagnostico");
        model2.addAttribute("paciente",pacienteService.findAllPaciente());
        return "formDiagnostico";
    }

    @RequestMapping(value = "/formDiagnostico/{idDiagnostico}")
    public String editarDiagnostico(@PathVariable(value="idDiagnostico") Long idDiagnostico, Map<String, Object> model, RedirectAttributes flash) {
        Diagnostico diagnostico = null;
        
        if(idDiagnostico>0){
            diagnostico= diagnosticoService.findOneDiagnostico(idDiagnostico);
            if (diagnostico == null) {
            flash.addFlashAttribute("error", "El ID del Diagnostico no existe en la base de datos");
            return "redirect:/listarDiagnostico";    
            }
        } else{
            flash.addFlashAttribute("error", "El ID de la Diagnostico no puede ser 0");
            return "redirect:/listarDiagnostico";
        }
        model.put("diagnostico", diagnostico);
        model.put("titulo", "Formulario del Diagnostico");
              
        return "formDiagnostico";
    }

    @RequestMapping(value = "/formDiagnostico", method = RequestMethod.POST)
    public String guardarDiagnostico(@Valid Diagnostico diagnostico, BindingResult result, Model model,RedirectAttributes flash ,SessionStatus status) {
        if (result.hasErrors()) {
            model.addAttribute("titulo", "Formulario del Diagnostico");
            return "formDiagnostico";
        }
        String mensajeFlash= (diagnostico.getIdDiagnostico()!= null)? "Diagnostico editado con exito!":"Diagnostico creado con exito!";
        
        diagnosticoService.saveDiagnostico(diagnostico);
        status.setComplete();
        flash.addFlashAttribute("success", mensajeFlash);
        //falta el /
        return "redirect:listarDiagnostico";
    }
    
    @RequestMapping(value="/eliminarDiagnostico/{idDiagnostico}")
    public String eliminarDiagnostico(@PathVariable(value="idDiagnostico") Long idDiagnostico, RedirectAttributes flash){
        
        if(idDiagnostico>0){
            diagnosticoService.eliminarDiagnostico(idDiagnostico);
            flash.addFlashAttribute("success", "Diagnostico eliminado con exito!");

        }
              
        return "redirect:/listarDiagnostico";
    }
}
