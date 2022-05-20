package com.tii.springboot.app.controller;

import com.tii.springboot.app.models.entity.Medico;
import com.tii.springboot.app.models.entity.Turno;
import com.tii.springboot.app.models.service.IMedicoService;
import com.tii.springboot.app.models.service.ITurnoService;
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
@SessionAttributes("medico")
public class TurnoController {
    
    @Autowired
    private ITurnoService turnoService;

    @RequestMapping(value = "/listarTurno", method = RequestMethod.GET)
    public String listarTurno(@RequestParam(name="page", defaultValue ="0") int page, Model model) {
        
        Pageable pageRequest=PageRequest.of(page, 5);
        Page<Turno> turnos =turnoService.findAllTurno(pageRequest);
        
        PageRender<Turno> pageRender = new PageRender<>("/listarTurno", turnos);
        
        model.addAttribute("titulo", "Listado de Turnos");
        model.addAttribute("turnos", turnos);
        model.addAttribute("page", pageRender);

        return "listarTurno";
    }

    @RequestMapping(value = "/formTurno")
    public String crearTurno(Map<String, Object> model) {
        Turno turno = new Turno();
        model.put("turno", turno);
        model.put("titulo", "Formulario de Turnos");
        return "formTurno";
    }

    @RequestMapping(value = "/formTurno/{idTurno}")
    public String editarTurno(@PathVariable(value="idTurno") Long idTurno, Map<String, Object> model, RedirectAttributes flash) {
        Turno turno = null;
        
        if(idTurno>0){
            turno= turnoService.findOneTurno(idTurno);
            if (turno == null) {
            flash.addFlashAttribute("error", "El ID del Turno no existe en la base de datos");
            return "redirect:/listarTurno";    
            }
        } else{
            flash.addFlashAttribute("error", "El ID del Turno no puede ser 0");
            return "redirect:/listarTurno";
        }
        model.put("turno", turno);
        model.put("titulo", "Formulario de Turnos");
              
        return "formTurno";
    }

    @RequestMapping(value = "/formTurno", method = RequestMethod.POST)
    public String guardarTurno(@Valid Turno turno, BindingResult result, Model model,
            RedirectAttributes flash ,SessionStatus status) {
        if (result.hasErrors()) {
            model.addAttribute("titulo", "Formulario de Turnos");
            return "formTurno";
        }
        String mensajeFlash= (turno.getIdTurno()!= null)? "Turno editado con exito!":"Turno creado con exito!";
        
        turnoService.saveTurno(turno);
        status.setComplete();
        flash.addFlashAttribute("success", mensajeFlash);
        //falta el /
        return "redirect:listarTurno";
    }
    
}
