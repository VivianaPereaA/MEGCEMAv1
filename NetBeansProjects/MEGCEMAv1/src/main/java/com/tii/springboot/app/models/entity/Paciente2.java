package com.tii.springboot.app.models.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "paciente2")
public class Paciente2 implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_paciente2;
    
    @NotEmpty
    private String nombre_paciente;
    
    @NotEmpty
    private String apellido_paciente;
    
    @NotEmpty
    private String email;
    
    @NotEmpty
    private String telefono;
    
  
    @OneToMany(mappedBy = "paciente2", cascade = CascadeType.ALL)
    private List<Agenda> agenda;
    
    
    public Paciente2(Long id_paciente2, String nombre_paciente,String apellido_paciente, String email, String telefono){
        super();
        this.id_paciente2 = id_paciente2;
        this.nombre_paciente = nombre_paciente;
        this.apellido_paciente = apellido_paciente;
        this.email = email;
        this.telefono = telefono;
    }
    
    public Paciente2(){
        super();
    }

    public Long getId_paciente2() {
        return id_paciente2;
    }

    public void setId_paciente2(Long id_paciente2) {
        this.id_paciente2 = id_paciente2;
    }

    public String getNombre_paciente() {
        return nombre_paciente;
    }

    public void setNombre_paciente(String nombre_paciente) {
        this.nombre_paciente = nombre_paciente;
    }

    public String getApellido_paciente() {
        return apellido_paciente;
    }

    public void setApellido_paciente(String apellido_paciente) {
        this.apellido_paciente = apellido_paciente;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public List<Agenda> getAgenda() {
        return agenda;
    }

    public void setAgenda(List<Agenda> agenda) {
        this.agenda = agenda;
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id_paciente2 != null ? id_paciente2.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Paciente2)) {
            return false;
        }
        Paciente2 other = (Paciente2) object;
        if ((this.id_paciente2 == null && other.id_paciente2 != null) || (this.id_paciente2 != null && !this.id_paciente2.equals(other.id_paciente2))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tii.springboot.app.models.entity.Paciente2[ id=" + id_paciente2 + " ]";
    }
    
}
