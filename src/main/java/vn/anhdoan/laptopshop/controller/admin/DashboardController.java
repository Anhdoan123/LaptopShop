package vn.anhdoan.laptopshop.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import vn.anhdoan.laptopshop.service.OrderService;
import vn.anhdoan.laptopshop.service.ProductService;
import vn.anhdoan.laptopshop.service.UserService;

@Controller
public class DashboardController {
    private final UserService userService;
    private final ProductService productService;
    private final OrderService orderService;

    public DashboardController(UserService userService, ProductService productService, OrderService orderService) {
        this.userService = userService;
        this.productService = productService;
        this.orderService = orderService;
    }

    @GetMapping("/admin")
    public String getDashboard(Model model) {
        long numberUser = this.userService.getNumberUser();
        long numberProduct = this.productService.getNumberProduct();
        long numberOrder = this.orderService.getNumberOrder();
        model.addAttribute("numberUser", numberUser);
        model.addAttribute("numberProduct", numberProduct);
        model.addAttribute("numberOrder", numberOrder);
        return "admin/dashboard/show";
    }
}
