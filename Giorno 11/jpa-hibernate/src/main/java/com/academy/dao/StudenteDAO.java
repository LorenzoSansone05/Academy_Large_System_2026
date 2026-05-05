package com.academy.dao;

import com.academy.entity.Studente;

import java.util.List;
import java.util.Optional;

public interface StudenteDAO {
    public List<Studente> findAll();
    public Optional<Studente> findById(Long id);
    public void save(Studente s);
    public Studente update(Studente s);
    public void deleteById(Long id);
    public List<Studente> findByCorsoLaurea(String corso);
}
