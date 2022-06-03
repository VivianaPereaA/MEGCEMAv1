package com.tii.springboot.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tii.springboot.app.models.entity.Medico;
import com.tii.springboot.app.models.service.IMedicoService;
import com.tii.springboot.app.util.paginator.PageRender;

import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.data.domain.Page;

@Controller
@SessionAttributes("medico")
public class MedicoController {

    @Autowired
    private IMedicoService medicoService;

    @RequestMapping(value = "/listar", method = RequestMethod.GET)
    public String listar(@RequestParam(name="page", defaultValue ="0") int page, Model model) {
        
        Pageable pageRequest=PageRequest.of(page, 5);
        Page<Medico> medicos =medicoService.findAll(pageRequest);
        
        PageRender<Medico> pageRender = new PageRender<>("/listar", medicos);
        
        model.addAttribute("titulo", "Listado de Usuarios");
        model.addAttribute("medicos", medicos);
        model.addAttribute("page", pageRender);

        return "listar";
    }

    @RequestMapping(value = "/form")
    public String crear(Map<String, Object> model) {
        Medico medico = new Medico();
        model.put("medico", medico);
        model.put("titulo", "Formulario del Usuario");
        return "form";
    }

    @RequestMapping(value = "/form/{id}")
    public String editar(@PathVariable(value="id") Long id, Map<String, Object> model, RedirectAttributes flash) {
        Medico medico = null;
        
        if(id>0){
            medico= medicoService.findOne(id);
            if (medico == null) {
            flash.addFlashAttribute("error", "El ID del Usuario no existe en la base de datos");
            return "redirect:/listar";    
            }
        } else{
            flash.addFlashAttribute("error", "El ID del Usuario no puede ser 0");
            return "redirect:/listar";
        }
        model.put("medico", medico);
        model.put("titulo", "Formulario del Usuario");
              
        return "form";
    }

    @RequestMapping(value = "/form", method = RequestMethod.POST)
    public String guardar(@Valid Medico medico, BindingResult result, Model model,RedirectAttributes flash ,SessionStatus status) {
        if (result.hasErrors()) {
            model.addAttribute("titulo", "Formulario del Usuario");
            return "form";
        }
        String mensajeFlash= (medico.getId() != null)? "Usuario editado con exito!":"Usuario creado con exito!";
        
        medicoService.save(medico);
        status.setComplete();
        flash.addFlashAttribute("success", mensajeFlash);
        //falta el /
        return "redirect:listar";
    }
    
    @RequestMapping(value="/eliminar/{id}")
    public String eliminar(@PathVariable(value="id") Long id, RedirectAttributes flash){
        
        if(id>0){
            medicoService.eliminar(id);
            flash.addFlashAttribute("success", "Usuario eliminado con exito!");

        }
              
        return "redirect:/listar";
    }
}
