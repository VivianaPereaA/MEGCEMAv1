/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tii.springboot.app.controller;

import com.tii.springboot.app.models.entity.Encuesta;
import com.tii.springboot.app.models.service.IEncuestaService;
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
@SessionAttributes("encuesta")
public class EncuestaController {
    
    @Autowired
    private IEncuestaService encuestaService;

    @RequestMapping(value = "/listarEncuesta", method = RequestMethod.GET)
    public String listarEncuesta(@RequestParam(name="page", defaultValue ="0") int page, Model model) {
        
        Pageable pageRequest=PageRequest.of(page, 5);
        Page<Encuesta> encuestas =encuestaService.findAllEncuesta(pageRequest);
        
        PageRender<Encuesta> pageRender = new PageRender<>("/listarEncuesta", encuestas);
        
        model.addAttribute("titulo", "Listado de Encuestas");
        model.addAttribute("encuestas", encuestas);
        model.addAttribute("page", pageRender);

        return "listarEncuesta";
    }

    @RequestMapping(value = "/formEncuesta")
    public String crear(Map<String, Object> model) {
        Encuesta encuesta = new Encuesta();
        model.put("encuesta", encuesta);
        model.put("titulo", "Formulario de la Encuesta");
        return "formEncuesta";
    }

    @RequestMapping(value = "/formEncuesta/{idEncuesta}")
    public String editar(@PathVariable(value="idEncuesta") Long idEncuesta, Map<String, Object> model, RedirectAttributes flash) {
        Encuesta encuesta = null;
        
        if(idEncuesta>0){
            encuesta= encuestaService.findOneEncuesta(idEncuesta);
            if (encuesta == null) {
            flash.addFlashAttribute("error", "El ID de la Encuesta no existe en la base de datos");
            return "redirect:/listarEncuesta";    
            }
        } else{
            flash.addFlashAttribute("error", "El ID de la Encuesta no puede ser 0");
            return "redirect:/listarEncuesta";
        }
        model.put("encuesta", encuesta);
        model.put("titulo", "Formulario de la Encuesta");
              
        return "formEncuesta";
    }

    @RequestMapping(value = "/formEncuesta", method = RequestMethod.POST)
    public String guardarEncuesta(@Valid Encuesta encuesta, BindingResult result, Model model,RedirectAttributes flash ,SessionStatus status) {
        if (result.hasErrors()) {
            model.addAttribute("titulo", "Formulario del Medico");
            return "formEncuesta";
        }
        String mensajeFlash= (encuesta.getIdEncuesta() != null)? "Encuesta editado con exito!":"Encuesta creado con exito!";
        
        encuestaService.saveEncuesta(encuesta);
        status.setComplete();
        flash.addFlashAttribute("success", mensajeFlash);
        //falta el /
        return "redirect:listarEncuesta";
    }
    
    @RequestMapping(value="/eliminar/{idEncuesta}")
    public String eliminarEncuesta(@PathVariable(value="idEncuesta") Long idEncuesta, RedirectAttributes flash){
        
        if(idEncuesta>0){
            encuestaService.eliminarEncuesta(idEncuesta);
            flash.addFlashAttribute("success", "Encuesta eliminado con exito!");

        }
              
        return "redirect:/listarEncuesta";
    }
}
