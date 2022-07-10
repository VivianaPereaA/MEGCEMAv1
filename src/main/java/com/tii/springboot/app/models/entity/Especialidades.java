
package com.tii.springboot.app.models.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;


@Entity
@Table(name = "especialidades")
public class Especialidades implements Serializable {

    private static final long serialVersionUID = 1L;
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_especialidad")
    private Long id;
    
    @Column(name = "nombre_esp")
    @NotEmpty(message = "Debe ingresar Nombre de Especialidad")
    @NotBlank(message = "No debe estar en Blanco")
    private String nombre_esp;
    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre_esp() {
        return nombre_esp;
    }

    public void setNombre_esp(String nombre_esp) {
        this.nombre_esp = nombre_esp;
    }
  
    
}
