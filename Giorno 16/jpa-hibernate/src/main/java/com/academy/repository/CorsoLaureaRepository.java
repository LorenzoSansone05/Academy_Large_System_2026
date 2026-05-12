package com.academy.repository;

import com.academy.entity.CorsoLaurea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CorsoLaureaRepository extends JpaRepository<CorsoLaurea, Long> {

    @Query("SELECT c FROM CorsoLaurea c LEFT JOIN FETCH c.studenti WHERE c.id = :id")
    CorsoLaurea findByIdWithStudenti(@Param("id") Long id);

    @Query("SELECT c.nome, COUNT(s) FROM CorsoLaurea c JOIN c.studenti s GROUP BY c.nome")
    List<Object[]> countStudentiPerCorso();

}
