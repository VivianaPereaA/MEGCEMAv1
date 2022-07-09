/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tii.springboot.app.controller;

import com.tii.springboot.app.models.entity.EstadoCita;
import com.tii.springboot.app.models.service.IEstadoCitaService;
import com.tii.springboot.app.util.paginator.PageRender;
import java.util.List;
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
@SessionAttributes("estadoCita")
public class EstadoCitaController {

    @Autowired
    private IEstadoCitaService estadoCitaService;

    @RequestMapping(value = "/listarEstadoCita", method = RequestMethod.GET)
    public String listarEstadoCita(@RequestParam(name = "page", defaultValue = "0") int page, Model model) {

        Pageable pageRequest = PageRequest.of(page, 5);
        Page<EstadoCita> estadoCitas = estadoCitaService.findAllEstadoCita(pageRequest);

        PageRender<EstadoCita> pageRender = new PageRender<>("/listarEstadoCita", estadoCitas);

        model.addAttribute("titulo", "Listado de Estado de Citas");
        model.addAttribute("estadoCitas", estadoCitas);
        model.addAttribute("page", pageRender);

        return "listarEstadoCita";
    }

    @RequestMapping(value = "/formEstadoCita")
    public String crearlistarEstadoCita(Map<String, Object> model) {

        EstadoCita estadoCita = new EstadoCita();
        model.put("estadoCita", estadoCita);
        model.put("titulo", "Formulario del Estado de las Citas");

        return "formEstadoCita";
    }

    @RequestMapping(value = "/formEstadoCita/{id}")
    public String editarEstadoCita(@PathVariable(value = "id") Long id, Map<String, Object> model,RedirectAttributes flash) {
        EstadoCita estadoCita = null;
        if (id > 0) {
            estadoCita = estadoCitaService.findOneEstadoCita(id);
            if (estadoCita == null) {
                flash.addFlashAttribute("error", "El ID del Estado de la Cita no existe en la base de datos");
                return "redirect:/listarEstadoCita";
            }
        } else {
            flash.addFlashAttribute("error", "El ID del Estado de la Cita no puede ser 0");
            return "redirect:/listarEstadoCita";
        }
        model.put("estadoCita", estadoCita);
        model.put("titulo", "Formulario del Estado de la Cita");

        return "formEstadoCita";
    }

    @RequestMapping(value = "/formEstadoCita", method = RequestMethod.POST)
    public String guardarEstadoCita(@Valid EstadoCita estadoCita, BindingResult result, Model model, RedirectAttributes flash, SessionStatus status) {
        if (result.hasErrors()) {
            model.addAttribute("titulo", "Formulario del Estado de la Cita");
            return "formEstadoCita";
        }
        String mensajeFlash = (estadoCita.getId()!= null) ? "Estado de Cita editado con exito!" : "Estado de Cita creado con exito!";

        estadoCitaService.saveEstadoCita(estadoCita);
        status.setComplete();
        flash.addFlashAttribute("success", mensajeFlash);
        //falta el /
        return "redirect:listarEstadoCita";
    }

    @RequestMapping(value = "/eliminarEstadoCita/{id}")
    public String eliminarEstadoCita(@PathVariable(value = "id") Long id, RedirectAttributes flash) {

        if (id > 0) {
            estadoCitaService.eliminarEstadoCita(id);
            flash.addFlashAttribute("success", "Estado de cita eliminado con exito!");

        }

        return "redirect:/listarEstadoCita";
    }
}
