/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tii.springboot.app.models.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

/**
 *
 * @author usuario
 */
@Entity
@Table(name = "diagnosticos")
public class Diagnostico implements Serializable {

    public Diagnostico(Long idDiagnostico, String sintomasDiagnostico, String antecedentesDiagnostico, String alergiasDiagnostico, String evaluacionDiagnostico, String observacionesDiagnostico, Paciente paciente) {
        this.idDiagnostico = idDiagnostico;
        this.sintomasDiagnostico = sintomasDiagnostico;
        this.antecedentesDiagnostico = antecedentesDiagnostico;
        this.alergiasDiagnostico = alergiasDiagnostico;
        this.evaluacionDiagnostico = evaluacionDiagnostico;
        this.observacionesDiagnostico = observacionesDiagnostico;
        this.paciente = paciente;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDiagnostico;

    @NotEmpty
    //@Size(min=4, max=12)
    private String sintomasDiagnostico;

    @NotEmpty
    private String antecedentesDiagnostico;

    @NotEmpty
    private String alergiasDiagnostico;
    
    @NotEmpty
    private String evaluacionDiagnostico;

    @NotEmpty
    private String observacionesDiagnostico;
    
    @ManyToOne(optional = false)
    @JoinColumn(name = "paciente_id", nullable = false, referencedColumnName = "id_paciente")
    private Paciente paciente;
    
    public Diagnostico(){
        super();
    }
    
    public Long getIdDiagnostico() {
        return idDiagnostico;
    }

    public void setIdDiagnostico(Long idDiagnostico) {
        this.idDiagnostico = idDiagnostico;
    }

    public String getSintomasDiagnostico() {
        return sintomasDiagnostico;
    }

    public void setSintomasDiagnostico(String sintomasDiagnostico) {
        this.sintomasDiagnostico = sintomasDiagnostico;
    }

    public String getAntecedentesDiagnostico() {
        return antecedentesDiagnostico;
    }

    public void setAntecedentesDiagnostico(String antecedentesDiagnostico) {
        this.antecedentesDiagnostico = antecedentesDiagnostico;
    }

    public String getAlergiasDiagnostico() {
        return alergiasDiagnostico;
    }

    public void setAlergiasDiagnostico(String alergiasDiagnostico) {
        this.alergiasDiagnostico = alergiasDiagnostico;
    }
    
    public String getEvaluacionDiagnostico() {
        return evaluacionDiagnostico;
    }

    public void setEvaluacionDiagnostico(String evaluacionDiagnostico) {
        this.evaluacionDiagnostico = evaluacionDiagnostico;
    }

    public String getObservacionesDiagnostico() {
        return observacionesDiagnostico;
    }

    public void setObservacionesDiagnostico(String observacionesDiagnostico) {
        this.observacionesDiagnostico = observacionesDiagnostico;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    
}
