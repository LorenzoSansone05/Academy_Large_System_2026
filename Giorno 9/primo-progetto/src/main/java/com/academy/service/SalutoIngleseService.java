package com.academy.service;

import org.springframework.stereotype.Service;

@Service
public class SalutoIngleseService implements SalutoService {

    @Override
    public String getSaluto() {
        return "Good Morning";
    }
}
