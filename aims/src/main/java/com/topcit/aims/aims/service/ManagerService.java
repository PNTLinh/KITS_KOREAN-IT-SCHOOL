package com.topcit.aims.aims.service;

import com.topcit.aims.aims.dto.request.ManagerCreationRequest;
import com.topcit.aims.aims.entity.Manager;
import com.topcit.aims.aims.entity.Order;
import com.topcit.aims.aims.entity.Product;
import com.topcit.aims.aims.repository.ManagerRepository;
import com.topcit.aims.aims.repository.OrderRepository;
import com.topcit.aims.aims.repository.ProductRepository;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ManagerService {
    private final ManagerRepository managerRepository;
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public ManagerService(ManagerRepository managerRepository,
                          OrderRepository orderRepository,
                          ProductRepository productRepository) {
        this.managerRepository = managerRepository;
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
    }

    // ---- Quản lý Manager ----
    public List<Manager> getAllManagers() {
        return managerRepository.findAll();
    }

    public Optional<Manager> getManagerById(Integer id) {
        return managerRepository.findById(id);
    }

    public Optional<Manager> getManagerByEmail(String email) {
        return managerRepository.findByEmail(email);
    }

    public Manager createManager(ManagerCreationRequest request) {
        Manager manager = new Manager();
        manager.setFullName(request.getFullName());
        manager.setEmail(request.getEmail());

        // Mã hoá mật khẩu
        String encodedPassword = passwordEncoder.encode(request.getPasswordHash());
        manager.setPasswordHash(encodedPassword);

        return managerRepository.save(manager);
    }

    public Manager updateManager(Integer id, Manager updatedManager) {
        return managerRepository.findById(id)
                .map(m -> {
                    m.setFullName(updatedManager.getFullName());
                    m.setEmail(updatedManager.getEmail());
                    if (updatedManager.getPasswordHash() != null) {
                        String encodedPassword = passwordEncoder.encode(updatedManager.getPasswordHash());
                        m.setPasswordHash(encodedPassword);
                    }
                    return managerRepository.save(m);
                })
                .orElseThrow(() -> new RuntimeException("Manager not found with id " + id));
    }

    public void deleteManager(Integer id) {
        managerRepository.deleteById(id);
    }

    public void deleteManagerByEmail(String email) {
        managerRepository.deleteByEmail(email);
    }

    // ---- Quản lý đơn hàng ----
    public List<Order> getPendingOrders() {
        return orderRepository.findByStatus("PENDING");
    }

    public Order approveOrder(Integer orderId) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found"));
        order.setStatus("APPROVED");
        return orderRepository.save(order);
    }

    public Order rejectOrder(Integer orderId) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found"));
        order.setStatus("REJECTED");
        return orderRepository.save(order);
    }

    // ---- Quản lý sản phẩm ----
    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    public void deleteProduct(Integer productId) {
        productRepository.deleteById(productId);
    }
}
