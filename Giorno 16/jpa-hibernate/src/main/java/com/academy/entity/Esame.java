package com.academy.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

import java.time.LocalDate;

@Entity
@Table(name = "esami")
public class Esame {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String materia;

    @Min(value = 18, message = "il voto minimo è 18")
    @Max(value = 30, message = "il voto massimo è 30")
    private int voto;

    private LocalDate dataEsame;

    private boolean lode;

    public Esame() {}

    public Esame(String materia, int voto, LocalDate dataEsame, boolean lode) {
        this.materia = materia;
        this.voto = voto;
        this.dataEsame = dataEsame;
        this.lode = lode;
    }

    public Long getId() {
        return id;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public int getVoto() {
        return voto;
    }

    public void setVoto(int voto) {
        this.voto = voto;
    }

    public LocalDate getDataEsame() {
        return dataEsame;
    }

    public void setDataEsame(LocalDate dataEsame) {
        this.dataEsame = dataEsame;
    }

    public boolean isLode() {
        return lode;
    }

    public void setLode(boolean lode) {
        this.lode = lode;
    }
}

