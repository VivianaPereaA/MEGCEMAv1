/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tii.springboot.app.models.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author VIVIANA CRISTINA
 */
@Entity
@Table(name = "admin_citas")
public class AdminCita implements Serializable {



    public AdminCita(Long idAdminCita, Date adminCitaFecha, Date adminCitaHora, String horaCita, String adminCitaMotivo, String adminCitaObservacion, Paciente paciente, EstadoCita estadoCita, Medico medico) {
        this.idAdminCita = idAdminCita;
        this.adminCitaFecha = adminCitaFecha;
        this.adminCitaHora = adminCitaHora;
        this.horaCita = horaCita;
        this.adminCitaMotivo = adminCitaMotivo;
        this.adminCitaObservacion = adminCitaObservacion;
        this.paciente = paciente;
        this.estadoCita = estadoCita;
        this.medico = medico;
    }
    
    public AdminCita() {
        super();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_admin_cita")
    private Long idAdminCita;

    @NotNull
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "admin_cita_fecha")
    private Date adminCitaFecha;

    @NotNull
    @Temporal(TemporalType.TIME)
    @DateTimeFormat(pattern = "HH:mm")
    @Column(name = "admin_cita_hora")
    private Date adminCitaHora;

    @Column(name = "hora_cita")
    private String horaCita;

    @NotEmpty
    @Column(name = "admin_cita_motivo")
    private String adminCitaMotivo;

    @Column(name = "admin_cita_observacion")
    private String adminCitaObservacion;

    @ManyToOne(optional = false)
    @JoinColumn(name = "paciente_id", nullable = false, referencedColumnName = "id_paciente" )
    private Paciente paciente;

    @OneToOne
    @JoinColumn(name = "estado_cita_id", referencedColumnName = "id_estado_cita")
    private EstadoCita estadoCita;

    @ManyToOne
    @JoinColumn(name="medico_id", nullable = false ,referencedColumnName = "id_medico")
    private Medico medico;
    
    public Long getIdAdminCita() {
        return idAdminCita;
    }

    public void setIdAdminCita(Long idAdminCita) {
        this.idAdminCita = idAdminCita;
    }

    public Date getAdminCitaFecha() {
        return adminCitaFecha;
    }

    public void setAdminCitaFecha(Date adminCitaFecha) {
        this.adminCitaFecha = adminCitaFecha;
    }

    public Date getAdminCitaHora() {
        return adminCitaHora;
    }

    public void setAdminCitaHora(Date adminCitaHora) {
        this.adminCitaHora = adminCitaHora;
    }

    public String getHoraCita() {
        return horaCita;
    }

    public void setHoraCita(String horaCita) {
        this.horaCita = horaCita;
    }  

    public String getAdminCitaMotivo() {
        return adminCitaMotivo;
    }

    public void setAdminCitaMotivo(String adminCitaMotivo) {
        this.adminCitaMotivo = adminCitaMotivo;
    }

    public String getAdminCitaObservacion() {
        return adminCitaObservacion;
    }

    public void setAdminCitaObservacion(String adminCitaObservacion) {
        this.adminCitaObservacion = adminCitaObservacion;
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

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    @Override
    public String toString() {
        return "AdminCita{" + "idAdminCita=" + idAdminCita +  ", adminCitaFecha=" + adminCitaFecha + ", adminCitaHora=" + adminCitaHora + ", horaCita=" + horaCita + ", adminCitaMotivo=" + adminCitaMotivo + ", adminCitaObservacion=" + adminCitaObservacion + ", paciente=" + paciente + ", estadoCita=" + estadoCita + ", medico=" + medico + '}';
    }

    
    

    private static final long serialVersionUID = 1L;
}
