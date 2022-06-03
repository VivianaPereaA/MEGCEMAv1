/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tii.springboot.app.models.service;

import com.tii.springboot.app.models.dao.ILlegadaDao;
import com.tii.springboot.app.models.entity.Llegada;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author VIVIANA CRISTINA
 */
@Service
public class LlegadaServiceImpl implements ILlegadaService {

    @Autowired
    private ILlegadaDao llegadaDao;
    
    @Override
    @Transactional(readOnly = true)
    public List<Llegada> findAllLlegada() {
        return (List<Llegada>) llegadaDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Llegada> findAllLlegada(Pageable pageable) {
        return llegadaDao.findAll(pageable);
    }

    @Override
    @Transactional
    public void saveLlegada(Llegada llegada) {
        llegadaDao.save(llegada);
    }

    @Override
    @Transactional(readOnly = true)
    public Llegada findOneLlegada(Long idLlegada) {
        return llegadaDao.findById(idLlegada).orElse(null);
    }

    @Override
    @Transactional
    public void eliminarLlegada(Long idLlegada) {
        llegadaDao.deleteById(idLlegada);
    }
    
}
