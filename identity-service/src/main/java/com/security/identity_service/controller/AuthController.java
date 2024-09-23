package com.security.identity_service.controller;

import com.security.identity_service.dto.AuthRequest;
import com.security.identity_service.entity.UserCredential;
import com.security.identity_service.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/register")
    public String  addUser(UserCredential user)
    {
        authService.saveUser(user);
        return "User Created";
    }

    @GetMapping("/token")
    public String getToken(@RequestBody AuthRequest authRequest)
    {

        Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getName(), authRequest.getPassword()));

        if(authenticate.isAuthenticated()) {
            return authService.generateToken(authRequest.getName());
        }
        else
        {
           throw new RuntimeException("Invalid AuthRequest");
        }
    }

    @PostMapping("/validate")
    public String validateToken(String  token)
    {
         authService.validateToken(token);
        return "Token is valid";
    }


}
