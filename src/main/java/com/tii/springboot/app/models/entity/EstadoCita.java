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
import javax.persistence.Table;

/**
 *
 * @author VIVIANA CRISTINA
 */
@Entity
@Table(name = "estado_Citas")
public class EstadoCita implements Serializable{
    
    public EstadoCita(){
        
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="estado_cita_id")
    private int estadoCitaId;
    
    //@NotEmpty
    @Column(name="estado_cita_nombre_estado")
    private String estadoCitaNombreEstado;

    public int getEstadoCitId() {
        return estadoCitaId;
    }

    public void setEstadoCitId(int estadoCitId) {
        this.estadoCitaId = estadoCitId;
    }

    public String getEstadoCitaNombreEstado() {
        return estadoCitaNombreEstado;
    }

    public void setEstadoCitaNombreEstado(String estadoCitaNombreEstado) {
        this.estadoCitaNombreEstado = estadoCitaNombreEstado;
    }


    
}
