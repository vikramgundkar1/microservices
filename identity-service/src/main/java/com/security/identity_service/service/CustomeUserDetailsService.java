package com.security.identity_service.service;

import com.security.identity_service.config.CustomeUserDetails;
import com.security.identity_service.entity.UserCredential;
import com.security.identity_service.repository.UserCredentialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CustomeUserDetailsService  implements UserDetailsService {

    @Autowired
    private UserCredentialRepository userCredentialRepository;
    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {

        Optional<UserCredential> credentials= userCredentialRepository.findByName(name);
        return credentials.map(CustomeUserDetails::new).orElseThrow(()-> new UsernameNotFoundException("User not found name :"+ name));
    }
}
