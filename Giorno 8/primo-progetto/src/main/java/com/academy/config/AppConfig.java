package com.academy.config;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class AppConfig {

    @Autowired
    private Environment env;

    @PostConstruct
    public void printCustomProperties() {
        System.out.println("#      CONFIGURAZIONE CARICATA CON SUCCESSO     #");
        System.out.println("Nome app     : " + env.getProperty("spring.application.name"));
        System.out.println("Porta server Tomcat  : " + env.getProperty("server.port"));
        System.out.println("Actuator Exp. : " + env.getProperty("management.endpoints.web.exposure.include"));
        System.out.println("Nome Progetto : " + env.getProperty("app.nome"));
        System.out.println("Versione      : " + env.getProperty("app.versione"));
        System.out.println("Messaggio     : " + env.getProperty("app.messaggio-benvenuto"));

        String profiloAttivo = (env.getActiveProfiles().length > 0)
                ? env.getActiveProfiles()[0]
                : "default";
        System.out.println("Profilo Attivo: " + profiloAttivo);
    }
}
