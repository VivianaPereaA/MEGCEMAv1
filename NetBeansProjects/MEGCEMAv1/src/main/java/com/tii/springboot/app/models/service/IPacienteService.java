package com.tii.springboot.app.models.service;

import com.tii.springboot.app.models.entity.Factura;
import com.tii.springboot.app.models.entity.Paciente;
import com.tii.springboot.app.models.entity.Servicio;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IPacienteService {
    
    public List<Paciente> findAllPaciente();

    public Page<Paciente> findAllPaciente(Pageable pageable);
    
    public void savePaciente(Paciente paciente);

    public Paciente findOnePaciente(Long pacienteId);

    public void eliminarPaciente(Long pacienteId);
    
    public List<Servicio> findByNombre (String term);
        
    public void guardarFactura(Factura factura);
    
    
    public Factura findFacturaById (Long pacienteId);
    
    //public void eliminarFactura (Long idPaciente);
    
    //

    public Paciente obtenerPorIdPaciente(Integer pacienteId);
    
    public List <Paciente> listarPaciente();
    
    

    
}
