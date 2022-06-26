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
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

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


    //@Size(min=4, max=12)
    private String nombrePaciente;


    private String apellidoPaciente;


    private String emailPaciente;


    //@Size(min=8)
    @NotEmpty
    private String tipoEnfermedad;

    @NotEmpty
    private String enfermedadPaciente; 
     
    @NotEmpty
    private String Medicamentos;
    
    @NotNull
    private int cantidadDosis;
    
    @NotNull
    private int Dosis;
                
    @NotEmpty
    private String observaciones;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombrePaciente() {
        return nombrePaciente;
    }

    public void setNombrePaciente(String nombrePaciente) {
        this.nombrePaciente = nombrePaciente;
    }

    public String getApellidoPaciente() {
        return apellidoPaciente;
    }

    public void setApellidoPaciente(String apellidoPaciente) {
        this.apellidoPaciente = apellidoPaciente;
    }

    public String getEmailPaciente() {
        return emailPaciente;
    }

    public void setEmailPaciente(String emailPaciente) {
        this.emailPaciente = emailPaciente;
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

    public int getCantidadDosis() {
        return cantidadDosis;
    }

    public void setCantidadDosis(int cantidadDosis) {
        this.cantidadDosis = cantidadDosis;
    }

    public int getDosis() {
        return Dosis;
    }

    public void setDosis(int Dosis) {
        this.Dosis = Dosis;
    }
    
    

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String Observaciones) {
        this.observaciones = Observaciones;
    }
    
    
    
}
