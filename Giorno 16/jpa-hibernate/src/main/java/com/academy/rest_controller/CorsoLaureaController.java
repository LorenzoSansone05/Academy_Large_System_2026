package com.academy.rest_controller;

import com.academy.entity.CorsoLaurea;
import com.academy.entity.Studente;
import com.academy.service.CorsoLaureaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/corsi")
public class CorsoLaureaController {

    private final CorsoLaureaService corsoLaureaService;

    @Autowired
    public CorsoLaureaController(CorsoLaureaService corsoLaureaService) {
        this.corsoLaureaService = corsoLaureaService;
    }

    @GetMapping
    public List<CorsoLaurea> getAllCorsi() {
        return corsoLaureaService.getAllCorsi();
    }

    @GetMapping("/{id}/studenti")
    public List<Studente> getStudentiByCorso(@PathVariable Long id) {
        return corsoLaureaService.getStudentiByCorso(id);
    }

    @GetMapping("/numero/studenti")
    public List<Object[]> getNumeroStudentiPerCorso() {
        return corsoLaureaService.getNumeroStudentiPerCorso();
    }
}
