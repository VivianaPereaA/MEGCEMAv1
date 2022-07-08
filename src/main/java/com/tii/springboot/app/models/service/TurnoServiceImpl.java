/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tii.springboot.app.models.service;

import com.tii.springboot.app.models.dao.ITurnoDao;
import com.tii.springboot.app.models.entity.Medico;
import com.tii.springboot.app.models.entity.Turno;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author VIVIANA CRISTINA
 */
@Service
public class TurnoServiceImpl implements ITurnoService {

    @Autowired
    private ITurnoDao turnoDao;

    @Override
    @Transactional(readOnly = true)
    public List<Turno> findAllTurno() {
        return (List<Turno>) turnoDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Turno> findAllTurno(Pageable pageable) {
        return turnoDao.findAll(pageable);
    }

    @Override
    @Transactional
    public void saveTurno(Turno turno) {
        turnoDao.save(turno);
    }

    @Override
    @Transactional(readOnly = true)
    public Turno findOneTurno(Long idTurno) {
        return turnoDao.findById(idTurno).orElse(null);
    }

    @Override
    public void eliminarTurno(Long idTurno) {
        turnoDao.deleteById(idTurno);
    }

}
