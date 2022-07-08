/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tii.springboot.app.models.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author usuario
 */
@Entity
@Table(name = "detalle_usuario")
public class DetalleUsuario implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_detalle")
    private Long id;
    
    @NotEmpty
    private String detUsuNombre;

    @NotEmpty
    @Email
    private String detUsuCorreo;

    @NotEmpty
    private String detUsuDireccion;

    @NotEmpty   
    @Pattern(regexp = "\\d{9}")
    private String detUsuTelefono;
    
    @NotEmpty
    private String detUsuSexo;

    @NotEmpty
    private String detUsuTipoDocNumero;

    @NotNull
    private Integer detUsuEdad;

    @NotEmpty
    private String detUsuEstadoCivil;

    @NotNull
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date detUsuFechaNacimiento;

    @NotEmpty
    @Column(name = "det_usu_lugar_nacimiento")
    private String detUsuLugarNacimiento;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDetUsuNombre() {
        return detUsuNombre;
    }

    public void setDetUsuNombre(String detUsuNombre) {
        this.detUsuNombre = detUsuNombre;
    }

    public String getDetUsuCorreo() {
        return detUsuCorreo;
    }

    public void setDetUsuCorreo(String detUsuCorreo) {
        this.detUsuCorreo = detUsuCorreo;
    }

    public String getDetUsuDireccion() {
        return detUsuDireccion;
    }

    public void setDetUsuDireccion(String detUsuDireccion) {
        this.detUsuDireccion = detUsuDireccion;
    }

    public String getDetUsuTelefono() {
        return detUsuTelefono;
    }

    public void setDetUsuTelefono(String detUsuTelefono) {
        this.detUsuTelefono = detUsuTelefono;
    }

    public String getDetUsuSexo() {
        return detUsuSexo;
    }

    public void setDetUsuSexo(String detUsuSexo) {
        this.detUsuSexo = detUsuSexo;
    }

    public String getDetUsuTipoDocNumero() {
        return detUsuTipoDocNumero;
    }

    public void setDetUsuTipoDocNumero(String detUsuTipoDocNumero) {
        this.detUsuTipoDocNumero = detUsuTipoDocNumero;
    }

    public Integer getDetUsuEdad() {
        return detUsuEdad;
    }

    public void setDetUsuEdad(Integer detUsuEdad) {
        this.detUsuEdad = detUsuEdad;
    }

    public String getDetUsuEstadoCivil() {
        return detUsuEstadoCivil;
    }

    public void setDetUsuEstadoCivil(String detUsuEstadoCivil) {
        this.detUsuEstadoCivil = detUsuEstadoCivil;
    }

    public Date getDetUsuFechaNacimiento() {
        return detUsuFechaNacimiento;
    }

    public void setDetUsuFechaNacimiento(Date detUsuFechaNacimiento) {
        this.detUsuFechaNacimiento = detUsuFechaNacimiento;
    }

    public String getDetUsuLugarNacimiento() {
        return detUsuLugarNacimiento;
    }

    public void setDetUsuLugarNacimiento(String detUsuLugarNacimiento) {
        this.detUsuLugarNacimiento = detUsuLugarNacimiento;
    }

   

    @Override
    public String toString() {
        return "DetalleUsuario{" + "usu_id=" + id + ", detUsuNombre=" + detUsuNombre + ", detUsuCorreo=" + detUsuCorreo + ", detUsuDireccion=" + detUsuDireccion + ", detUsuTelefono=" + detUsuTelefono + ", detUsuSexo=" + detUsuSexo + ", detUsuTipoDocNumero=" + detUsuTipoDocNumero + ", detUsuEdad=" + detUsuEdad + ", detUsuEstadoCivil=" + detUsuEstadoCivil + ", detUsuFechaNacimiento=" + detUsuFechaNacimiento + ", detUsuLugarNacimiento=" + detUsuLugarNacimiento + '}';
    }




    
    
}
