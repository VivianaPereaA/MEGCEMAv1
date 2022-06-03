package com.tii.springboot.app.models.service;

import com.tii.springboot.app.models.dao.IFacturaDao;
import com.tii.springboot.app.models.dao.IPacienteDao;
import com.tii.springboot.app.models.dao.IServicioDao;
import com.tii.springboot.app.models.entity.Factura;
import com.tii.springboot.app.models.entity.Paciente;
import com.tii.springboot.app.models.entity.Servicio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PacienteServiceImpl implements IPacienteService {

    @Autowired
    private IPacienteDao pacienteDao;

    @Autowired
    private IServicioDao servicioDao;

    @Autowired
    private IFacturaDao facturaDao;

    private List<Paciente> listaPaciente;

    @Override
    @Transactional(readOnly = true)
    public List<Paciente> findAllPaciente() {
        return (List<Paciente>) pacienteDao.findAll();
    }

    @Override
    @Transactional
    public void savePaciente(Paciente paciente) {
        pacienteDao.save(paciente);
    }

    @Override
    @Transactional(readOnly = true)
    public Paciente findOnePaciente(Long id) {
        return pacienteDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void eliminarPaciente(Long id) {
        pacienteDao.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Paciente> findAllPaciente(Pageable pageable) {
        return pacienteDao.findAll(pageable);
    }

    //metodo VER
    @Override
    public List<Paciente> listarPaciente() {
        return this.listaPaciente;
    }



    @Override
    @Transactional
    public void guardarFactura(Factura factura) {
        facturaDao.save(factura);
    }

    @Override
    public Paciente obtenerPorIdPaciente(Integer id) {
        Paciente resultadoPaciente = null;
        for (Paciente p : listaPaciente) {
            if (p.getId().equals(id)) {
                resultadoPaciente = p;
                break;
            }
        }
        return resultadoPaciente;
    }

    @Override
    @Transactional(readOnly = true)
    public Factura findFacturaById(Long id) {
        return facturaDao.findById(id).orElse(null);
    }

    /*
    @Override
    @Transactional
    public void eliminarFactura(Long idPaciente) {
		facturaDao.deleteById(idPaciente);
	}
     */

    @Override
    @Transactional(readOnly = true)
    public List<Servicio> findByNombre(String term) {
        return servicioDao.findByNombre(term);
    }

}
