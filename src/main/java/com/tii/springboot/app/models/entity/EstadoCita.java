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
@Table(name = "estado_citas")
public class EstadoCita implements Serializable{

    private static final long serialVersionUID = 1L;
     
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_estado_cita")
    private Long id;
    
    @Column(name="nombre_estado")
    private String nombreEstado;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    

    public String getNombreEstado() {
        return nombreEstado;
    }

    public void setNombreEstado(String nombreEstado) {
        this.nombreEstado = nombreEstado;
    }

}
