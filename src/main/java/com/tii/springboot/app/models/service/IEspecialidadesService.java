
package com.tii.springboot.app.models.service;

import com.tii.springboot.app.models.entity.Especialidades;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 *
 * @author Pe-Hs
 */
public interface IEspecialidadesService {
    
    public List<Especialidades> findAllEspecialidades();

    public Page<Especialidades> findAllEspecialidades(Pageable pageable);

    public void saveEspecialidades(Especialidades encuesta);

    public Especialidades findOneEspecialidades(Long id);

    public void eliminarEspecialidades(Long id);
}
