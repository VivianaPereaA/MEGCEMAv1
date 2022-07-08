/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tii.springboot.app.models.service;

import com.tii.springboot.app.models.entity.Usuario;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 *
 * @author Pe-Hs
 */
public interface IUsuarioService {
    
    public List<Usuario> findAllUsuario();

    public Page<Usuario> findAllUsuario(Pageable pageable);

    public void saveUsuario(Usuario usuario);

    public Usuario findOneUsuario(Long idUsuario);

    public void eliminarUsuario(Long idUsuario);
}
