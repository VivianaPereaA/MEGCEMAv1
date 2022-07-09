/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tii.springboot.app.models.service;
import com.tii.springboot.app.models.entity.EstadoCita;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 *
 * @author Pe-Hs
 */
public interface IEstadoCitaService {
    
    public List<EstadoCita> findAllEstadoCita();

    public Page<EstadoCita> findAllEstadoCita(Pageable pageable);

    public void saveEstadoCita(EstadoCita estadoCita);

    public EstadoCita findOneEstadoCita(Long id);

    public void eliminarEstadoCita(Long id);
    
}
