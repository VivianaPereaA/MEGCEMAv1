
package com.tii.springboot.app.models.service;

import com.tii.springboot.app.models.dao.ICitaDao;
import com.tii.springboot.app.models.entity.Cita;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class CitaServiceImpl implements ICitaService{
    
    @Autowired
    private ICitaDao citaDao;

    @Override
    public List<Cita> findAllCita() {
        return (List<Cita>) citaDao.findAll();
    }

    @Override
    public Page<Cita> findAllCita(Pageable pageable) {
        return citaDao.findAll(pageable);
    }

    @Override
    public void saveCita(Cita cita) {
        citaDao.save(cita);
    }

    @Override
    public Cita findOneCita(Long idCita) {
        return citaDao.findById(idCita).orElse(null);
    }

    @Override
    public void eliminarCita(Long idAdminCita) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
