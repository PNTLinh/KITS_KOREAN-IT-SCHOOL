package com.topcit.aims.aims.service;

import com.topcit.aims.aims.dto.request.CustomerCreationRequest;
import com.topcit.aims.aims.entity.Customer;
import com.topcit.aims.aims.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final BCryptPasswordEncoder passwordEncoder =  new BCryptPasswordEncoder();

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Optional<Customer> getCustomerById(Integer id) {
        return customerRepository.findById(id);
    }
    public Optional<Customer> getCustomerByEmail(String email){
        return customerRepository.findByEmail(email);
    }
    public Customer createCustomer(CustomerCreationRequest request) {
        Customer customer = new Customer();
        customer.setFullName(request.getFullName());
        customer.setAddress(request.getAddress());
        customer.setEmail(request.getEmail());

        //Ma hoa mat khau
        String encoderPassword = passwordEncoder.encode(request.getPasswordHash());
        customer.setPasswordHash(encoderPassword);
        customerRepository.save(customer);
        return customer;
    }

    public Customer updateCustomer(Integer id, Customer updatedCustomer) {
        return customerRepository.findById(id)
                .map(c -> {
                    c.setFullName(updatedCustomer.getFullName());
                    c.setEmail(updatedCustomer.getEmail());
                    c.setPasswordHash(updatedCustomer.getPasswordHash());
                    c.setAddress(updatedCustomer.getAddress());
                    return customerRepository.save(c);
                })
                .orElseThrow(() -> new RuntimeException("Customer not found with id " + id));
    }

    public void deleteCustomer(Integer id) {
        customerRepository.deleteById(id);
    }
    public void deleteCustomerByEmail(String email){
        customerRepository.deleteByEmail(email);
    }
}
