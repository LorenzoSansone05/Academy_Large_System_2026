package com.academy.service;

import com.academy.dao.StudenteDAO;
import com.academy.entity.Studente;
import com.academy.exception.StudenteNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StudenteService {

    private StudenteDAO studenteDao;

    @Autowired
    public StudenteService(StudenteDAO studenteDao) {
        this.studenteDao = studenteDao;
    }

    public List<Studente> findAll() {
        return studenteDao.findAll();
    }

    public Studente getById(Long id) {
        return studenteDao.findById(id).orElseThrow(() -> new StudenteNotFoundException(id));
    }

    public Studente create(Studente nuovoStudente) {
        studenteDao.save(nuovoStudente);
        return nuovoStudente;
    }

    public Studente update(Long id, Studente studenteDaAggiornare) {
        Studente studente = studenteDao.findById(id).orElseThrow(() -> new StudenteNotFoundException(id));
        studente.setNome(studenteDaAggiornare.getNome());
        studente.setCognome(studenteDaAggiornare.getCognome());
        studente.setEmail(studenteDaAggiornare.getEmail());
        studente.setCorsoLaurea(studenteDaAggiornare.getCorsoLaurea());
        studenteDao.update(studente);
        return studente;
    }

    public void delete(Long id) {
        studenteDao.findById(id).orElseThrow(() -> new StudenteNotFoundException(id));
        studenteDao.deleteById(id);
    }

    public List<Studente> getByCognome(String cognome) {
        return studenteDao.findByCognome(cognome);
    }

    public String getByCorso(Long id) {
        Studente studente = studenteDao.findById(id).orElseThrow(() -> new StudenteNotFoundException(id));
        return studente.getCorsoLaurea();
    }
}