package vn.anhdoan.laptopshop.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import vn.anhdoan.laptopshop.domain.Cart;
import vn.anhdoan.laptopshop.domain.User;
import vn.anhdoan.laptopshop.repository.CartRepository;

@Service
public class CartService {
    private final CartRepository cartRepository;

    public CartService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    public Optional<Cart> getCardById(long id) {
        return this.cartRepository.findById(id);
    }

    public void handleDeleteById(long id) {
        this.cartRepository.deleteById(id);
    }

    public Cart getCartByUser(User user) {
        return this.cartRepository.findByUser(user);
    }
}
