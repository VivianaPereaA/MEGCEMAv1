/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tii.springboot.app.models.service;

import com.tii.springboot.app.models.dao.IAdminCitaDao;
import com.tii.springboot.app.models.entity.AdminCita;
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
public class AdminCitaServiceImpl implements IAdminCitaService {

    @Autowired
    private IAdminCitaDao adminCitaDao;
    
    @Override
    @Transactional(readOnly = true)
    public List<AdminCita> findAllAdminCita() {
        return (List<AdminCita>) adminCitaDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Page<AdminCita> findAllAdminCita(Pageable pageable) {
        return adminCitaDao.findAll(pageable);
    }

    @Override
    @Transactional
    public void saveAdminCita(AdminCita adminCita) {
        adminCitaDao.save(adminCita);
    }

    @Override
    @Transactional(readOnly = true)
    public AdminCita findOneAdminCita(Long idAdminCita) {
        return adminCitaDao.findById(idAdminCita).orElse(null);
    }

    @Override
    @Transactional
    public void eliminarAdminCita(Long idAdminCita) {
        adminCitaDao.deleteById(idAdminCita);
    }
    
    
}
