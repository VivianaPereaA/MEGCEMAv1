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
@Table(name = "tratamientos")
public class Tratamiento implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //@Size(min=8)
    @NotEmpty
    private String tipoEnfermedad;

    @NotEmpty
    private String enfermedadPaciente; 
     
    @NotEmpty
    private String Medicamentos;
                
    @NotEmpty
    private String observaciones;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getTipoEnfermedad() {
        return tipoEnfermedad;
    }

    public void setTipoEnfermedad(String tipoEnfermedad) {
        this.tipoEnfermedad = tipoEnfermedad;
    }

    

    public String getEnfermedadPaciente() {
        return enfermedadPaciente;
    }

    public void setEnfermedadPaciente(String enfermedadPaciente) {
        this.enfermedadPaciente = enfermedadPaciente;
    }

    public String getMedicamentos() {
        return Medicamentos;
    }

    public void setMedicamentos(String Medicamentos) {
        this.Medicamentos = Medicamentos;
    }

 

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String Observaciones) {
        this.observaciones = Observaciones;
    }
    
    
    
}
