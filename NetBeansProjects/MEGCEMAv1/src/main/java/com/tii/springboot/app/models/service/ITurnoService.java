
package com.tii.springboot.app.models.service;

import com.tii.springboot.app.models.entity.Turno;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ITurnoService {
    
    public List<Turno> findAllTurno();

    public Page<Turno> findAllTurno(Pageable pageable);

    public void saveTurno(Turno turno);

    public Turno findOneTurno(Long idTurno);
}
