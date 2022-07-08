/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tii.springboot.app.models.service;

import com.tii.springboot.app.models.entity.DetalleUsuario;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 *
 * @author Pe-Hs
 */
public interface IDetalleUsuarioService {
    
    public List<DetalleUsuario> findAllDetalleUsuario();

    public Page<DetalleUsuario> findAllDetalleUsuario(Pageable pageable);

    public void saveDetalleUsuario(DetalleUsuario usuario);

    public DetalleUsuario findOneDetalleUsuario(Long idDetalleUsuario);

    public void eliminarDetalleUsuario(Long idDetalleUsuario);
}
