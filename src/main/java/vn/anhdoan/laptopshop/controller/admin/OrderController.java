package vn.anhdoan.laptopshop.controller.admin;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import vn.anhdoan.laptopshop.domain.Order;
import vn.anhdoan.laptopshop.domain.OrderDetail;
import vn.anhdoan.laptopshop.service.OrderService;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/admin/order")
    public String getOrderPage(Model model) {
        List<Order> orders = this.orderService.getOrders();
        model.addAttribute("listOrder", orders);
        return "admin/order/show";
    }

    @GetMapping("/admin/order/{id}")
    public String getOrderDetailPage(@PathVariable long id, Model model) {
        Optional<Order> order = this.orderService.getOrderById(id);
        if (order.isPresent()) {
            List<OrderDetail> orderDetails = order.get().getOrderDetails();
            model.addAttribute("listOrderDetail", orderDetails);
        }
        return "admin/order/detail";
    }

    @GetMapping("/admin/order/update/{id}")
    public String getUpdatePage(@PathVariable long id, Model model) {
        Optional<Order> order = this.orderService.getOrderById(id);
        if (order.isPresent()) {
            model.addAttribute("order", order.get());
        }
        return "admin/order/update";
    }

    @PostMapping("/admin/order/update")
    public String hadleUpdateStatusOrder(@ModelAttribute("order") Order order) {
        this.orderService.handleUpdateStatus(order.getId(), order);

        return "redirect:/admin/order";
    }

    @GetMapping("/admin/order/delete/{id}")
    public String getMethodName(@PathVariable long id, Model model) {
        Optional<Order> order = this.orderService.getOrderById(id);
        if (order.isPresent()) {
            model.addAttribute("order", order.get());
        }
        return "admin/order/delete";
    }

    @PostMapping("/admin/order/delete")
    public String postMethodName(@ModelAttribute("order") Order order) {
        this.orderService.handleDeleteOrderAndOrderDetail(order.getId());
        return "redirect:/admin/order";
    }

}
