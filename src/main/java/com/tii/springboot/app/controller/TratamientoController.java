/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tii.springboot.app.controller;

import com.tii.springboot.app.models.entity.Tratamiento;
import com.tii.springboot.app.models.service.ITratamientoService;
import com.tii.springboot.app.util.paginator.PageRender;
import java.util.ArrayList;
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
@SessionAttributes("tratamiento")
public class TratamientoController {

    @Autowired
    private ITratamientoService tratamientoService;

    @RequestMapping(value = "/listarTratamiento", method = RequestMethod.GET)
    public String listar(@RequestParam(name = "page", defaultValue = "0") int page, Model model) {

        Pageable pageRequest = PageRequest.of(page, 5);
        Page<Tratamiento> tratamientos = tratamientoService.findAllTratamiento(pageRequest);

        PageRender<Tratamiento> pageRender = new PageRender<>("/listarTratamiento", tratamientos);

        model.addAttribute("titulo", "Lista de Tratamientos");
        model.addAttribute("tratamientos", tratamientos);
        model.addAttribute("page", pageRender);

        return "listarTratamiento";
    }

    @RequestMapping(value = "/formTratamiento")
    public String crearTratamiento(Map<String, Object> model) {
        Tratamiento tratamiento = new Tratamiento();
        model.put("tratamiento", tratamiento);
        model.put("titulo", "Formulario del Tratamiento");
        return "formTratamiento";
    }

    @RequestMapping(value = "/formTratamiento/{id}")
    public String editarTratamiento(@PathVariable(value = "id") Long id, Map<String, Object> model, RedirectAttributes flash) {
        Tratamiento tratamiento = null;

        if (id > 0) {
            tratamiento = tratamientoService.findOneTratamiento(id);
            if (tratamiento == null) {
                flash.addFlashAttribute("error", "El ID del Tratamiento no existe en la base de datos");
                return "redirect:/listarTratamiento";
            }
        } else {
            flash.addFlashAttribute("error", "El ID del Tratamiento no puede ser 0");
            return "redirect:/listarTratamiento";
        }
        model.put("tratamiento", tratamiento);
        model.put("titulo", "Formulario del Tratamiento");

        return "formTratamiento";
    }

    @RequestMapping(value = "/formTratamiento", method = RequestMethod.POST)
    public String guardarTratamiento(@Valid Tratamiento tratamiento, BindingResult result, Model model, RedirectAttributes flash, SessionStatus status) {
        if (result.hasErrors()) {
            model.addAttribute("titulo", "Formulario del Tratamiento");
            return "formTratamiento";
        }
        String mensajeFlash = (tratamiento.getId() != null) ? "Tratamiento editado con exito!" : "Tratamiento creado con exito!";

        tratamientoService.saveTratamiento(tratamiento);
        status.setComplete();
        flash.addFlashAttribute("success", mensajeFlash);
        //falta el /
        return "redirect:listarTratamiento";
    }

    @RequestMapping(value = "/eliminar/{idT}")
    public String eliminarTratamiento(@PathVariable(value = "idT") Long idT, RedirectAttributes flash) {

        if (idT > 0) {
            tratamientoService.eliminarTratamiento(idT);
            flash.addFlashAttribute("success", "Tratamiento eliminado con exito!");

        }

        return "redirect:/listarTratamiento";
    }
}
