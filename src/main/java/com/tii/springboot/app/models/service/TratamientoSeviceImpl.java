/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tii.springboot.app.models.service;

import com.tii.springboot.app.models.dao.ITratamientoDao;
import com.tii.springboot.app.models.entity.Tratamiento;
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
public class TratamientoSeviceImpl implements ITratamientoService {

    @Autowired
    private ITratamientoDao tratamientoDao;

    @Override
    @Transactional(readOnly = true)
    public List<Tratamiento> findAllTratamiento() {
        return (List<Tratamiento>) tratamientoDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Tratamiento> findAllTratamiento(Pageable pageable) {
        return tratamientoDao.findAll(pageable);
    }

    @Override
    @Transactional
    public void saveTratamiento(Tratamiento tratamiento) {
        tratamientoDao.save(tratamiento);
    }

    @Override
    @Transactional(readOnly = true)
    public Tratamiento findOneTratamiento(Long id) {
        return tratamientoDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void eliminarTratamiento(Long id) {
        tratamientoDao.deleteById(id);
    }

}
