package com.topcit.aims.aims.repository;

import com.topcit.aims.aims.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    Optional<Customer> findByEmail(String email);
    // check if customer exist
    boolean existsByEmail(String email);
    void deleteByEmail(String email);
}
