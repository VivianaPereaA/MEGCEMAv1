/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tii.springboot.app.models.service;

import com.tii.springboot.app.models.dao.IDiagnosticoDao;
import com.tii.springboot.app.models.entity.Diagnostico;
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
public class DiagnosticoServiceImpl implements IDiagnosticoService {

    @Autowired
    private IDiagnosticoDao diagnosticoDao;

    @Override
    @Transactional(readOnly = true)
    public List<Diagnostico> findAllDiagnostico() {
        return (List<Diagnostico>) diagnosticoDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Diagnostico> findAllDiagnostico(Pageable pageable) {
        return diagnosticoDao.findAll(pageable);
    }

    @Override
    @Transactional
    public void saveDiagnostico(Diagnostico diagnostico) {
        diagnosticoDao.save(diagnostico);
    }

    @Override
    @Transactional
    public void eliminarDiagnostico(Long idDiagnostico) {
        diagnosticoDao.deleteById(idDiagnostico);
    }

    @Override
    @Transactional
    public Diagnostico findOneDiagnostico(Long idDiagnostico) {
        return diagnosticoDao.findById(idDiagnostico).orElse(null);
    }

}
