package vn.anhdoan.laptopshop.service;

import java.util.List;

import org.springframework.stereotype.Service;

import vn.anhdoan.laptopshop.domain.Product;
import vn.anhdoan.laptopshop.repository.ProductRepository;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void handleSaveProduct(Product product) {
        this.productRepository.save(product);
    }

    public List<Product> getAllProduct() {
        return this.productRepository.findAll();
    }
}
