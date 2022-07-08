
package com.tii.springboot.app.models.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;


@Entity
@Table(name = "usuarios")
public class Usuario implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    public Usuario(Long id, String nombre, String contraseña, EstadoUsuario estadoUsuario, DetalleUsuario detalleUsuario) {
        this.id = id;
        this.nombre = nombre;
        this.contraseña = contraseña;
        this.estadoUsuario = estadoUsuario;
        this.detalleUsuario = detalleUsuario;
    }
    
    public Usuario(){
        super();
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Long id;
    
    @NotEmpty
    @Column(name = "nombre_usuario")
    private String nombre;
    
    @NotEmpty
    @Column(name = "contraseña_usuario")
    private String contraseña;
    
    @OneToOne
    @JoinColumn(name = "est_usu_id", referencedColumnName = "id_est_us")
    private EstadoUsuario estadoUsuario;
    
    @OneToOne
    @JoinColumn(name = "detalle_id", referencedColumnName = "id_detalle")
    private DetalleUsuario detalleUsuario;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public EstadoUsuario getEstadoUsuario() {
        return estadoUsuario;
    }

    public void setEstadoUsuario(EstadoUsuario estadoUsuario) {
        this.estadoUsuario = estadoUsuario;
    }

    public DetalleUsuario getDetalleUsuario() {
        return detalleUsuario;
    }

    public void setDetalleUsuario(DetalleUsuario detalleUsuario) {
        this.detalleUsuario = detalleUsuario;
    }    
    
}
