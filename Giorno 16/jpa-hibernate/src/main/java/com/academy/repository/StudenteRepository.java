package com.academy.repository;

import com.academy.entity.Esame;
import com.academy.entity.Studente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudenteRepository extends JpaRepository<Studente, Long> {
    public List<Studente> findByCognome(String cognome);
    public List<Studente> findByCorsoLaurea(String corso);
    public List<Studente> findByNomeContaining(String parte);

    @Query("""
           SELECT e 
           FROM Studente s 
           JOIN s.esami e 
           WHERE s.id = :id 
           ORDER BY e.dataEsame ASC
           """)
    List<Esame> findEsamiByStudenteIdOrderByData(@Param("id") Long id);
}
