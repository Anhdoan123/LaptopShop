package vn.anhdoan.laptopshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import vn.anhdoan.laptopshop.domain.Cart;
import vn.anhdoan.laptopshop.domain.User;

public interface CartRepository extends JpaRepository<Cart, Long> {
    Cart findByUser(User user);

    // Cart findByCartDetails(CartDetail cartDetail);
}
