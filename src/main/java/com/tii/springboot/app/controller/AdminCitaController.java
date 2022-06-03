
package com.tii.springboot.app.controller;

import com.tii.springboot.app.models.entity.AdminCita;
import com.tii.springboot.app.models.service.IAdminCitaService;
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
@SessionAttributes("adminCita")
public class AdminCitaController {
    
    @Autowired
    private IAdminCitaService adminCitaService;

    @RequestMapping(value = "/listarAdminCita", method = RequestMethod.GET)
    public String listarAdminCita(@RequestParam(name="page", defaultValue ="0") int page, Model model) {
        
        Pageable pageRequest=PageRequest.of(page, 5);
        Page<AdminCita> adminCitas =adminCitaService.findAllAdminCita(pageRequest);
        
        PageRender<AdminCita> pageRender = new PageRender<>("/listarAdminCita", adminCitas);
        
        model.addAttribute("titulo", "Listado de Citas");
        model.addAttribute("adminCitas", adminCitas);
        model.addAttribute("page", pageRender);

        return "listarAdminCita";
    }

    @RequestMapping(value = "/formAdminCita")
    public String crearAdminCita(Map<String, Object> model) {
        AdminCita adminCita = new AdminCita();
        model.put("adminCita", adminCita);
        model.put("titulo", "Formulario de las citas");
        return "formAdminCita";
    }

    @RequestMapping(value = "/formAdminCita/{idAdminCita}")
    public String editarAdminCita(@PathVariable(value="idAdminCita") Long idAdminCita, Map<String, Object> model, RedirectAttributes flash) {
        AdminCita adminCita = null;
        
        if(idAdminCita>0){
            adminCita= adminCitaService.findOneAdminCita(idAdminCita);
            if (adminCita == null) {
            flash.addFlashAttribute("error", "El ID de la Cita no existe en la base de datos");
            return "redirect:/listarAdminCita";    
            }
        } else{
            flash.addFlashAttribute("error", "El ID de la Cita no puede ser 0");
            return "redirect:/listarAdminCita";
        }
        model.put("adminCita", adminCita);
        model.put("titulo", "Formulario de Citas");
              
        return "formAdminCita";
    }

    @RequestMapping(value = "/formAdminCita", method = RequestMethod.POST)
    public String guardarAdminCita(@Valid AdminCita adminCita, BindingResult result, Model model,RedirectAttributes flash ,SessionStatus status) {
        if (result.hasErrors()) {
            model.addAttribute("titulo", "Formulario de las citas");
            return "formAdminCita";
        }
        String mensajeFlash= (adminCita.getIdAdminCita()!= null)? "Cita editada con exito!":"Cita creada con exito!";
        adminCita.toString();
        System.out.println("impreso"+ adminCita.toString());
        adminCitaService.saveAdminCita(adminCita);
        status.setComplete();
        flash.addFlashAttribute("success", mensajeFlash);
        //falta el /
        return "redirect:listarAdminCita";
    }
    
    @RequestMapping(value="/eliminar/{idAdminCita}")
    public String eliminarAdminCita(@PathVariable(value="idAdminCita") Long idAdminCita, RedirectAttributes flash){
        
        if(idAdminCita>0){
            adminCitaService.eliminarAdminCita(idAdminCita);
            flash.addFlashAttribute("success", "Cita eliminada con exito!");

        }
              
        return "redirect:/listarAdminCita";
    }
}
