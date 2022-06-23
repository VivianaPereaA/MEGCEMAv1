
package com.tii.springboot.app.models.dao;

import com.tii.springboot.app.models.entity.Agenda;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IAgendaDao extends PagingAndSortingRepository<Agenda, Long> {
    
}
