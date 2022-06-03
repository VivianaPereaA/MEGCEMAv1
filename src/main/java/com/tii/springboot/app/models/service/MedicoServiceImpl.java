package com.tii.springboot.app.models.service;

import com.tii.springboot.app.models.dao.IMedicoDao;
import com.tii.springboot.app.models.entity.Medico;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MedicoServiceImpl implements IMedicoService {

    @Autowired
    private IMedicoDao medicoDao;

    @Override
    @Transactional(readOnly = true)
    public List<Medico> findAll() {
        return (List<Medico>) medicoDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Medico findOne(Long id) {
        return medicoDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void save(Medico medico) {
        medicoDao.save(medico);
    }

    @Override
    @Transactional
    public void eliminar(Long id) {
        medicoDao.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Medico> findAll(Pageable pageable) {
        return medicoDao.findAll(pageable);
    }

}
