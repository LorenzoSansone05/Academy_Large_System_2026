package com.academy.config;

import com.academy.entity.CorsoLaurea;
import com.academy.entity.Esame;
import com.academy.entity.ProfiloStudente;
import com.academy.entity.Studente;
import com.academy.repository.CorsoLaureaRepository;
import com.academy.repository.StudenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class DataLoaderConfig implements CommandLineRunner {

    private final StudenteRepository studenteRepository;

    private final CorsoLaureaRepository corsoLaureaRepository;

    @Autowired
    public DataLoaderConfig(StudenteRepository studenteRepository, CorsoLaureaRepository corsoLaureaRepository) {
        this.studenteRepository = studenteRepository;
        this.corsoLaureaRepository = corsoLaureaRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Studente s1 = new Studente();
        s1.setNome("Axel");
        s1.setCognome("Hawk");
        s1.setEmail("axel@hawk.it");

        ProfiloStudente p1 = new ProfiloStudente();
        p1.setBio("Appassionato di Java e Spring Boot");
        p1.setLinkedin("linkedin.com/in/axelhawk");

        s1.setProfilo(p1);

        Studente s2 = new Studente();
        s2.setNome("Lucia");
        s2.setCognome("Pacera");
        s2.setEmail("lucia@pacera.it");

        ProfiloStudente p2 = new ProfiloStudente();
        p2.setBio("Data Scientist");
        p2.setFotoUrl("foto_lucia.jpg");

        s2.setProfilo(p2);

        Studente s3 = new Studente();
        s3.setNome("Luca");
        s3.setCognome("Esposito");
        s3.setEmail("luca@esposito.it");

        CorsoLaurea corso1 = new CorsoLaurea();
        corso1.setNome("Informatica");
        corso1.setDipartimento("Scienze e Tecnologie");
        corso1.setDurataAnni(3);

        CorsoLaurea corso2 = new CorsoLaurea();
        corso2.setNome("Medicina e Chirurgia");
        corso2.setDipartimento("Scienze Mediche");
        corso2.setDurataAnni(6);

        CorsoLaurea corso3 = new CorsoLaurea();
        corso3.setNome("Economia Aziendale");
        corso3.setDipartimento("Scienze Economiche");
        corso3.setDurataAnni(3);

        s1.setCorsoLaurea(corso1);
        s2.setCorsoLaurea(corso2);
        s3.setCorsoLaurea(corso3);

        corso1.setStudenti(List.of(s1));
        corso2.setStudenti(List.of(s2));
        corso3.setStudenti(List.of(s3));

        corsoLaureaRepository.save(corso1);
        corsoLaureaRepository.save(corso2);
        corsoLaureaRepository.save(corso3);

        Esame e1 = new Esame();
        e1.setMateria("Programmazione 1");
        e1.setVoto(28);
        e1.setDataEsame(LocalDate.of(2024, 1, 15));
        e1.setLode(false);

        Esame e2 = new Esame();
        e2.setMateria("Algoritmi e Strutture Dati");
        e2.setVoto(30);
        e2.setDataEsame(LocalDate.of(2024, 2, 20));
        e2.setLode(true); // voto 30 → lode true

        Esame e3 = new Esame();
        e3.setMateria("Basi di Dati");
        e3.setVoto(25);
        e3.setDataEsame(LocalDate.of(2024, 3, 10));
        e3.setLode(false);

        Esame e4 = new Esame();
        e4.setMateria("Analisi 1");
        e4.setVoto(22);
        e4.setDataEsame(LocalDate.of(2024, 1, 18));
        e4.setLode(false);

        Esame e5 = new Esame();
        e5.setMateria("Fisica Generale");
        e5.setVoto(30);
        e5.setDataEsame(LocalDate.of(2024, 2, 28));
        e5.setLode(true);

        s1.setEsami(List.of(e1,e2,e3));
        s2.setEsami(List.of(e4, e5));

        studenteRepository.save(s1);
        studenteRepository.save(s2);
        studenteRepository.save(s3);
    }
}
