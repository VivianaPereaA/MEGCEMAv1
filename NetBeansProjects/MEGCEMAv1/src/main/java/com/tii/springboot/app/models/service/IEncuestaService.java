/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tii.springboot.app.models.service;

import com.tii.springboot.app.models.entity.Encuesta;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 *
 * @author VIVIANA CRISTINA
 */
public interface IEncuestaService {

    public List<Encuesta> findAllEncuesta();

    public Page<Encuesta> findAllEncuesta(Pageable pageable);

    public void saveEncuesta(Encuesta encuesta);

    public Encuesta findOneEncuesta(Long idEncuesta);

    public void eliminarEncuesta(Long idEncuesta);
}
