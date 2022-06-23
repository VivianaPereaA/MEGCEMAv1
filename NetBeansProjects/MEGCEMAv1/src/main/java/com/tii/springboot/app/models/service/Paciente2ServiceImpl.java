
package com.tii.springboot.app.models.service;

import com.tii.springboot.app.models.dao.IPaciente2Dao;
import com.tii.springboot.app.models.entity.Paciente2;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class Paciente2ServiceImpl implements  IPaciente2Service{
    
    @Autowired
    private IPaciente2Dao paciente2Dao;

    @Override
    public List<Paciente2> findAllPaciente2() {
        return (List<Paciente2>) paciente2Dao.findAll();
    }

    @Override
    public Page<Paciente2> findAllPaciente2(Pageable pageable) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void savePaciente2(Paciente2 paciente2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Paciente2 findOnePaciente2(Long idPaciente2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminarPaciente2(Long idPaciente2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
