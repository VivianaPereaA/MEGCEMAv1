package com.tii.springboot.app.controller;

import com.tii.springboot.app.models.entity.Agenda;
import com.tii.springboot.app.models.service.IAgendaService;
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

@Controller
public class AgendaController {
    
    @Autowired
     private IAgendaService iagendaService ;
    
    @RequestMapping(value = "/visualizarAgenda", method = RequestMethod.GET)
    public String visualizarAgenda(@RequestParam(name="page", defaultValue = "0")int page,Model model) {
        
        Pageable pageRequest = PageRequest.of(page, 5);  
        Page <Agenda> agenda = iagendaService.findAllAgenda(pageRequest);
        PageRender <Agenda> pageRender = new PageRender<>("/visualizarAgenda", agenda);
        
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date(System.currentTimeMillis());
   
        model.addAttribute("titulo", "Visualizar Agenda");
        model.addAttribute("fecha", "Fecha: " + formatter.format(date)); 
        model.addAttribute("adminCitas", agenda);
        model.addAttribute("page", pageRender);

        return "visualizarAgenda";
    }
    
       
}
