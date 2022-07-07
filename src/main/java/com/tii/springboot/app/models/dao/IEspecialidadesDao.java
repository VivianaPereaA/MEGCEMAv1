
package com.tii.springboot.app.models.dao;

import com.tii.springboot.app.models.entity.Especialidades;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IEspecialidadesDao extends  PagingAndSortingRepository<Especialidades, Long>{
    
}
