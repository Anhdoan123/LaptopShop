package vn.anhdoan.laptopshop.controller.client;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import vn.anhdoan.laptopshop.domain.Cart;
import vn.anhdoan.laptopshop.domain.CartDetail;
import vn.anhdoan.laptopshop.domain.Product;
import vn.anhdoan.laptopshop.domain.User;
import vn.anhdoan.laptopshop.service.CartDetailsService;
import vn.anhdoan.laptopshop.service.CartService;
import vn.anhdoan.laptopshop.service.ProductService;
import vn.anhdoan.laptopshop.service.UserService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ItemController {
    private final ProductService productService;
    private final UserService userService;
    private final CartDetailsService cartDetailsService;
    private final CartService cartService;

    public ItemController(ProductService productService, UserService userService, CartDetailsService cartDetailsService,
            CartService cartService) {
        this.productService = productService;
        this.userService = userService;
        this.cartDetailsService = cartDetailsService;
        this.cartService = cartService;
    }

    @GetMapping("/product/{id}")
    public String getProductDetailPage(@PathVariable("id") long id, Model model) {
        Product product = this.productService.getProductById(id);
        model.addAttribute("product", product);
        return "client/product/detail";
    }

    @GetMapping("/cart")
    public String getCartPage(HttpSession session, Model model) {
        String email = (String) session.getAttribute("email");
        List<CartDetail> cartDetails = this.cartDetailsService.getCartDetails(email);
        User user = this.userService.getUserByEmail(email);
        Cart cart = this.cartService.getCartByUser(user);
        model.addAttribute("listCartDetail", cartDetails);
        model.addAttribute("cart", cart);
        return "client/cart/show";
    }

    @PostMapping("/add-product-to-cart/{id}")
    public String handleAddProductToCart(@PathVariable("id") long id, HttpSession session) {
        String email = (String) session.getAttribute("email");
        this.productService.handleAddProductToCart(email, id, session);
        return "redirect:/";
    }

    @PostMapping("/delete-cart-detail/{id}")
    public String handleDeleteCartDetail(@PathVariable long id, HttpSession session) {
        this.productService.handleRemoveCartDetail(id, session);
        return "redirect:/cart";
    }

    @GetMapping("/checkout")
    public String getCheckOutPage(Model model, HttpSession session) {
        User currentUser = new User();
        long id = (long) session.getAttribute("id");
        currentUser.setId(id);
        Cart cart = this.cartService.getCartByUser(currentUser);
        List<CartDetail> cartDetails = cart == null ? new ArrayList<CartDetail>() : cart.getCartDetails();
        model.addAttribute("listCartDetail", cartDetails);
        return "client/cart/checkout";
    }

    @PostMapping("/confirm-checkout")
    public String getCheckOutPage(@ModelAttribute("cart") Cart cart) {
        List<CartDetail> cartDetails = cart == null ? new ArrayList<CartDetail>() : cart.getCartDetails();
        this.productService.handleUpdateCartBeforeCheckout(cartDetails);
        return "redirect:/checkout";
    }

    @PostMapping("/place-order")
    public String placeOrderUser(HttpSession session,
            @RequestParam("receiverName") String receiverName,
            @RequestParam("receiverAddress") String receiverAddress,
            @RequestParam("receiverPhone") String receiverPhone) {
        String email = (String) session.getAttribute("email");
        // this.productService.handleSaveOrder(email, receiverName, receiverAddress,
        // receiverPhone, session);
        return "redirect:/thanks";
    }

}
