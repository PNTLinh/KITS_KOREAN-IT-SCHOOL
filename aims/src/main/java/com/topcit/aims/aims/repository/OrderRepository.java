package com.topcit.aims.aims.repository;

import com.topcit.aims.aims.entity.Orders;
import com.topcit.aims.aims.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface OrdersRepository extends JpaRepository<Orders, Integer> {

    List<Orders> findByCustomer(Customer customer);
    List<Orders> findByStatus(String status);
    List<Orders> findByOrderDateBetween(LocalDate startDate, LocalDate endDate);
    List<Orders> findByTotalAmountGreaterThan(Double amount);
    List<Orders> findByShippingAddressContainingIgnoreCase(String keyword);
}
