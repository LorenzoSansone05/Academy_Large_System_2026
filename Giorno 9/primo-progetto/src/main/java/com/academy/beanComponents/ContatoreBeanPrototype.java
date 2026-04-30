package com.academy.beanComponents;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class ContatoreBeanPrototype {
    private int contatore;

    public int incrementa() {
        return contatore++;
    }
}
