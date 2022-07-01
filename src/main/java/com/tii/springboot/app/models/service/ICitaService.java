
package com.tii.springboot.app.models.service;


import com.tii.springboot.app.models.entity.Cita;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface ICitaService {
    
    public List<Cita> findAllCita();

    public Page<Cita> findAllCita(Pageable pageable);

    public void saveCita(Cita cita);

    public Cita findOneCita(Long idCita);

    public void eliminarCita(Long idCita);
}
