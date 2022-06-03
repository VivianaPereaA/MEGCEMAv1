package com.tii.springboot.app.models.service;

import com.tii.springboot.app.models.dao.IEncuestaDao;
import com.tii.springboot.app.models.entity.Encuesta;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EncuestaServiceImpl implements IEncuestaService {

    @Autowired
    private IEncuestaDao encuestaDao;

    @Override
    @Transactional(readOnly = true)
    public List<Encuesta> findAllEncuesta() {
        return (List<Encuesta>) encuestaDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Encuesta> findAllEncuesta(Pageable pageable) {
        return encuestaDao.findAll(pageable);
    }

    @Override
    @Transactional
    public void saveEncuesta(Encuesta encuesta) {
        encuestaDao.save(encuesta);
    }

    @Override
    @Transactional(readOnly = true)
    public Encuesta findOneEncuesta(Long idEncuesta) {
        return encuestaDao.findById(idEncuesta).orElse(null);
    }

    @Override
    @Transactional
    public void eliminarEncuesta(Long idEncuesta) {
        encuestaDao.deleteById(idEncuesta);
    }

}
