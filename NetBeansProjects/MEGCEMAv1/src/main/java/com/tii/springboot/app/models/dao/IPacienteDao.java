/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tii.springboot.app.models.dao;

import com.tii.springboot.app.models.entity.Paciente;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 *
 * @author VIVIANA CRISTINA
 */
public interface IPacienteDao extends PagingAndSortingRepository<Paciente, Long> {
    
}
