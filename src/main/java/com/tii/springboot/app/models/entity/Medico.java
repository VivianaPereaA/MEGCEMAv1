package com.tii.springboot.app.models.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "medicos")
public class Medico implements Serializable {

    public Medico(Long id, String nombre, String apellido, String email, Date createAt, String colegiatura, String telefono, List<Turno> turnos, List<AdminCita> adminCita, Especialidades especialidades) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.createAt = createAt;
        this.colegiatura = colegiatura;
        this.telefono = telefono;
        this.turnos = turnos;
        this.adminCita = adminCita;
        this.especialidades = especialidades;
    }

    @Id
    @Column(name = "id_medico")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    @NotBlank
    private String nombre;

    @NotEmpty
    @NotBlank
    private String apellido;

    @NotEmpty
    @NotBlank
    @Email
    private String email;

    @NotNull
    @Column(name = "create_at")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createAt;

    @NotEmpty
    @NotBlank
    @Pattern(regexp = "\\d{6}")
    private String colegiatura;

    @NotEmpty
    @Pattern(regexp = "\\d{9}")
    @NotBlank
    private String telefono;

    @OneToMany(mappedBy = "cita", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Turno> turnos;
    
    @OneToMany(mappedBy = "medico", cascade = CascadeType.ALL)
    private List<AdminCita> adminCita;
    
    @OneToOne
    @JoinColumn(name = "especialidad_id", referencedColumnName = "id_especialidad")
    private Especialidades especialidades;
    
    public Medico() {
        turnos = new ArrayList<Turno>();
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

    public String getColegiatura() {
        return colegiatura;
    }

    public void setColegiatura(String colegiatura) {
        this.colegiatura = colegiatura;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public List<Turno> getTurnos() {
        return turnos;
    }

    public void setTurnos(List<Turno> turnos) {
        this.turnos = turnos;
    }

    public List<AdminCita> getAdminCita() {
        return adminCita;
    }

    public void setAdminCita(List<AdminCita> adminCita) {
        this.adminCita = adminCita;
    }

    public Especialidades getEspecialidades() {
        return especialidades;
    }

    public void setEspecialidades(Especialidades especialidades) {
        this.especialidades = especialidades;
    }

    private static final long serialVersionUID = 1l;

}
