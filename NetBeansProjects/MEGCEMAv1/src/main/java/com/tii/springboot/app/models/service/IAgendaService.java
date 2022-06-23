
package com.tii.springboot.app.models.service;

import com.tii.springboot.app.models.entity.Agenda;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IAgendaService {
    
    public List<Agenda> findAllAgenda();

    public Page<Agenda> findAllAgenda(Pageable pageable);

    public void saveAgenda(Agenda agenda);

    public Agenda findOneAgenda(Long idAgenda);

    public void eliminarAgenda(Long idAgenda);
    
    
}
