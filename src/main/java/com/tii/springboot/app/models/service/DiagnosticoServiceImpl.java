/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tii.springboot.app.models.service;

import com.tii.springboot.app.models.dao.IAdminCitaDao;
import com.tii.springboot.app.models.entity.Diagnostico;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author usuario
 */
public class DiagnosticoServiceImpl implements IDiagnosticoService {

    @Autowired
    private IDiagnosticoService diagnosticoDao;

    @Override
    @Transactional(readOnly = true)
    public List<Diagnostico> findAllDiagnostico() {
        return (List<Diagnostico>) diagnosticoDao.findAllDiagnostico();

    }

    @Override
    public Page<Diagnostico> findAllDiagnostico(Pageable pageable) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void saveDiagnostico(Diagnostico diagnostico) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Diagnostico findOneDiagnostico(Long idDiagnostico) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminarDiagnostico(Long idDiagnostico) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
