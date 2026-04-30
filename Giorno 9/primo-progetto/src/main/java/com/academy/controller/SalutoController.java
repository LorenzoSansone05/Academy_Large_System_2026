package com.academy.controller;

import com.academy.beanComponents.ContatoreBeanPrototype;
import com.academy.beanComponents.ContatoreBeanSingleton;
import com.academy.service.SalutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class SalutoController {
    /*
    La differenza che passa tra lo scope singleton e quello prototype è che quando inietti un componente singleton viene creata una e una singola istanza per tutta l'app, quando provi a iniettarla in diversi controller si crea un riferimento alla prima istanza creata ma sara sempre una sola istanza, invece con lo scope prototype per ogni controller viene creata una nuova istanza, quindi non vengono condivise le informazioni tra i controller.
    */

    /*
    La differenza che passa tra @Primary e @Qualifier è che con @Primary vai a dare un comportamento di default, cioe intendi che ogni qualvolta venga iniettato quel bean, venga chiamata quella implementazione, in qualsiasi controller venga richiamato. invece con qualifier si puo fare una richiesta piu specifica, si puo decidere esattamente quale implementazione richiamare in quel contesto andando a scrivere @Qualifier(<id.class>)
    nell'iniezione
     */
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

    private SalutoService salutoService;
    private ContatoreBeanSingleton cbs;
    private ContatoreBeanPrototype cbp;

    @Autowired
    public SalutoController(@Qualifier("salutoIngleseService") SalutoService salutoService, ContatoreBeanSingleton cbs, ContatoreBeanPrototype cbp) {
        this.salutoService = salutoService;
        this.cbs = cbs;
        this.cbp = cbp;
    }

    @GetMapping("/saluto")
    public String getSaluto() {
        return "Ciao dal mio primo Spring boot!!!!";
    }

    @GetMapping("/saluto2")
    public String getSaluto2() {
        return salutoService.getSaluto();
    }

    /* Chiamando questi due endpoint non ci sarà alcuna differenza
     poichè il componente viene iniettato una singola volta,
      ma se nel caso si dovesse iniettare in due controller entrambi i component
      accadrebbe che il contatore singleton non avra problemi,
      poiche si andrebbe a creare un riferimento alla prima istanza,
      invece quello prototype verrebbe resettato ogni volta, poiche si crea una nuova istanza del component*/
    @GetMapping("/contatoreSingleton")
    public int getContatoreSingleton() {
        return cbs.incrementa();
    }

    @GetMapping("/contatorePrototype")
    public int getContatorePrototype() {
        return cbp.incrementa();
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
