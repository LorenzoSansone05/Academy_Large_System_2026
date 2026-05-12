package com.academy.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "studenti")
public class Studente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "ID univoco dello studente", example = "1", accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;

    @Schema(description = "Nome dello studente", example = "Carlo")
    private String nome;

    @Schema(description = "Cognome dello studente", example = "Prestigiacomo")
    private String cognome;

    @Schema(description = "Indirizzo email dello studente", example = "carlo.prestigiacomo@gmail.com")
    private String email;

    @Schema(description = "Data di nascita dello studente", example = "2005-11-17")
    private LocalDate dataNascita;

//    @Schema(description = "Corso di laurea a cui lo studente è iscritto", example = "Informatica")
//    private String corsoLaurea;

    @ManyToOne
    @JoinColumn(name = "corso_laurea_id")
    private CorsoLaurea corsoLaurea;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "profilo_id")
    private ProfiloStudente profilo;

    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name="studente_id")
    private List<Esame> esami;

    public Studente() {
    }

    public Studente(String nome, String cognome, String email, LocalDate dataNascita) {
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.dataNascita = dataNascita;
    }

    // Getter e Setter
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

    public CorsoLaurea getCorsoLaurea() {
        return corsoLaurea;
    }

    public void setCorsoLaurea(CorsoLaurea corsoLaurea) {
        this.corsoLaurea = corsoLaurea;
    }

    public void setProfilo(ProfiloStudente profilo) {
        this.profilo = profilo;
    }

    public ProfiloStudente getProfilo() {
        return profilo;
    }

    public List<Esame> getEsami() {
        return esami;
    }

    public void setEsami(List<Esame> esami) {
        this.esami = esami;
    }
}