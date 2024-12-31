package vn.anhdoan.laptopshop.service;

import java.util.List;

import org.springframework.stereotype.Service;

import vn.anhdoan.laptopshop.domain.Cart;
import vn.anhdoan.laptopshop.domain.CartDetail;
import vn.anhdoan.laptopshop.domain.Product;
import vn.anhdoan.laptopshop.domain.User;
import vn.anhdoan.laptopshop.repository.CartDetailRepository;
import vn.anhdoan.laptopshop.repository.CartRepository;
import vn.anhdoan.laptopshop.repository.ProductRepository;
import vn.anhdoan.laptopshop.repository.UserRepository;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final UserRepository userRepository;
    private final CartRepository cartRepository;
    private final CartDetailRepository cartDetailRepository;

    public ProductService(ProductRepository productRepository, UserRepository userRepository,
            CartRepository cartRepository, CartDetailRepository cartDetailRepository) {
        this.productRepository = productRepository;
        this.userRepository = userRepository;
        this.cartRepository = cartRepository;
        this.cartDetailRepository = cartDetailRepository;
    }

    public void handleSaveProduct(Product product) {
        this.productRepository.save(product);
    }

    public List<Product> getAllProduct() {
        return this.productRepository.findAll();
    }

    public Product getProductById(long id) {
        return this.productRepository.findById(id);
    }

    public void handleDeleteProduct(long id) {
        this.productRepository.deleteById(id);
    }

    public void handleAddProductToCart(String email, long productId) {
        User user = this.userRepository.findByEmail(email);
        Product product = this.productRepository.findById(productId);
        CartDetail cartDetail = new CartDetail();
        if (user != null) {
            Cart cart = this.cartRepository.findByUser(user);

            if (cart == null) {
                Cart newCart = new Cart();
                newCart.setSum(1);
                newCart.setUser(user);
                cart = this.cartRepository.save(newCart);

            }
            cartDetail.setCart(cart);
            CartDetail cartDetailFound = this.cartDetailRepository.findByCartAndProduct(cart, product);
            if (cartDetailFound != null) {
                cartDetailFound.setQuantity(cartDetailFound.getQuantity() + 1);
                this.cartDetailRepository.save(cartDetailFound);
            } else {
                cartDetail.setPrice(product.getPrice());
                cartDetail.setProduct(product);
                cartDetail.setQuantity(1);
                this.cartDetailRepository.save(cartDetail);
            }

        }
    }
}
