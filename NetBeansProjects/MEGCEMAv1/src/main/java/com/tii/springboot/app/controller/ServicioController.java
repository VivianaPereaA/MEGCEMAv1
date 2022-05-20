/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tii.springboot.app.controller;

import com.tii.springboot.app.models.entity.Medico;
import com.tii.springboot.app.models.entity.Servicio;
import com.tii.springboot.app.models.service.IServicioService;
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
 * @author usuario
 */
@Controller
@SessionAttributes("servicio")
public class ServicioController {

    @Autowired
    private IServicioService servicioService;

    @RequestMapping(value = "/listarServicio", method = RequestMethod.GET)
    public String listarServicio(@RequestParam(name="page", defaultValue ="0") int page, Model model) {
        
        Pageable pageRequest=PageRequest.of(page, 5);
        Page<Servicio> servicios =servicioService.findAllServicio(pageRequest);
        
        PageRender<Servicio> pageRender = new PageRender<>("/listarServicio", servicios);
        
        model.addAttribute("titulo", "Listado de Servicios");
        model.addAttribute("servicios", servicios);
        model.addAttribute("page", pageRender);

        return "listarServicio";
    }
    
        @RequestMapping(value = "/formServicio")
    public String crear(Map<String, Object> model) {
        Servicio servicio = new Servicio();
        model.put("servicio", servicio);
        model.put("titulo", "Formulario de Servicios");
        return "formServicio";
    }
    
    @RequestMapping(value = "/formServicio/{id}")
    public String editar(@PathVariable(value="id") Long id, Map<String, Object> model, RedirectAttributes flash) {
        Servicio servicio = null;
        
        if(id>0){
            servicio= servicioService.findOneServicio(id);
            if (servicio == null) {
            flash.addFlashAttribute("error", "El ID del Servicio no existe en la base de datos");
            return "redirect:/listarServicio";    
            }
        } else{
            flash.addFlashAttribute("error", "El ID del Servicio no puede ser 0");
            return "redirect:/listarServicio";
        }
        model.put("servicio", servicio);
        model.put("titulo", "Formulario de Servicios");
              
        return "formServicio";
    }
    
    @RequestMapping(value = "/formServicio", method = RequestMethod.POST)
    public String guardar(@Valid Servicio servicio, BindingResult result, Model model,RedirectAttributes flash ,SessionStatus status) {
        if (result.hasErrors()) {
            model.addAttribute("titulo", "Formulario de servicios");
            return "formServicio";
        }
        String mensajeFlash= (servicio.getId() != null)? "Servicio editado con exito!":"Servicio creado con exito!";
        
        servicioService.saveServicio(servicio);
        status.setComplete();
        flash.addFlashAttribute("success", mensajeFlash);
        //falta el /
        return "redirect:listarServicio";
    }
    
}