package com.academy.dao;

import com.academy.entity.Studente;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public class StudenteDaoImpl implements StudenteDAO {

    EntityManager entityManager;

    @Autowired
    public StudenteDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Studente> findAll() {
        return entityManager.createQuery("SELECT s FROM Studente s", Studente.class)
                .getResultList();
    }

    @Override
    public Optional<Studente> findById(Long id) {
        return Optional.ofNullable(entityManager.find(Studente.class, id));
    }

    @Override
    public void save(Studente studente) {
        entityManager.persist(studente);
    }

    @Override
    public Studente update(Studente studente) {
        return entityManager.merge(studente);
    }

    @Override
    public void deleteById(Long id) {
        Studente s = entityManager.find(Studente.class, id);
        if (s != null) {
            entityManager.remove(s);
        }
    }


    @Override
    public List<Studente> findByCognome(String cognome) {
        TypedQuery<Studente> query = entityManager.createQuery(
                "SELECT s FROM Studente s WHERE s.cognome = :c", Studente.class);
        query.setParameter("c", cognome);
        return query.getResultList();
    }
}
