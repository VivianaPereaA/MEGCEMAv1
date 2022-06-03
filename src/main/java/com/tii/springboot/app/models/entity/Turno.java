/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tii.springboot.app.models.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "turnos")
public class Turno implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTurno;
    
    @NotNull
    @Column(name = "fecha_Turno")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fechaTurno;
    
    @NotNull
    @Column(name = "hora_Inicio_Turno")
    @Temporal(TemporalType.TIME)
    @DateTimeFormat(pattern = "HH:mm")
    private Date horaInicioTurno;
    
    @NotNull
    @Column(name = "hora_Fin_Turno")
    @Temporal(TemporalType.TIME)
    @DateTimeFormat(pattern = "HH:mm")
    private Date horaFinTurno;
    
    @ManyToOne(fetch = FetchType.LAZY)
    private Medico medico;
    
    @ManyToOne(fetch = FetchType.LAZY)
    private AdminCita cita;

    public Long getIdTurno() {
        return idTurno;
    }

    public void setIdTurno(Long idTurno) {
        this.idTurno = idTurno;
    }

    public Date getFechaTurno() {
        return fechaTurno;
    }

    public void setFechaTurno(Date fechaTurno) {
        this.fechaTurno = fechaTurno;
    }

    public Date getHoraInicioTurno() {
        return horaInicioTurno;
    }

    public void setHoraInicioTurno(Date horaInicioTurno) {
        this.horaInicioTurno = horaInicioTurno;
    }

    public Date getHoraFinTurno() {
        return horaFinTurno;
    }

    public void setHoraFinTurno(Date horaFinTurno) {
        this.horaFinTurno = horaFinTurno;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }
    
    
    
    private static final long serialVersionUID = 1l;
}
