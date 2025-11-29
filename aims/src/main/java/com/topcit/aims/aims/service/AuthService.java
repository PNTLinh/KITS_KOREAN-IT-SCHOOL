package com.topcit.aims.aims.service;

import com.topcit.aims.aims.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private CustomerRepository customerRepository;

//    public Optional<Customer> login(String email, String password) {
//        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//
//        return customerRepository.findByEmail(email)
//                .map(customer -> passwordEncoder.matches(password, customer.getPasswordHash()))
//                .orElse(false);
    public boolean login(String email, String rawPassword){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return customerRepository.existsByEmail(email);
    }
}


