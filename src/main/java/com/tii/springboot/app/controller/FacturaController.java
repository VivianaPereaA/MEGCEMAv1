package com.tii.springboot.app.controller;

import com.tii.springboot.app.models.entity.Factura;
import com.tii.springboot.app.models.entity.ItemFactura;
import com.tii.springboot.app.models.entity.Paciente;
import com.tii.springboot.app.models.entity.Servicio;
import com.tii.springboot.app.models.service.IPacienteService;
import java.util.List;
import java.util.Map;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/factura")
@SessionAttributes("factura")
public class FacturaController {
    
    @Autowired
    private IPacienteService pacienteService;
    
    private final Logger log = LoggerFactory.getLogger(getClass());
    
    @GetMapping("/verFactura/{id}")
    public String verFactura(@PathVariable(value="id")Long id,
            Model model,
            RedirectAttributes flash){
        
        Factura factura = pacienteService.findFacturaById(id);
        
        if(factura==null){
            flash.addFlashAttribute("error", "La factura no existe en la BD");
            return "redirect:/listarFacturas";
        }
        model.addAttribute("factura", factura);
        model.addAttribute("titulo", "Factura: ".concat(factura.getDescripcion()));
        return "factura/verF";
    }
    
    @GetMapping("/formFactura/{pacienteId}")
    public String crearFactura(@PathVariable(value="pacienteId") 
            Long pacienteId,
            Map<String, Object> model,
            RedirectAttributes flash){
        
        Paciente paciente = pacienteService.findOnePaciente(pacienteId);
        
        if (paciente==null) {
            flash.addFlashAttribute("error","El Paciente no existe en la BD");
                return "redirect:/listarPacientes";
        }
        
        Factura factura = new Factura();
        factura.setPaciente(paciente);
        
        model.put("factura", factura);
        model.put("titulo", "Crear Factura");
        
        return "factura/formFactura";
    }
    
    @GetMapping(value="/cargar-servicios/{term}", produces={"application/json"})
    public @ResponseBody List<Servicio> cargarServicios(@PathVariable String term){
        return pacienteService.findByNombre(term);
    }

 /*   
    @PostMapping(value = "/formFactura")
    public String guardarFactura(@Valid Factura factura,
            BindingResult result,
            Model model,
            @RequestParam(name="item_id[]", required=false) Long[] idItemFactura,
            @RequestParam(name="cantidad[]", required=false)Integer[]cantidadItemFactura,
            RedirectAttributes flash,
            SessionStatus status) {
        
        if(result.hasErrors()){
            model.addAttribute("titulo", "Crear Factura");
            return "factura/formFactura";
        }
        
        if(idItemFactura == null || idItemFactura.length == 0){
            model.addAttribute("titulo", "Crear Factura");
            model.addAttribute("error", "Error: La factura NO puede no tener lineas!");
            return "factura/formFactura";
        }
        
        for (int i=0; i < idItemFactura.length; i++) {
            Cita cita = pacienteService.findCitaById(idItemFactura[i]);
            
            ItemFactura linea = new ItemFactura();
            linea.setCantidadItemFactura(cantidadItemFactura[i]);
            linea.setCita(cita);
            factura.addItemFactura(linea);
            
            log.info("ID: " + idItemFactura[i].toString() + ", cantidad: " + cantidadItemFactura[i].toString());
        }
        
        pacienteService.guardarFactura(factura);
        status.setComplete();
        
        flash.addFlashAttribute("success", "Factura creada con exito!");
        
            return "redirect:/verPaciente/" + factura.getPaciente().getPacId();
        }

/*
    @GetMapping("/eliminar/{id}")
	public String eliminar(@PathVariable(value="id") Long id, RedirectAttributes flash) {
		
		Factura factura = clienteService.findFacturaById(id);
		
		if(factura != null) {
			clienteService.deleteFactura(id);
			flash.addFlashAttribute("success", "Factura eliminada con éxito!");
			return "redirect:/ver/" + factura.getCliente().getId();
		}
		flash.addFlashAttribute("error", "La factura no existe en la base de datos, no se pudo eliminar!");
		
		return "redirect:/listar";
	}
    */
    
} 

