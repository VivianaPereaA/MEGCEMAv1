/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tii.springboot.app.models.service;

import com.tii.springboot.app.models.dao.IEspecialidadesDao;
import com.tii.springboot.app.models.entity.Especialidades;
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
public class EspecialidadesServiceImpl implements IEspecialidadesService{

    @Autowired
    private IEspecialidadesDao especialidadesDao;
    
    @Override
    @Transactional(readOnly = true)
    public List<Especialidades> findAllEspecialidades() {
        return (List<Especialidades>) especialidadesDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Especialidades> findAllEspecialidades(Pageable pageable) {
        return especialidadesDao.findAll(pageable);
    }

    @Override
    public void saveEspecialidades(Especialidades encuesta) {
        especialidadesDao.save(encuesta);
    }

    @Override
    @Transactional(readOnly = true)
    public Especialidades findOneEspecialidades(Long idEspecialidades) {
         return especialidadesDao.findById(idEspecialidades).orElse(null);
    }

    @Override
    public void eliminarEspecialidades(Long idEspecialidades) {
        especialidadesDao.deleteById(idEspecialidades);
    }
    
}
