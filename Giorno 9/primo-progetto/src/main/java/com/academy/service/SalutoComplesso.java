package com.academy.service;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class SalutoComplesso {

    @PostConstruct
    public void init() {
        System.out.println("Bean inizializzato!");
    }

    @PreDestroy
    public void cleanUp() {
        System.out.println("Bean distrutto!");
    }
}
