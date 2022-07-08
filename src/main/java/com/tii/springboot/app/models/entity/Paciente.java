package com.tii.springboot.app.models.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
//import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "pacientes")
public class Paciente implements Serializable {

    public String nombreCompleto() {
        return this.nombre + " " + this.apellido;
    }

    public Paciente(Long id, String nombre, String apellido, String email, Date createAt, List<AdminCita> adminCita, List<Factura> facturas, List<Llegada> llegada, List<Diagnostico> diagnostico, List<Tratamiento> tratamiento) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.createAt = createAt;
        this.adminCita = adminCita;
        this.facturas = facturas;
        this.llegada = llegada;
        this.diagnostico = diagnostico;
        this.tratamiento = tratamiento;
    }

    @Id
    @Column(name = "id_paciente")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    @Column(name = "nombre_paciente")
    private String nombre;

    @NotEmpty
    @Column(name = "apellido_paciente")
    private String apellido;

    @NotEmpty
    @Email
    @Column(name = "email_paciente")
    private String email;

    @NotNull
    @Column(name = "fecha_nacimiento_paciente")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createAt;

    @OneToMany(mappedBy = "paciente", cascade = CascadeType.ALL)
    private List<AdminCita> adminCita;
    
    @OneToMany(mappedBy = "paciente", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Factura> facturas;
    
    @OneToMany(mappedBy = "paciente", cascade = CascadeType.ALL)
    private List<Llegada> llegada;
    
    @OneToMany(mappedBy = "paciente", cascade = CascadeType.ALL)
    private List<Diagnostico> diagnostico;
    
    @OneToMany(mappedBy = "paciente", cascade = CascadeType.ALL)
    private List<Tratamiento> tratamiento;
    
    public Paciente(){
        super();
    }

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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public List<Factura> getFacturas() {
        return facturas;
    }

    public void setFacturas(List<Factura> facturas) {
        this.facturas = facturas;
    }

    public void addFactura(Factura factura) {
        facturas.add(factura);
    }
    
        public List<AdminCita> getAdminCita() {
        return adminCita;
    }

    public void setAdminCita(List<AdminCita> adminCita) {
        this.adminCita = adminCita;
    }

    public List<Llegada> getLlegada() {
        return llegada;
    }

    public void setLlegada(List<Llegada> llegada) {
        this.llegada = llegada;
    }

    public List<Diagnostico> getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(List<Diagnostico> diagnostico) {
        this.diagnostico = diagnostico;
    }

    public List<Tratamiento> getTratamiento() {
        return tratamiento;
    }

    public void setTratamiento(List<Tratamiento> tratamiento) {
        this.tratamiento = tratamiento;
    }
    
    private static final long serialVersionUID = 1l;

}
