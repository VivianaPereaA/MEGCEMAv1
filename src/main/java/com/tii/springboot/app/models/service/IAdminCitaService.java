/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tii.springboot.app.models.service;

import com.tii.springboot.app.models.entity.AdminCita;
import com.tii.springboot.app.models.entity.Medico;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 *
 * @author VIVIANA CRISTINA
 */
public interface IAdminCitaService {
    
    public List<AdminCita> findAllAdminCita();

    public Page<AdminCita> findAllAdminCita(Pageable pageable);

    public void saveAdminCita(AdminCita adminCita);

    public AdminCita findOneAdminCita(Long idAdminCita);

    public void eliminarAdminCita(Long idAdminCita);
    
    public List<AdminCita> findbyFecha(String fecha1, String fecha2);
}
