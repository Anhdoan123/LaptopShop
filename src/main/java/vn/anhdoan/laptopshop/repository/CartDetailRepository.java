package vn.anhdoan.laptopshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import vn.anhdoan.laptopshop.domain.Cart;
import vn.anhdoan.laptopshop.domain.CartDetail;
import vn.anhdoan.laptopshop.domain.Product;

import java.util.List;

public interface CartDetailRepository extends JpaRepository<CartDetail, Long> {
    List<CartDetail> findByCart(Cart cart);

    void deleteByCartAndProduct(Cart cart, Product product);

    CartDetail findByCartAndProduct(Cart cart, Product product);
}