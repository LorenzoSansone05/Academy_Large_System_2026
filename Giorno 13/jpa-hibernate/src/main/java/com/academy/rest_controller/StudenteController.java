package com.academy.rest_controller;

import com.academy.entity.Studente;
import com.academy.service.StudenteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/studenti")
@Tag(name = "Studenti", description = "Gestione completa dell'anagrafica studenti")
public class StudenteController {

    private final StudenteService studenteService;

    @Autowired
    public StudenteController(StudenteService studenteService) {
        this.studenteService = studenteService;
    }

    @GetMapping
    @Operation(summary = "Recupera la lista paginata di tutti gli studenti")
    @ApiResponse(responseCode = "200", description = "Lista recuperata con successo")
    public ResponseEntity<Page<Studente>> getAll(Pageable pageable) {
        Page<Studente> paginaStudenti = studenteService.findAll(pageable);
        return ResponseEntity.ok(paginaStudenti);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Recupera un singolo studente tramite il suo ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Studente trovato"),
            @ApiResponse(responseCode = "404", description = "Studente non trovato")
    })
    public ResponseEntity<Studente> getById(@PathVariable Long id) {
        return ResponseEntity.ok(studenteService.getById(id));
    }

    @GetMapping("/cognome/{cognome}")
    @Operation(summary = "Cerca studenti filtrando per cognome")
    @ApiResponse(responseCode = "200", description = "Ricerca completata (può restituire una lista vuota)")
    public ResponseEntity<List<Studente>> getByCognomePath(@PathVariable String cognome) {
        return ResponseEntity.ok(studenteService.getByCognome(cognome));
    }

    @GetMapping("/corso/{corso}")
    @Operation(summary = "Cerca studenti iscritti a un determinato corso di laurea")
    @ApiResponse(responseCode = "200", description = "Ricerca completata")
    public ResponseEntity<List<Studente>> getByCorsoLaurea(@PathVariable String corso) {
        return ResponseEntity.ok(studenteService.getByCorsoLaurea(corso));
    }

    @GetMapping("/{id}/corso")
    @Operation(summary = "Recupera solo il nome del corso di laurea di uno studente specifico")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Corso recuperato"),
            @ApiResponse(responseCode = "404", description = "Studente non trovato")
    })
    public ResponseEntity<Map<String, String>> getCorso(@PathVariable Long id) {
        String nomeCorso = studenteService.getCorsoById(id);
        Map<String, String> rispostaJson = new HashMap<>();
        rispostaJson.put("corso", nomeCorso);
        return ResponseEntity.ok(rispostaJson);
    }

    @PostMapping
    @Operation(summary = "Crea un nuovo record studente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Studente creato con successo"),
            @ApiResponse(responseCode = "400", description = "Dati forniti non validi")
    })
    public ResponseEntity<Studente> create(@RequestBody Studente nuovoStudente) {
        return ResponseEntity.status(HttpStatus.CREATED).body(studenteService.create(nuovoStudente));
    }

    @PatchMapping("/{id}")
    @Operation(summary = "Aggiorna parzialmente i dati di uno studente esistente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Studente aggiornato"),
            @ApiResponse(responseCode = "404", description = "Studente non trovato"),
            @ApiResponse(responseCode = "400", description = "Modifiche non valide")
    })
    public ResponseEntity<Studente> patch(@PathVariable Long id, @RequestBody Map<String, Object> modifiche) {
        Studente studenteDaModificare = studenteService.update(id, modifiche);
        return ResponseEntity.ok(studenteDaModificare);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Elimina uno studente dal database tramite ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Studente eliminato con successo"),
            @ApiResponse(responseCode = "404", description = "Studente non trovato")
    })
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        studenteService.delete(id);
        return ResponseEntity.noContent().build();
    }
}