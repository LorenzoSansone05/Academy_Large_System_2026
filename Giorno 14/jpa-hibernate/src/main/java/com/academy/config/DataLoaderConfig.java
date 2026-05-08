package com.academy.config;

import com.academy.entity.ProfiloStudente;
import com.academy.entity.Studente;
import com.academy.repository.StudenteRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoaderConfig implements CommandLineRunner {

    private final StudenteRepository studenteRepository;

    public DataLoaderConfig(StudenteRepository studenteRepository) {
        this.studenteRepository = studenteRepository;
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

        // il profilo nella seconda tabella si salva automaticamente grazie all'operazione cascade
        studenteRepository.save(s1);
        studenteRepository.save(s2);
        studenteRepository.save(s3);
    }
}
