/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tii.springboot.app.models.service;

import com.tii.springboot.app.models.dao.IUsuarioDao;
import com.tii.springboot.app.models.entity.Usuario;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 *
 * @author Pe-Hs
 */
@Service
public class UsuarioServiceImpl implements IUsuarioService{

    @Autowired
    private IUsuarioDao usuarioDao;
    
    @Override
    public List<Usuario> findAllUsuario() {
        return (List<Usuario>) usuarioDao.findAll();
    }

    @Override
    public Page<Usuario> findAllUsuario(Pageable pageable) {
        return usuarioDao.findAll(pageable);
    }

    @Override
    public void saveUsuario(Usuario usuario) {
        usuarioDao.save(usuario);
    }

    @Override
    public Usuario findOneUsuario(Long idUsuario) {
        return usuarioDao.findById(idUsuario).orElse(null);
    }

    @Override
    public void eliminarUsuario(Long idUsuario) {
        usuarioDao.deleteById(idUsuario);
    }
    
}
