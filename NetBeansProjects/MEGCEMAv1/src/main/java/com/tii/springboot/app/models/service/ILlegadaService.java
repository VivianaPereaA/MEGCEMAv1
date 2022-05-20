/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tii.springboot.app.models.service;

import com.tii.springboot.app.models.entity.Llegada;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 *
 * @author VIVIANA CRISTINA
 */
public interface ILlegadaService {

    public List<Llegada> findAllLlegada();

    public Page<Llegada> findAllLlegada(Pageable pageable);

    public void saveLlegada(Llegada llegada);

    public Llegada findOneLlegada(Long id);

    public void eliminarLlegada(Long id);
}
