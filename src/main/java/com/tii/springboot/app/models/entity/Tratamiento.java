/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tii.springboot.app.models.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 *
 * @author usuario
 */
@Entity
@Table(name = "tratamientos")
public class Tratamiento implements Serializable {
    
    private static final long serialVersionUID = 1L;

    public Tratamiento(Long id, String enfermedadPaciente, String medicamentos, int medicamentosDosis, int dosis, String observaciones, Paciente paciente) {
        this.id = id;
        this.enfermedadPaciente = enfermedadPaciente;
        this.medicamentos = medicamentos;
        this.medicamentosDosis = medicamentosDosis;
        this.dosis = dosis;
        this.observaciones = observaciones;
        this.paciente = paciente;
    }    

    public Tratamiento(){
        super();
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tratamiento")
    private Long id;

    @NotEmpty
    @Column(name = "enfermedad_paciente")
    private String enfermedadPaciente; 
     
    @NotEmpty
    @Column(name = "medicamentos")
    private String medicamentos;
    
    @NotNull
    @Column(name = "medicamentos_dosis")
    private int medicamentosDosis;
    
    @NotNull
    @Column(name = "dosis")
    private int dosis;
    
    @NotEmpty
    @Column(name = "obeservaciones")
    private String observaciones;

    @ManyToOne(optional = false)
    @JoinColumn(name = "paciente_id", nullable = false, referencedColumnName = "id_paciente" )
    private Paciente paciente;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEnfermedadPaciente() {
        return enfermedadPaciente;
    }

    public void setEnfermedadPaciente(String enfermedadPaciente) {
        this.enfermedadPaciente = enfermedadPaciente;
    }

    public String getMedicamentos() {
        return medicamentos;
    }

    public void setMedicamentos(String medicamentos) {
        this.medicamentos = medicamentos;
    }

    public int getMedicamentosDosis() {
        return medicamentosDosis;
    }

    public void setMedicamentosDosis(int medicamentosDosis) {
        this.medicamentosDosis = medicamentosDosis;
    }

    public int getDosis() {
        return dosis;
    }

    public void setDosis(int dosis) {
        this.dosis = dosis;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }
    
    
}
