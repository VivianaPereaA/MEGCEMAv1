
package com.tii.springboot.app.controller;

import com.tii.springboot.app.models.entity.AdminCita;
import com.tii.springboot.app.models.service.IAdminCitaService;
import com.tii.springboot.app.util.paginator.PageRender;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;


@Controller
@SessionAttributes("agenda")
public class AgendaController {
    
    @Autowired
    private  IAdminCitaService adminCitaService;
    
    @RequestMapping(value = "/listarAgenda", method = RequestMethod.GET)
    public String listarAgenda(
            @RequestParam(name="page", defaultValue ="0") int page,
            Model model,
            String fecha1,
            String fecha2
    ) {
        
        Pageable pageRequest=PageRequest.of(page, 10);
        Page<AdminCita> adminCitas =adminCitaService.findAllAdminCita(pageRequest);
        
        PageRender<AdminCita> pageRender = new PageRender<>("/listarAgenda", adminCitas);
        
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date(System.currentTimeMillis());
        
        model.addAttribute("fecha", "Fecha: " + formatter.format(date));
         
        if(fecha1 != null || fecha2 != null){
            model.addAttribute("adminCitas", adminCitaService.findbyFecha(fecha1, fecha2));   
        }else{
            model.addAttribute("adminCitas", adminCitas);
        }
     
        model.addAttribute("titulo", "Visualizar Agenda");      
        model.addAttribute("page", pageRender);

        return "listarAgenda";
    }
    
}
