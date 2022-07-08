/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tii.springboot.app.models.service;

import com.tii.springboot.app.models.dao.IEstadoCitaDao;
import com.tii.springboot.app.models.entity.EstadoCita;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Pe-Hs
 */
@Service
public class EstadoCitaServiceImpl implements IEstadoCitaService {
    
    @Autowired
    private IEstadoCitaDao estadoServiceDao;

    @Override
    public List<EstadoCita> findAllEstadoCita() {
        return (List<EstadoCita>) estadoServiceDao.findAll();
    }

    @Override
    public Page<EstadoCita> findAllEstadoCita(Pageable pageable) {
        return estadoServiceDao.findAll(pageable);
    }

    @Override
    @Transactional
    public void saveEstadoCita(EstadoCita estadoCita) {
        estadoServiceDao.save(estadoCita);
    }

    @Override
    @Transactional(readOnly = true)
    public EstadoCita findOneEstadoCita(int idEstadoCita) {
        return estadoServiceDao.findById(idEstadoCita).orElse(null);
    }

    @Override
    @Transactional
    public void eliminarEstadoCita(int idEstadoCita) {
       estadoServiceDao.deleteById(idEstadoCita);
    }
      
    
    
}
