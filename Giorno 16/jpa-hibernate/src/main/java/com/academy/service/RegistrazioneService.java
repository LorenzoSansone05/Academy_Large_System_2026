package com.academy.service;

import com.academy.dto.RegistrazioneDTO;
import com.academy.exception.UserAlreadyExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.stereotype.Service;

@Service
public class RegistrazioneService {

    private JdbcUserDetailsManager userDetailsManager;

    private PasswordEncoder passwordEncoder;

    @Autowired
    public RegistrazioneService(JdbcUserDetailsManager userDetailsManager, PasswordEncoder passwordEncoder) {
        this.userDetailsManager = userDetailsManager;
        this.passwordEncoder = passwordEncoder;
    }

    // Ho preferito la creazione dell'utente nel db utilizzando userDetailsmanager, senza andare a creare altre classi aggiuntive per delegare la creazione degli utenti ad hibernate
    public UserDetails registraUtente(RegistrazioneDTO registrazioneDTO) {
        if (userDetailsManager.userExists(registrazioneDTO.getUsername())) {
            throw new UserAlreadyExistException();
        }

        UserDetails newUser = User.builder()
                .username(registrazioneDTO.getUsername())
                .password(passwordEncoder.encode(registrazioneDTO.getPassword()))
                .roles(registrazioneDTO.getRuolo().replace("ROLE_", ""))
                .build();

        //Fa l'operazione cascade sotto banco sia in user che in authorities
        userDetailsManager.createUser(newUser);

        return newUser;
    }
}
