/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tii.springboot.app.models.service;

import com.tii.springboot.app.models.dao.IDetalleUsuarioDao;
import com.tii.springboot.app.models.entity.DetalleUsuario;
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
public class DetalleUsuarioServiceImpl implements IDetalleUsuarioService{
    
    @Autowired
    private IDetalleUsuarioDao detalleUsuarioDao;
    
    @Override
    @Transactional(readOnly = true)
    public List<DetalleUsuario> findAllDetalleUsuario() {
        return (List<DetalleUsuario>) detalleUsuarioDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Page<DetalleUsuario> findAllDetalleUsuario(Pageable pageable) {
        return detalleUsuarioDao.findAll(pageable);
    }

    @Override
    public void saveDetalleUsuario(DetalleUsuario detalleUsuario) {
        detalleUsuarioDao.save(detalleUsuario);
    }

    @Override
    @Transactional(readOnly = true)
    public DetalleUsuario findOneDetalleUsuario(Long idDetalleUsuario) {
        return detalleUsuarioDao.findById(idDetalleUsuario).orElse(null);
    }

    @Override
    public void eliminarDetalleUsuario(Long idDetalleUsuario) {
        detalleUsuarioDao.deleteById(idDetalleUsuario);
    }
    
}
