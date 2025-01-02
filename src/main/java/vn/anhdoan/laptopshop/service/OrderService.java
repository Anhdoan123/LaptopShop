package vn.anhdoan.laptopshop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import vn.anhdoan.laptopshop.domain.Order;
import vn.anhdoan.laptopshop.domain.OrderDetail;
import vn.anhdoan.laptopshop.repository.OrderDetailRepository;
import vn.anhdoan.laptopshop.repository.OrderRepository;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final OrderDetailRepository orderDetailRepository;

    public OrderService(OrderRepository orderRepository, OrderDetailRepository orderDetailRepository) {
        this.orderRepository = orderRepository;
        this.orderDetailRepository = orderDetailRepository;
    }

    public List<Order> getOrders() {
        return this.orderRepository.findAll();
    }

    public Optional<Order> getOrderById(long id) {
        return this.orderRepository.findById(id);
    }

    public void handleUpdateStatus(long id, Order order) {
        Optional<Order> currentOrder = this.orderRepository.findById(id);
        if (currentOrder.isPresent()) {
            currentOrder.get().setStatus(order.getStatus());
        }
    }

    public void handleDeleteOrderAndOrderDetail(long id) {
        Optional<Order> order = this.orderRepository.findById(id);
        if (order.isPresent()) {
            List<OrderDetail> orderDetails = order.get().getOrderDetails();
            if (orderDetails != null) {
                for (OrderDetail od : orderDetails) {
                    this.orderDetailRepository.deleteById(od.getId());
                }
            }
            this.orderRepository.deleteById(order.get().getId());
        }
    }

    public long getNumberOrder() {
        return this.orderRepository.count();
    }

}
