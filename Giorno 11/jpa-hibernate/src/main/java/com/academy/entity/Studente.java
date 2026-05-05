package com.academy.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "studenti")
public class Studente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String cognome;

    private String email;

    private LocalDate dataNascita;

    private String corsoLaurea;

    public Studente() {
    }

    public Studente(String nome, String cognome, String email, String corsoLaurea, LocalDate dataNascita) {
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.corsoLaurea = corsoLaurea;
        this.dataNascita = dataNascita;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDataNascita() {
        return dataNascita;
    }

    public void setDataNascita(LocalDate dataNascita) {
        this.dataNascita = dataNascita;
    }

    public String getCorsoLaurea() {
        return corsoLaurea;
    }

    public void setCorsoLaurea(String corsoLaurea) {
        this.corsoLaurea = corsoLaurea;
    }
}