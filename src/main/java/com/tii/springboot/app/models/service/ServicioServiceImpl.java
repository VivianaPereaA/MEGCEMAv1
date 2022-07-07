/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tii.springboot.app.models.service;

import com.tii.springboot.app.models.dao.IServicioDao;
import com.tii.springboot.app.models.entity.Servicio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author usuario
 */
@Service
public class ServicioServiceImpl implements IServicioService {

    @Autowired
    private IServicioDao servicioDao;

    @Override
    @Transactional(readOnly = true)
    public List<Servicio> findAllServicio() {
        return (List<Servicio>) servicioDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Servicio> findAllServicio(Pageable pageable) {
        return servicioDao.findAll(pageable);
    }

    @Override
    @Transactional
    public void saveServicio(Servicio servicio) {
        servicioDao.save(servicio);
    }

    @Override
    @Transactional(readOnly = true)
    public Servicio findOneServicio(Long id) {
        return servicioDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void eliminarServicio(Long id) {
        servicioDao.deleteById(id);
    }

}
