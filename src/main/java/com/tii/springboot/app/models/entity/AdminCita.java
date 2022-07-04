/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tii.springboot.app.models.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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

    public AdminCita() {
    }

    public AdminCita(Long idAdminCita, String nombreCita, Date adminCitaFecha, Date adminCitaHora, String horaCita, String adminCitaMotivo, String adminCitaObservacion, Paciente paciente, EstadoCita estadoCita) {
        this.idAdminCita = idAdminCita;
        this.nombreCita = nombreCita;
        this.adminCitaFecha = adminCitaFecha;
        this.adminCitaHora = adminCitaHora;
        this.horaCita = horaCita;
        this.adminCitaMotivo = adminCitaMotivo;
        this.adminCitaObservacion = adminCitaObservacion;
        this.paciente = paciente;
        this.estadoCita = estadoCita;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_admin_cita")
    private Long idAdminCita;

    @NotEmpty
    private String nombreCita;
 
    @NotNull
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "admin_cita_fecha")
    private Date adminCitaFecha;

    @Temporal(TemporalType.TIME)
    @DateTimeFormat(pattern = "HH:mm")
    @Column(name = "admin_cita_hora")
    private Date adminCitaHora;

    @Column(name = "hora_cita")
    private String horaCita;

    @NotEmpty
    @Size(min = 2, max = 255)
    @Column(name = "admin_cita_motivo")
    private String adminCitaMotivo;

    @Column(name = "admin_cita_observacion")
    private String adminCitaObservacion;

    @ManyToOne(optional = false)
    @JoinColumn(name = "paciente_id", nullable = false, referencedColumnName = "id_paciente" )
    private Paciente paciente;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "estado_cita_id")
    private EstadoCita estadoCita;

/*    @OneToMany(mappedBy = "medico", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Turno> turnos;
*/
    public Long getIdAdminCita() {
        return idAdminCita;
    }

    public void setIdAdminCita(Long idAdminCita) {
        this.idAdminCita = idAdminCita;
    }

    public String getNombreCita() {
        return nombreCita;
    }

    public void setNombreCita(String nombreCita) {
        this.nombreCita = nombreCita;
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

/*    public List<Turno> getTurnos() {
        return turnos;
    }

    public void setTurnos(List<Turno> turnos) {
        this.turnos = turnos;
    }
*/
    @Override
    public String toString() {
        return "AdminCita{" + "idAdminCita=" + idAdminCita + ", nombreCita=" + nombreCita + ", adminCitaFecha=" + adminCitaFecha + ", adminCitaHora=" + adminCitaHora + ", horaCita=" + horaCita + ", adminCitaMotivo=" + adminCitaMotivo + ", adminCitaObservacion=" + adminCitaObservacion + ", paciente=" + paciente + ", estadoCita=" + estadoCita + '}';
    }
    
    

    private static final long serialVersionUID = 1L;
}
