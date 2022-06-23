
package com.tii.springboot.app.models.service;

import com.tii.springboot.app.models.entity.Agenda;
import com.tii.springboot.app.models.entity.Paciente2;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface IPaciente2Service {
    
    public List<Paciente2> findAllPaciente2();

    public Page<Paciente2> findAllPaciente2(Pageable pageable);

    public void savePaciente2(Paciente2 paciente2);

    public Paciente2 findOnePaciente2(Long idPaciente2);

    public void eliminarPaciente2(Long idPaciente2);
    
}
