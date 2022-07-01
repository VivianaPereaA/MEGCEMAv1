/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tii.springboot.app.models.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name= "citas")
public class Cita implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "cita_id")
    private Long citaId;
    
    //@NotNull
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="estado_cita_id")
    private EstadoCita estadoCita;
    
    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm")
    @Column(name= "cita_fecha_hora_inicio")
    private Date citaFechaHoraInicio;
    
    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm")
    @Column(name= "cita_fecha_hora_fin")
    private Date citaFechaHoraFin;
    
    //@NotNull
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm")
    @Column(name= "cita_fecha_hora_inicio_real")
    private Date citaFechaHoraInicioReal;
    
    //@NotNull
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm")
    @Column(name= "cita_fecha_hora_fin_real")
    private Date citaFechaHoraFinReal;
    
    @NotEmpty
    @Size(min=2, max=255)
    @Column(name= "cita_motivo")
    private String citaMotivo;
    
    @ManyToOne(optional = false)
    @JoinColumn(name = "paciente_id", nullable = false, referencedColumnName = "id_paciente" )
    private Paciente paciente;
    
    @Column(name= "cita_observacion")
    private String citaObservacion;

    public String getCitaPrueba() {
        return citaPrueba;
    }

    public void setCitaPrueba(String citaPrueba) {
        this.citaPrueba = citaPrueba;
    }
    
        @Column(name= "cita_prueba")
    private String citaPrueba;

    public Long getCitaId() {
        return citaId;
    }

    public void setCitaId(Long citaId) {
        this.citaId = citaId;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public EstadoCita getEstadoCita() {
        return estadoCita;
    }

    public void setEstadoCita(EstadoCita estadoCita) {
        this.estadoCita = estadoCita;
    }

    public Date getCitaFechaHoraInicio() {
        return citaFechaHoraInicio;
    }

    public void setCitaFechaHoraInicio(Date citaFechaHoraInicio) {
        this.citaFechaHoraInicio = citaFechaHoraInicio;
    }

    public Date getCitaFechaHoraFin() {
        return citaFechaHoraFin;
    }

    public void setCitaFechaHoraFin(Date citaFechaHoraFin) {
        this.citaFechaHoraFin = citaFechaHoraFin;
    }

    public Date getCitaFechaHoraInicioReal() {
        return citaFechaHoraInicioReal;
    }

    public void setCitaFechaHoraInicioReal(Date citaFechaHoraInicioReal) {
        this.citaFechaHoraInicioReal = citaFechaHoraInicioReal;
    }

    public Date getCitaFechaHoraFinReal() {
        return citaFechaHoraFinReal;
    }

    public void setCitaFechaHoraFinReal(Date citaFechaHoraFinReal) {
        this.citaFechaHoraFinReal = citaFechaHoraFinReal;
    }

    public String getCitaMotivo() {
        return citaMotivo;
    }

    public void setCitaMotivo(String citaMotivo) {
        this.citaMotivo = citaMotivo;
    }
    
    public String getCitaObservacion() {
        return citaObservacion;
    }

    public void setCitaObservacion(String citaObservacion) {
        this.citaObservacion = citaObservacion;
    }
    
}
