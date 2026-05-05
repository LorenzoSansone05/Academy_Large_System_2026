package com.academy.rest_controller;

import com.academy.dao.StudenteDAO;
import com.academy.entity.Studente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/studenti")
public class StudenteController {

    private final StudenteDAO studenteDao;

    @Autowired
    public StudenteController(StudenteDAO studenteDao) {
        this.studenteDao = studenteDao;
    }

    @GetMapping
    public List<Studente> getAll() {
        return studenteDao.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Studente>> getById(@PathVariable Long id) {
        Optional<Studente> studente = studenteDao.findById(id);
        if (studente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(studente);
    }

    @PostMapping
    public ResponseEntity<Studente> create(@RequestBody Studente nuovoStudente) {
        studenteDao.save(nuovoStudente);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuovoStudente);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Studente> update(@PathVariable Long id, @RequestBody Studente studenteAggiornato) {
        Optional<Studente> studente = studenteDao.findById(id);
        if (studente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        studenteAggiornato.setId(id);
        studenteDao.update(studenteAggiornato);
        return ResponseEntity.ok(studenteAggiornato);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        Optional<Studente> studente = studenteDao.findById(id);
        if (studente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        studenteDao.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
