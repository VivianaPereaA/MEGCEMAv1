/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tii.springboot.app.models.service;

import com.tii.springboot.app.models.entity.Servicio;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 *
 * @author usuario
 */
public interface IServicioService {

    public List<Servicio> findAllServicio();

    public Page<Servicio> findAllServicio(Pageable pageable);

    public void saveServicio(Servicio servicio);

    public Servicio findOneServicio(Long id);

    public void eliminarServicio(Long id);

}
