package vn.anhdoan.laptopshop.controller.client;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import vn.anhdoan.laptopshop.domain.CartDetail;
import vn.anhdoan.laptopshop.domain.Product;
import vn.anhdoan.laptopshop.domain.User;
import vn.anhdoan.laptopshop.service.CartDetailsService;
import vn.anhdoan.laptopshop.service.ProductService;
import vn.anhdoan.laptopshop.service.UserService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import jakarta.servlet.http.HttpSession;

@Controller
public class ItemController {
    private final ProductService productService;
    private final UserService userService;
    private final CartDetailsService cartDetailsService;

    public ItemController(ProductService productService, UserService userService,
            CartDetailsService cartDetailsService) {
        this.productService = productService;
        this.userService = userService;
        this.cartDetailsService = cartDetailsService;
    }

    @GetMapping("/product/{id}")
    public String getMethodName(@PathVariable("id") long id, Model model) {
        Product product = this.productService.getProductById(id);
        model.addAttribute("product", product);
        return "client/product/detail";
    }

    @GetMapping("/cart")
    public String getCartPage(HttpSession session, Model model) {
        String email = (String) session.getAttribute("email");
        List<CartDetail> cartDetails = this.cartDetailsService.getCartDetails(email);
        model.addAttribute("listCartDetail", cartDetails);
        return "client/cart/show";
    }

    @PostMapping("/add-product-to-cart/{id}")
    public String handleAddProductToCart(@PathVariable("id") long id, HttpSession session) {
        String email = (String) session.getAttribute("email");
        this.productService.handleAddProductToCart(email, id);
        return "redirect:/";
    }

    @PostMapping("/delete-cart-detail/{id}")
    public String handleDeleteCartDetail(@PathVariable long id, HttpSession session) {
        String email = (String) session.getAttribute("email");
        this.cartDetailsService.handleDeleteCartDetail(email, id);
        return "redirect:/cart";
    }

}
