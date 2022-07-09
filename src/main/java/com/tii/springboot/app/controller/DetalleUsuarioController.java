/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tii.springboot.app.controller;

import com.tii.springboot.app.models.entity.DetalleUsuario;
import com.tii.springboot.app.models.service.IDetalleUsuarioService;
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
@SessionAttributes("detalleUsuario")
public class DetalleUsuarioController {

    @Autowired
    private IDetalleUsuarioService detalleUsuarioService;

    @RequestMapping(value = "/listarDetalleUsuario", method = RequestMethod.GET)
    public String listarDetalleUsuario(@RequestParam(name = "page", defaultValue = "0") int page, Model model) {

        Pageable pageRequest = PageRequest.of(page, 5);
        Page<DetalleUsuario> detalleUsuario = detalleUsuarioService.findAllDetalleUsuario(pageRequest);

        PageRender<DetalleUsuario> pageRender = new PageRender<>("/listarDetalleUsuario", detalleUsuario);

        model.addAttribute("titulo", "Listado de Detalle de Usuario");
        model.addAttribute("detalleUsuario", detalleUsuario);
        model.addAttribute("page", pageRender);

        return "listarDetalleUsuario";
    }

    @RequestMapping(value = "/formDetalleUsuario")
    public String crearDetalleUsuario(Map<String, Object> model) {

        DetalleUsuario detalleUsuario = new DetalleUsuario();
        model.put("detalleUsuario", detalleUsuario);
        model.put("titulo", "Formulario del Detalle del Usuario");

        return "formDetalleUsuario";
    }

    @RequestMapping(value = "/formDetalleUsuario/{id}")
    public String editarDetalleUsuario(@PathVariable(value = "id") Long id, Map<String, Object> model,RedirectAttributes flash) {
        DetalleUsuario detalleUsuario = null;
        if (id > 0) {
            detalleUsuario = detalleUsuarioService.findOneDetalleUsuario(id);
            if (detalleUsuario == null) {
                flash.addFlashAttribute("error", "El ID del Detalle del Usuario no existe en la base de datos");
                return "redirect:/listarDetalleUsuario";
            }
        } else {
            flash.addFlashAttribute("error", "El ID del Detalle del Usuario no puede ser 0");
            return "redirect:/listarDetalleUsuario";
        }
        model.put("detalleUsuario", detalleUsuario);
        model.put("titulo", "Formulario del Detalle del Usuario");

        return "formDetalleUsuario";
    }

    @RequestMapping(value = "/formDetalleUsuario", method = RequestMethod.POST)
    public String guardarDetalleUsuario(@Valid DetalleUsuario detalleUsuario, BindingResult result, Model model, RedirectAttributes flash, SessionStatus status) {
        if (result.hasErrors()) {
            model.addAttribute("titulo", "Formulario del Detallle del Usuario");
            return "formDetalleUsuario";
        }
        String mensajeFlash = (detalleUsuario.getId()!= null) ? "Detalle del Usuario editado con exito!" : "Detalle del Usuario creado con exito!";

        detalleUsuarioService.saveDetalleUsuario(detalleUsuario);
        status.setComplete();
        flash.addFlashAttribute("success", mensajeFlash);
        //falta el /
        return "redirect:listarDetalleUsuario";
    }

    @RequestMapping(value = "/eliminarDetalleUsuario/{id}")
    public String eliminarDetalleUsuario(@PathVariable(value = "id") Long id, RedirectAttributes flash) {

        if (id > 0) {
            detalleUsuarioService.eliminarDetalleUsuario(id);
            flash.addFlashAttribute("success", "Detalle de Usuario eliminado con exito!");

        }

        return "redirect:/listarDetalleUsuario";
    }
}


