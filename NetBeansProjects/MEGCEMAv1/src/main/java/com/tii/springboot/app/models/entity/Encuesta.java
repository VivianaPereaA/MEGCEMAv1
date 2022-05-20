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
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "encuestas")
public class Encuesta implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEncuesta;

    @NotEmpty
    //@Size(min=4, max=12)
    private String nombreEncuesta;

    @NotEmpty
    private String signosVitalesEncuesta;

    @NotEmpty
    private String antecedentesEncuesta;

    @NotEmpty
    private String diagnosticoEncuesta;

    @NotEmpty
    private String observacionesEncuesta;

    @NotNull
    @Column(name = "create_at_encuesta")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createAtEncuesta;

    public Long getIdEncuesta() {
        return idEncuesta;
    }

    public void setIdEncuesta(Long idEncuesta) {
        this.idEncuesta = idEncuesta;
    }

    public String getNombreEncuesta() {
        return nombreEncuesta;
    }

    public void setNombreEncuesta(String nombreEncuesta) {
        this.nombreEncuesta = nombreEncuesta;
    }

    public String getSignosVitalesEncuesta() {
        return signosVitalesEncuesta;
    }

    public void setSignosVitalesEncuesta(String signosVitalesEncuesta) {
        this.signosVitalesEncuesta = signosVitalesEncuesta;
    }

    public String getAntecedentesEncuesta() {
        return antecedentesEncuesta;
    }

    public void setAntecedentesEncuesta(String antecedentesEncuesta) {
        this.antecedentesEncuesta = antecedentesEncuesta;
    }

    public String getDiagnosticoEncuesta() {
        return diagnosticoEncuesta;
    }

    public void setDiagnosticoEncuesta(String diagnosticoEncuesta) {
        this.diagnosticoEncuesta = diagnosticoEncuesta;
    }

    public String getObservacionesEncuesta() {
        return observacionesEncuesta;
    }

    public void setObservacionesEncuesta(String observacionesEncuesta) {
        this.observacionesEncuesta = observacionesEncuesta;
    }

    public Date getCreateAtEncuesta() {
        return createAtEncuesta;
    }

    public void setCreateAtEncuesta(Date createAtEncuesta) {
        this.createAtEncuesta = createAtEncuesta;
    }

    
    
    private static final long serialVersionUID = 1l;

}
