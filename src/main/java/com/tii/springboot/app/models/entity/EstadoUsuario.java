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
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author VIVIANA CRISTINA
 */
@Entity
@Table(name="estadoUsuarios")
public class EstadoUsuario implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_est_us")
    private Integer idestUsu;
    
    @Column(name="est_usu_nombre")
    private String estUsuNombre;
    

    public Integer getIdestUsu() {
        return idestUsu;
    }

    public void setIdestUsu(Integer idestUsu) {
        this.idestUsu = idestUsu;
    }

    public String getEstUsuNombre() {
        return estUsuNombre;
    }

    public void setEstUsuNombre(String estUsuNombre) {
        this.estUsuNombre = estUsuNombre;
    }
}
