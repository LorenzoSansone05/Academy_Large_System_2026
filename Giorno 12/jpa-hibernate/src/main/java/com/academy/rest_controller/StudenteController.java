package com.academy.rest_controller;

import com.academy.entity.Studente;
import com.academy.service.StudenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/studenti")
public class StudenteController {

    private StudenteService studenteService;

    @Autowired
    public StudenteController(StudenteService studenteService) {
        this.studenteService = studenteService;
    }

    @GetMapping
    public List<Studente> getAll() {
        return studenteService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Studente> getById(@PathVariable Long id) {
        return ResponseEntity.ok(studenteService.getById(id));
    }

    @GetMapping("/cerca")
    public ResponseEntity<List<Studente>> getByCognome(@RequestParam String cognome) {
        return ResponseEntity.ok(studenteService.getByCognome(cognome));
    }

    @GetMapping("/{id}/corso")
    public ResponseEntity<Map<String, String>> getCorso(@PathVariable Long id) {
        String nomeCorso = studenteService.getByCorso(id);
        Map<String, String> rispostaJson = new HashMap<>();
        rispostaJson.put("corso", nomeCorso);
        return ResponseEntity.ok(rispostaJson);
    }

    @PostMapping
    public ResponseEntity<Studente> create(@RequestBody Studente nuovoStudente) {
        return ResponseEntity.status(HttpStatus.CREATED).body(studenteService.create(nuovoStudente));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Studente> update(@PathVariable Long id, @RequestBody Studente studenteAggiornato) {
        return ResponseEntity.ok(studenteService.update(id, studenteAggiornato));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        studenteService.delete(id);
        return ResponseEntity.noContent().build();
    }
}