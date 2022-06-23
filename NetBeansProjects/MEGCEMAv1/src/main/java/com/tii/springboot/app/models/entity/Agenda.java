
package com.tii.springboot.app.models.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="agenda")
public class Agenda implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_agenda;

    @NotNull
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date fecha_inicio;
    
    @NotNull
    @Temporal(TemporalType.TIME)
    @DateTimeFormat(pattern="HH:mm")
    private Date hora_inicio;
    

    @ManyToOne(optional = false)
    @JoinColumn(name = "paciente2_id", nullable = false, referencedColumnName = "id_paciente2" )
    private Paciente2 paciente2;

    public Long getId_agenda() {
        return id_agenda;
    }

    public void setId_agenda(Long id_agenda) {
        this.id_agenda = id_agenda;
    }

    public Date getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(Date fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public Date getHora_inicio() {
        return hora_inicio;
    }

    public void setHora_inicio(Date hora_inicio) {
        this.hora_inicio = hora_inicio;
    }

    public Paciente2 getPaciente2() {
        return paciente2;
    }

    public void setPaciente2(Paciente2 paciente2) {
        this.paciente2 = paciente2;
    }
    
    

    
}
