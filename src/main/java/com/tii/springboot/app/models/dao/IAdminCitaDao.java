/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
// * and open the template in the editor.
 */
package com.tii.springboot.app.models.dao;

import com.tii.springboot.app.models.entity.AdminCita;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author VIVIANA CRISTINA
 */
public interface IAdminCitaDao extends PagingAndSortingRepository<AdminCita, Long>{
    
    @Query(value="SELECT * FROM admin_citas a WHERE a.admin_cita_fecha BETWEEN :fecha1 AND :fecha2 ", nativeQuery = true)
    List<AdminCita> findbyFecha(@Param("fecha1") String fecha1, @Param("fecha2") String fecha2);
    
    
}
