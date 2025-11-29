package com.topcit.aims.aims.controller;

import com.topcit.aims.aims.dto.request.CustomerCreationRequest;
import com.topcit.aims.aims.entity.Customer;
import com.topcit.aims.aims.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    // Lấy toàn bộ khách hàng
    @GetMapping
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    // Lấy khách hàng theo ID
    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable Integer id) {
        return customerService.getCustomerById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    //Lấy khách hàng theo Email
    @GetMapping("/{email}")
    public ResponseEntity<Customer> getCutomerByEmail(@PathVariable String email){
        return customerService.getCustomerByEmail(email)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Tạo khách hàng mới
    @PostMapping
    public ResponseEntity<Customer> createCustomer(@RequestBody CustomerCreationRequest request){
        Customer saved = customerService.createCustomer(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    // Cập nhật khách hàng
    @PutMapping("/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable Integer id, @RequestBody Customer updatedCustomer) {
        try {
            return ResponseEntity.ok(customerService.updateCustomer(id, updatedCustomer));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Xóa khách hàng bằng Id
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomerByID(@PathVariable Integer id) {
        customerService.deleteCustomer(id);
        return ResponseEntity.noContent().build();
    }
    // Xóa khach hàng bằng Email
    @DeleteMapping("/{email}")
    public ResponseEntity<Void> deleteCustomerByEmail(@PathVariable String email){
        customerService.deleteCustomerByEmail(email);
        return ResponseEntity.noContent().build();
    }
}
