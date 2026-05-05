package com.academy.jpa_hibernate;

import com.academy.entity.Studente;
import com.academy.dao.StudenteDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
@ComponentScan(basePackages = "com.academy")
@EntityScan(basePackages = "com.academy.entity")
public class JpaHibernateApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaHibernateApplication.class, args);
	}

//	@Bean
//	public CommandLineRunner testDao(StudenteDAO studenteDao) {
//		return args -> {
//			Studente s1 = new Studente("Alessandro", "Moretti", "a.moretti@gmail.com", "Economia", LocalDate.of(2002, 3, 14));
//			Studente s2 = new Studente("Beatrice", "Ricci", "b.ricci@gmail.com", "Giurisprudenza", LocalDate.of(2001, 7, 22));
//			Studente s3 = new Studente("Federico", "Russo", "f.russo@gmail.com", "Informatica", LocalDate.of(2003, 11, 5));
//
//			studenteDao.save(s1);
//			studenteDao.save(s2);
//			studenteDao.save(s3);
//			System.out.println("3 Studenti salvati");
//
//
//			List<Studente> tutti = studenteDao.findAll();
//			System.out.println("Numero di studenti salvati: " + tutti.size());
//
//
//			if (!tutti.isEmpty()) {
//				Studente daAggiornare = tutti.get(0);
//				daAggiornare.setCorsoLaurea("Marketing");
//				studenteDao.update(daAggiornare);
//				System.out.println("Corso aggiornato allo studente con ID " + daAggiornare.getId() + ": " + daAggiornare.getCorsoLaurea());
//			}
//
//
//			if (tutti.size() >= 3) {
//				Long idDaEliminare = tutti.get(2).getId();
//				studenteDao.deleteById(idDaEliminare);
//				System.out.println("Studente con ID " + idDaEliminare + " eliminato.");
//			}
//
//
//			List<Studente> studentiCorsoLaurea = studenteDao.findByCorsoLaurea("Informatica");
//			System.out.println("Studenti trovati per il corso Informatica: " + studentiCorsoLaurea.size());
//
//
//		};
//	}
}
