/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tii.springboot.app.models.service;

import com.tii.springboot.app.models.entity.Diagnostico;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 *
 * @author usuario
 */
public interface IDiagnosticoService {
    
    public List<Diagnostico> findAllDiagnostico();

    public Page<Diagnostico> findAllDiagnostico(Pageable pageable);

    public void saveDiagnostico(Diagnostico diagnostico);

    public Diagnostico findOneDiagnostico(Long idDiagnostico);

    public void eliminarDiagnostico(Long idDiagnostico);
    
}
