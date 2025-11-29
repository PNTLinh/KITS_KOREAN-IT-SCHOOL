package com.topcit.aims.aims.repository;

import com.topcit.aims.aims.entity.Order;
import com.topcit.aims.aims.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

    List<Order> findByCustomer(Customer customer);
    List<Order> findByStatus(String status);
    List<Order> findByOrderDateBetween(LocalDate startDate, LocalDate endDate);
    List<Order> findByTotalAmountGreaterThan(Double amount);
    List<Order> findByShippingAddressContainingIgnoreCase(String keyword);
}
