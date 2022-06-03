package com.tii.springboot.app.models.service;

import com.tii.springboot.app.models.entity.Medico;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;

public interface IMedicoService {

    public List<Medico> findAll();

    public Page<Medico> findAll(Pageable pageable);

    public void save(Medico medico);

    public Medico findOne(Long id);

    public void eliminar(Long id);
}
