package com.security.identity_service.service;

import com.security.identity_service.config.AuthConfig;
import com.security.identity_service.entity.UserCredential;
import com.security.identity_service.repository.UserCredentialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UserCredentialRepository userCredentialRepository;

    @Autowired
    private AuthConfig authConfig;

    @Autowired
    private JwtService jwtService;

    public String  saveUser(UserCredential userCredential)
    {

        if(userCredential.getPassword()!=null) {
            userCredential.setPassword(authConfig.passwordEncoder().encode(userCredential.getPassword()));
        }
        userCredentialRepository.save(userCredential);
        return "Saved User";
    }

    public String generateToken(String name){
        return jwtService.generateToken(name);


    }

    public void  validateToken(String token)
    {
         jwtService.validateToken(token);
    }
}
