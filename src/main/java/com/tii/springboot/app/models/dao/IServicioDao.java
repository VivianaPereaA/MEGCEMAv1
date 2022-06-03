/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tii.springboot.app.models.dao;

import com.tii.springboot.app.models.entity.Servicio;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 *
 * @author usuario
 */
public interface IServicioDao extends PagingAndSortingRepository<Servicio, Long> {
    
    @Query("select s from Servicio s where s.nombre like %?1%")
    public List<Servicio> findByNombre(String term);
        
    
    
}
