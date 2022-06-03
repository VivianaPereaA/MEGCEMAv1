package com.tii.springboot.app.models.dao;

import com.tii.springboot.app.models.entity.Medico;
import org.springframework.data.repository.PagingAndSortingRepository;


    public interface IMedicoDao extends PagingAndSortingRepository<Medico, Long>{
        
        
}
