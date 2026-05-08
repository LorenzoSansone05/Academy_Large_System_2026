package com.academy.service;

import com.academy.entity.ProfiloStudente;
import com.academy.entity.Studente;
import com.academy.exception.ProfiloStudenteNotFoundException;
import com.academy.exception.StudenteNotFoundException;
import com.academy.repository.StudenteRepository;
import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Map;

@Service
public class StudenteService {

    private StudenteRepository studenteRepository;

    @Autowired
    public StudenteService(StudenteRepository studenteRepository) {
        this.studenteRepository = studenteRepository;
    }

    public List<Studente> findAll() {
        return studenteRepository.findAll();
    }

    public Studente getById(Long id) {
        return studenteRepository.findById(id).orElseThrow(() -> new StudenteNotFoundException(id));
    }

    public Studente create(Studente nuovoStudente) {
        return studenteRepository.save(nuovoStudente);
    }

    @Transactional
    public Studente update(Long id, Map<String, Object> modifiche) {
        Studente studente = studenteRepository.findById(id).orElseThrow(() -> new StudenteNotFoundException(id));
        if (modifiche.containsKey("nome")) {
            studente.setNome((String) modifiche.get("nome"));
        }
        if (modifiche.containsKey("cognome")) {
            studente.setCognome((String) modifiche.get("cognome"));
        }
        if (modifiche.containsKey("email")) {
            studente.setEmail((String) modifiche.get("email"));
        }
        if (modifiche.containsKey("corsoLaurea")) {
            studente.setCorsoLaurea((String) modifiche.get("corsoLaurea"));
        }

        return studenteRepository.save(studente);
    }

    public void delete(Long id) {
        studenteRepository.findById(id).orElseThrow(() -> new StudenteNotFoundException(id));
        studenteRepository.deleteById(id);
    }

    public List<Studente> getByCognome(String cognome) {
        return studenteRepository.findByCognome(cognome);
    }

    public String getCorsoById(Long id) {
        Studente studente = studenteRepository.findById(id).orElseThrow(() -> new StudenteNotFoundException(id));
        return studente.getCorsoLaurea();
    }

    public List<Studente> getByCorsoLaurea(String corso) {
        List<Studente> studenti = studenteRepository.findByCorsoLaurea(corso);
        return studenti;
    }

    public Page<Studente> findAll(Pageable pageable) {
        return studenteRepository.findAll(pageable);
    }

    public ProfiloStudente getProfiloStudenteById(Long id) {
        Studente studente = studenteRepository.findById(id)
                .orElseThrow(() -> new StudenteNotFoundException(id));

        ProfiloStudente profilo = studente.getProfilo();

        if (profilo == null) {
            throw new ProfiloStudenteNotFoundException();
        }

        return profilo;
    }
}