/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tii.springboot.app.controller;

import com.tii.springboot.app.models.entity.Especialidades;
import com.tii.springboot.app.models.service.IEspecialidadesService;
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
@SessionAttributes("especialidades")
public class EspecialidadesController {

    @Autowired
    private IEspecialidadesService especialidadesService;

    @RequestMapping(value = "/listarEspecialidades", method = RequestMethod.GET)
    public String listarEspecialidades(@RequestParam(name = "page", defaultValue = "0") int page, Model model) {

        Pageable pageRequest = PageRequest.of(page, 5);
        Page<Especialidades> especialidades = especialidadesService.findAllEspecialidades(pageRequest);

        PageRender<Especialidades> pageRender = new PageRender<>("/listarEspecialidades", especialidades);

        model.addAttribute("titulo", "Listado de Especialidades");
        model.addAttribute("especialidades", especialidades);
        model.addAttribute("page", pageRender);

        return "listarEspecialidades";
    }

    @RequestMapping(value = "/formEspecialidades")
    public String crearEspecialidades(Map<String, Object> model) {

        Especialidades especialidades = new Especialidades();
        model.put("especialidades", especialidades);
        model.put("titulo", "Formulario del Especialidad");

        return "formEspecialidades";
    }

    @RequestMapping(value = "/formEspecialidades/{id}")
    public String editarEspecialidades(@PathVariable(value = "id") Long id, Map<String, Object> model,RedirectAttributes flash) {
        Especialidades especialidades = null;
        if (id > 0) {
            especialidades = especialidadesService.findOneEspecialidades(id);
            if (especialidades == null) {
                flash.addFlashAttribute("error", "El ID de la Especialidad no existe en la base de datos");
                return "redirect:/listarEspecialidades";
            }
        } else {
            flash.addFlashAttribute("error", "El ID de la Especialidad no puede ser 0");
            return "redirect:/listarEspecialidades";
        }
        model.put("especialidades", especialidades);
        model.put("titulo", "Formulario del Estado de la Cita");

        return "formEspecialidades";
    }

    @RequestMapping(value = "/formEspecialidades", method = RequestMethod.POST)
    public String guardarEspecialidades(@Valid Especialidades especialidades, BindingResult result, Model model, RedirectAttributes flash, SessionStatus status) {
        if (result.hasErrors()) {
            model.addAttribute("titulo", "Formulario de la Especialidad");
            return "formEspecialidades";
        }
        String mensajeFlash = (especialidades.getId()!= null) ? "Especialidad editado con exito!" : "Especialidad creado con exito!";

        especialidadesService.saveEspecialidades(especialidades);
        status.setComplete();
        flash.addFlashAttribute("success", mensajeFlash);
        //falta el /
        return "redirect:listarEspecialidades";
    }

    @RequestMapping(value = "/eliminarEspecialidades/{id}")
    public String eliminarEspecialidades(@PathVariable(value = "id") Long id, RedirectAttributes flash) {

        if (id > 0) {
            especialidadesService.eliminarEspecialidades(id);
            flash.addFlashAttribute("success", "Especialidad eliminado con exito!");

        }

        return "redirect:/listarEspecialidades";
    }
}

