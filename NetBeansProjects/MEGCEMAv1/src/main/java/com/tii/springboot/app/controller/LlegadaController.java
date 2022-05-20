
package com.tii.springboot.app.controller;

import com.tii.springboot.app.models.entity.Llegada;
import com.tii.springboot.app.models.service.ILlegadaService;
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

@Controller
@SessionAttributes("llegada")
public class LlegadaController {
        @Autowired
    private ILlegadaService llegadaService;

    @RequestMapping(value = "/listarLlegada", method = RequestMethod.GET)
    public String listarLlegada(@RequestParam(name="page", defaultValue ="0") int page, Model model) {
        
        Pageable pageRequest=PageRequest.of(page, 5);
        Page<Llegada> llegadas =llegadaService.findAllLlegada(pageRequest);
        
        PageRender<Llegada> pageRender = new PageRender<>("/listarLlegada", llegadas);
        
        model.addAttribute("titulo", "Listado de Llegada");
        model.addAttribute("llegadas", llegadas);
        model.addAttribute("page", pageRender);

        return "listarLlegada";
    }

    @RequestMapping(value = "/formLlegada")
    public String crear(Map<String, Object> model) {
        Llegada llegada = new Llegada();
        model.put("llegada", llegada);
        model.put("titulo", "Formulario de Llegada");
        return "formLlegada";
    }

    @RequestMapping(value = "/formLlegada/{idLlegada}")
    public String editar(@PathVariable(value="idLlegada") Long idLlegada, Map<String, Object> model, RedirectAttributes flash) {
        Llegada llegada = null;
        
        if(idLlegada>0){
            llegada= llegadaService.findOneLlegada(idLlegada);
            if (llegada == null) {
            flash.addFlashAttribute("error", "El ID de la Llegada no existe en la base de datos");
            return "redirect:/listarLlegada";    
            }
        } else{
            flash.addFlashAttribute("error", "El ID de la Llegada no puede ser 0");
            return "redirect:/listarLlegada";
        }
        model.put("llegada", llegada);
        model.put("titulo", "Formulario de Llegada");
              
        return "formLlegada";
    }

    @RequestMapping(value = "/formLlegada", method = RequestMethod.POST)
    public String guardar(@Valid Llegada llegada, BindingResult result, Model model,RedirectAttributes flash ,SessionStatus status) {
        if (result.hasErrors()) {
            model.addAttribute("titulo", "Formulario de Llegada");
            return "formLlegada";
        }
        String mensajeFlash= (llegada.getIdLlegada()!= null)? "Llegada editada con exito!":"Llegada creada con exito!";
        
        llegadaService.saveLlegada(llegada);
        status.setComplete();
        flash.addFlashAttribute("success", mensajeFlash);
        //falta el /
        return "redirect:listarLlegada";
    }
    
    @RequestMapping(value="/eliminar/{idLlegada}")
    public String eliminar(@PathVariable(value="idLlegada") Long idLlegada, RedirectAttributes flash){
        
        if(idLlegada>0){
            llegadaService.eliminarLlegada(idLlegada);
            flash.addFlashAttribute("success", "Medico eliminado con exito!");

        }
              
        return "redirect:/listarLlegada";
    }
}
