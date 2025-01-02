package vn.anhdoan.laptopshop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;
import vn.anhdoan.laptopshop.domain.Cart;
import vn.anhdoan.laptopshop.domain.CartDetail;
import vn.anhdoan.laptopshop.domain.Order;
import vn.anhdoan.laptopshop.domain.OrderDetail;
import vn.anhdoan.laptopshop.domain.Product;
import vn.anhdoan.laptopshop.domain.User;
import vn.anhdoan.laptopshop.repository.CartDetailRepository;
import vn.anhdoan.laptopshop.repository.CartRepository;
import vn.anhdoan.laptopshop.repository.OrderDetailRepository;
import vn.anhdoan.laptopshop.repository.OrderRepository;
import vn.anhdoan.laptopshop.repository.ProductRepository;
import vn.anhdoan.laptopshop.repository.UserRepository;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final UserRepository userRepository;
    private final CartRepository cartRepository;
    private final CartDetailRepository cartDetailRepository;
    private final OrderRepository orderRepository;
    private final OrderDetailRepository orderDetailRepository;

    public ProductService(ProductRepository productRepository, UserRepository userRepository,
            CartRepository cartRepository, CartDetailRepository cartDetailRepository, OrderRepository orderRepository,
            OrderDetailRepository orderDetailRepository) {
        this.productRepository = productRepository;
        this.userRepository = userRepository;
        this.cartRepository = cartRepository;
        this.cartDetailRepository = cartDetailRepository;
        this.orderRepository = orderRepository;
        this.orderDetailRepository = orderDetailRepository;
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

    public void handleAddProductToCart(String email, long productId, HttpSession session, long quantity) {
        User user = this.userRepository.findByEmail(email);
        Product product = this.productRepository.findById(productId);
        Cart cart = this.cartRepository.findByUser(user);
        CartDetail cartDetail = new CartDetail();
        if (user != null) {
            // Kiem tra neu cart ch ton tai thi tao moi
            if (cart == null) {
                Cart newCart = new Cart();
                newCart.setSum(0);
                newCart.setUser(user);
                cart = this.cartRepository.save(newCart);

            }
            // Check san pham da co trong gio hang chua
            CartDetail cartDetailFound = this.cartDetailRepository.findByCartAndProduct(cart, product);
            // Co roi thi tang quantity len
            if (cartDetailFound != null) {
                cartDetailFound.setQuantity(cartDetailFound.getQuantity() + quantity);
                this.cartDetailRepository.save(cartDetailFound);
                // Chua co thi tao cart detail moi va set lai sum
            } else {
                cartDetail.setCart(cart);
                cartDetail.setPrice(product.getPrice());
                cartDetail.setProduct(product);
                cartDetail.setQuantity(quantity);
                this.cartDetailRepository.save(cartDetail);
                cart.setSum(cart.getSum() + 1);
                this.cartRepository.save(cart);
                session.setAttribute("sum", cart.getSum());
            }

        }
    }

    public void handleRemoveCartDetail(long id, HttpSession session) {
        Optional<CartDetail> cartDetail = this.cartDetailRepository.findById(id);
        if (cartDetail.isPresent()) {
            this.cartDetailRepository.deleteById(id);
            Cart cart = cartDetail.get().getCart();
            if (cart != null) {
                if (cart.getSum() > 1) {
                    cart.setSum(cart.getSum() - 1);
                    session.setAttribute("sum", cart.getSum());
                } else {
                    this.cartRepository.deleteById(cart.getId());
                    session.setAttribute("sum", 0);
                }
            }
        }
    }

    public void handleUpdateCartBeforeCheckout(List<CartDetail> cartDetails) {
        for (CartDetail cartDetail : cartDetails) {
            Optional<CartDetail> cdOptional = this.cartDetailRepository.findById(cartDetail.getId());
            if (cdOptional.isPresent()) {
                CartDetail currentCartDetail = cdOptional.get();
                currentCartDetail.setQuantity(cartDetail.getQuantity());
                this.cartDetailRepository.save(currentCartDetail);
            }
        }
    }

    public void handlePlaceOder(String email, HttpSession session, String receiverName, String receiverAddress,
            String receiverPhone) {
        User user = this.userRepository.findByEmail(email);
        Order order = new Order();

        order.setReceiverAddress(receiverAddress);
        order.setReceiverName(receiverName);
        order.setReceiverPhone(receiverPhone);
        order.setUser(user);
        order.setTotalPrice(0);
        order.setStatus("PENDING");
        order = this.orderRepository.save(order);

        Cart cart = user.getCart();
        if (cart != null) {
            List<CartDetail> cartDetails = cart.getCartDetails();
            double totalPrice = 0;
            for (CartDetail cartDetail : cartDetails) {
                OrderDetail orderDetail = new OrderDetail();
                orderDetail.setOrder(order);
                orderDetail.setProduct(cartDetail.getProduct());
                orderDetail.setQuantity(cartDetail.getQuantity());
                this.orderDetailRepository.save(orderDetail);
                totalPrice += cartDetail.getPrice() * cartDetail.getQuantity();
                this.cartDetailRepository.deleteById(cartDetail.getId());

            }
            order.setTotalPrice(totalPrice);
            this.cartRepository.deleteById(cart.getId());
            session.setAttribute("sum", 0);
        }

    }

    public long getNumberProduct() {
        return this.productRepository.count();
    }

}
