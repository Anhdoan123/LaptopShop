package vn.anhdoan.laptopshop.service;

import java.util.List;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import vn.anhdoan.laptopshop.domain.Cart;
import vn.anhdoan.laptopshop.domain.CartDetail;
import vn.anhdoan.laptopshop.domain.Product;
import vn.anhdoan.laptopshop.domain.User;
import vn.anhdoan.laptopshop.repository.CartDetailRepository;
import vn.anhdoan.laptopshop.repository.CartRepository;
import vn.anhdoan.laptopshop.repository.ProductRepository;
import vn.anhdoan.laptopshop.repository.UserRepository;

@Service
public class CartDetailsService {
    private final ProductRepository productRepository;
    private final UserRepository userRepository;
    private final CartRepository cartRepository;
    private final CartDetailRepository cartDetailRepository;

    public CartDetailsService(ProductRepository productRepository, UserRepository userRepository,
            CartRepository cartRepository, CartDetailRepository cartDetailRepository) {
        this.productRepository = productRepository;
        this.userRepository = userRepository;
        this.cartRepository = cartRepository;
        this.cartDetailRepository = cartDetailRepository;
    }

    public List<CartDetail> getCartDetails(String email) {
        User user = this.userRepository.findByEmail(email);
        List<CartDetail> cartDetails = null;
        if (user != null) {
            Cart cart = this.cartRepository.findByUser(user);
            if (cart != null) {
                cartDetails = this.cartDetailRepository.findByCart(cart);
            }
        }
        return cartDetails;
    }

    @Transactional
    public void handleDeleteCartDetail(String email, long productId) {
        User user = this.userRepository.findByEmail(email);
        Product product = this.productRepository.findById(productId);
        if (user != null) {
            Cart cart = this.cartRepository.findByUser(user);
            if (cart != null) {
                this.cartDetailRepository.deleteByCartAndProduct(cart, product);
            }
        }
    }

}
