package com.topcit.aims.aims.controller;

import com.topcit.aims.aims.entity.Customer;
import com.topcit.aims.aims.entity.Order;
import com.topcit.aims.aims.service.OrderService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }
    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestBody Order order) {
        return ResponseEntity.ok(orderService.createOrder(order));
    }

    @GetMapping
    public ResponseEntity<List<Order>> getAllOrders() {
        return ResponseEntity.ok(orderService.getAllOrders());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable Integer id) {
        return orderService.getOrderById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/customer/{customerId}")
    public ResponseEntity<List<Order>> getOrdersByCustomer(@PathVariable Integer customerId) {
        Customer customer = new Customer();
        customer.setCustomerId(customerId);
        return ResponseEntity.ok(orderService.getOrdersByCustomer(customer));
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<List<Order>> getOrdersByStatus(@PathVariable String status) {
        return ResponseEntity.ok(orderService.getOrdersByStatus(status));
    }

    @GetMapping("/date-range")
    public ResponseEntity<List<Order>> getOrdersByDateRange(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {
        return ResponseEntity.ok(orderService.getOrdersByDateRange(startDate, endDate));
    }

    @GetMapping("/amount-greater/{amount}")
    public ResponseEntity<List<Order>> getOrdersByTotalAmountGreaterThan(@PathVariable Double amount) {
        return ResponseEntity.ok(orderService.getOrdersByTotalAmountGreaterThan(amount));
    }

    @GetMapping("/search")
    public ResponseEntity<List<Order>> searchOrdersByShippingAddress(@RequestParam String keyword) {
        return ResponseEntity.ok(orderService.searchOrdersByShippingAddress(keyword));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Order> updateOrder(@PathVariable Integer id, @RequestBody Order updatedOrder) {
        return ResponseEntity.ok(orderService.updateOrder(id, updatedOrder));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Integer id) {
        orderService.deleteOrder(id);
        return ResponseEntity.noContent().build();
    }
}
