
package com.tii.springboot.app.models.service;

import com.tii.springboot.app.models.dao.IAgendaDao;
import com.tii.springboot.app.models.entity.Agenda;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class AgendaServiceImpl implements IAgendaService{

    @Autowired
    private IAgendaDao agendaDao;
    

    @Override
    @Transactional(readOnly = true)
    public List<Agenda> findAllAgenda() {
        return (List<Agenda>) agendaDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Agenda> findAllAgenda(Pageable pageable) {
        return agendaDao.findAll(pageable);
    }

    @Override
    public void saveAgenda(Agenda agenda) {
        agendaDao.save(agenda);
    }

    @Override
    public Agenda findOneAgenda(Long idAgenda) {
        return agendaDao.findById(idAgenda).orElse(null);
    }

    @Override
    public void eliminarAgenda(Long idAgenda) {
        agendaDao.deleteById(idAgenda);
    }
    
    
}
