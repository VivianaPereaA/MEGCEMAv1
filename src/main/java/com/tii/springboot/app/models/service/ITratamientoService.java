/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tii.springboot.app.models.service;

import com.tii.springboot.app.models.entity.Tratamiento;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 *
 * @author usuario
 */
public interface ITratamientoService {

    public List<Tratamiento> findAllTratamiento();

    public Page<Tratamiento> findAllTratamiento(Pageable pageable);

    public void saveTratamiento(Tratamiento tratamiento);

    public Tratamiento findOneTratamiento(Long id);

    public void eliminarTratamiento(Long id);
}
