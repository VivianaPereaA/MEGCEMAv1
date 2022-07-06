/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tii.springboot.app.models.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Id;
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
public class DetalleUsuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "usu_id")
    private Long usu_id;
    
    @NotEmpty
    @Column(name = "det_usu_nombre")
    private String detUsuNombre;

    @Email
    @NotEmpty
    @Column(name = "det_usu_correo")
    private String detUsuCorreo;

    @NotEmpty
    @Column(name = "det_usu_direccion")
    private String detUsuDireccion;

    @NotEmpty
    @Column(name = "det_usu_telefono")
    @Pattern(regexp = "\\d{9}")
    private String detUsuTelefono;

    @Column(name = "det_usu_sexo")
    private String detUsuSexo;

    @NotEmpty
    @Column(name = "det_usu_tip_doc_numero")
    private String detUsuTipoDocNumero;

    @Column(name = "det_usu_edad")
    private Integer detUsuEdad;

    @Column(name = "det_usu_estado_civil")
    private String detUsuEstadoCivil;

    @Column(name = "det_usu_fecha_nacimiento")
    @Temporal(TemporalType.DATE)
    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date detUsuFechaNacimiento;

    @NotEmpty
    @Column(name = "det_usu_lugar_nacimiento")
    private String detUsuLugarNacimiento;


    public Long getUsu_id() {
        return usu_id;
    }

    public void setUsu_id(Long usu_id) {
        this.usu_id = usu_id;
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
        return "DetalleUsuario{" + "usu_id=" + usu_id + ", detUsuNombre=" + detUsuNombre + ", detUsuCorreo=" + detUsuCorreo + ", detUsuDireccion=" + detUsuDireccion + ", detUsuTelefono=" + detUsuTelefono + ", detUsuSexo=" + detUsuSexo + ", detUsuTipoDocNumero=" + detUsuTipoDocNumero + ", detUsuEdad=" + detUsuEdad + ", detUsuEstadoCivil=" + detUsuEstadoCivil + ", detUsuFechaNacimiento=" + detUsuFechaNacimiento + ", detUsuLugarNacimiento=" + detUsuLugarNacimiento + '}';
    }




    
    
}
