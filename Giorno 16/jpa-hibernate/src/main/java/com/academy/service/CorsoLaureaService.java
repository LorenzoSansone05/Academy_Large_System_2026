package com.academy.service;

import com.academy.entity.CorsoLaurea;
import com.academy.entity.Studente;
import com.academy.repository.CorsoLaureaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CorsoLaureaService {

    private CorsoLaureaRepository corsoLaureaRepository;

    public CorsoLaureaService(CorsoLaureaRepository corsoLaureaRepository) {
        this.corsoLaureaRepository = corsoLaureaRepository;
    }

    public List<CorsoLaurea> getAllCorsi() {
        return corsoLaureaRepository.findAll();
    }

    public List<Studente> getStudentiByCorso(Long id) {
        CorsoLaurea corso = corsoLaureaRepository.findByIdWithStudenti(id);
        return corso.getStudenti();
    }

    public List<Object[]> getNumeroStudentiPerCorso() {
        return corsoLaureaRepository.countStudentiPerCorso();
    }
}
