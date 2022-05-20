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
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

/**
 *
 * @author usuario
 */
@Entity
@Table(name = "diagnosticos")
public class Diagnostico implements Serializable {

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

    
}
