package com.topcit.aims.aims.service;

import com.topcit.aims.aims.entity.Customer;
import com.topcit.aims.aims.entity.Order;
import com.topcit.aims.aims.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order createOrder(Order order) {
        if (order.getCustomer() == null) {
            throw new IllegalArgumentException("Customer is required for an order");
        }
        if (order.getOrderDate() == null) {
            order.setOrderDate(LocalDate.now()); // mặc định là ngày hiện tại
        }
        return orderRepository.save(order);
    }

    // 🔹 Lấy tất cả đơn hàng
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    // 🔹 Lấy đơn hàng theo ID
    public Optional<Order> getOrderById(Integer id) {
        return orderRepository.findById(id);
    }

    // 🔹 Lấy danh sách đơn hàng theo khách hàng
    public List<Order> getOrdersByCustomer(Customer customer) {
        return orderRepository.findByCustomer(customer);
    }

    // 🔹 Lấy danh sách đơn hàng theo trạng thái
    public List<Order> getOrdersByStatus(String status) {
        return orderRepository.findByStatus(status);
    }

    // 🔹 Lấy danh sách đơn hàng theo khoảng ngày
    public List<Order> getOrdersByDateRange(LocalDate startDate, LocalDate endDate) {
        return orderRepository.findByOrderDateBetween(startDate, endDate);
    }

    // 🔹 Lấy đơn hàng có tổng tiền > amount
    public List<Order> getOrdersByTotalAmountGreaterThan(Double amount) {
        return orderRepository.findByTotalAmountGreaterThan(amount);
    }

    // 🔹 Lấy đơn hàng theo keyword trong địa chỉ giao hàng
    public List<Order> searchOrdersByShippingAddress(String keyword) {
        return orderRepository.findByShippingAddressContainingIgnoreCase(keyword);
    }

    // 🔹 Cập nhật đơn hàng
    public Order updateOrder(Integer id, Order updatedOrder) {
        return orderRepository.findById(id)
                .map(order -> {
                    order.setCustomer(updatedOrder.getCustomer());
                    order.setOrderDate(updatedOrder.getOrderDate());
                    order.setTotalAmount(updatedOrder.getTotalAmount());
                    order.setVat(updatedOrder.getVat());
                    order.setShippingFee(updatedOrder.getShippingFee());
                    order.setStatus(updatedOrder.getStatus());
                    order.setShippingAddress(updatedOrder.getShippingAddress());
                    return orderRepository.save(order);
                })
                .orElseThrow(() -> new RuntimeException("Order not found with id " + id));
    }

    // 🔹 Xóa đơn hàng
    public void deleteOrder(Integer id) {
        if (!orderRepository.existsById(id)) {
            throw new RuntimeException("Order not found with id " + id);
        }
        orderRepository.deleteById(id);
    }
}
