package vn.anhdoan.laptopshop.controller.admin;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import vn.anhdoan.laptopshop.domain.Product;
import vn.anhdoan.laptopshop.service.ProductService;
import vn.anhdoan.laptopshop.service.UploadService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class ProductController {
    private final UploadService uploadService;
    private final ProductService productService;

    public ProductController(UploadService uploadService, ProductService productService) {
        this.uploadService = uploadService;
        this.productService = productService;
    }

    @GetMapping("/admin/product")
    public String getProductPage(Model model) {
        List<Product> products = this.productService.getAllProduct();
        model.addAttribute("listProduct", products);
        return "admin/product/show";
    }

    @GetMapping("/admin/product/create")
    public String getCreateProductPage(Model model) {
        model.addAttribute("newProduct", new Product());
        return "admin/product/create";
    }

    @PostMapping("/admin/product/create")
    public String handleCreateProduct(@ModelAttribute("newProduct") Product product,
            @RequestParam("imgFile") MultipartFile file) {
        System.out.println(product);
        String image = "";
        if (file.isEmpty()) {
            image = "";
        } else {
            image = this.uploadService.handleSaveUploadFile(file, "product");
        }
        if (product != null) {
            product.setImage(image);
            this.productService.handleSaveProduct(product);
        }

        return "redirect:/admin/product";
    }

}
