package com.academy.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class SalutoController {

    @Value("${app.nome}")
    private String nomeApp;

    @Value("${app.versione}")
    private String versione;

    @Value("${app.messaggio-benvenuto}")
    private String messaggioBenvenuto;

    @Value("${messaggio.file-prop}")
    private String messaggioFileProp;

    @Value(("${server.port}"))
    private String PortaTomcat;

    @GetMapping("/saluto")
    public String getSaluto() {
        return "Ciao dal mio primo Spring boot!!!!";
    }

    @GetMapping("/info")
    public Map<String, String> getInfo() {
        Map<String, String> info = new HashMap<>();
        info.put("alunno","Lorenzo Sansone");
        return info;
    }

    @GetMapping("/app-info")
    public Map<String, String> getAppInfo() {
        Map<String, String> infoApp = new HashMap<>();
        infoApp.put("Nome app", nomeApp);
        infoApp.put("Versione app", versione);
        infoApp.put("Messaggio di benvenuto", messaggioBenvenuto);
        return infoApp;
    }

    @GetMapping("/messaggio-file-prop")
    public String getFilePropMessage() {
        return messaggioFileProp;
    }

    @GetMapping("/configurazione-server")
    public Map<String, String> getServerPort() {
        Map<String, String> infoPortaTomcat = new HashMap<>();
        infoPortaTomcat.put("Porta server tomcat", PortaTomcat);
        return infoPortaTomcat;
    }
}
