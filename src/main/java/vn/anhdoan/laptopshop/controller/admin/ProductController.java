package vn.anhdoan.laptopshop.controller.admin;

import java.text.DecimalFormat;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import vn.anhdoan.laptopshop.domain.Product;
import vn.anhdoan.laptopshop.service.ProductService;
import vn.anhdoan.laptopshop.service.UploadService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.Valid;

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
    public String handleCreateProduct(@ModelAttribute("newProduct") @Valid Product product,
            BindingResult newProductBindingResult,
            @RequestParam("imgFile") MultipartFile file) {

        if (newProductBindingResult.hasErrors()) {
            return "admin/product/create";
        }
        if (!file.isEmpty()) {
            String image = this.uploadService.handleSaveUploadFile(file, "product");
            product.setImage(image);
        }
        this.productService.handleSaveProduct(product);
        return "redirect:/admin/product";
    }

    @GetMapping("/admin/product/{id}")
    public String getUserDetailPage(Model model, @PathVariable long id) {
        Product product = this.productService.getProductById(id);
        model.addAttribute("productDetail", product);
        return "admin/product/detail";
    }

    @GetMapping("/admin/product/update/{id}")
    public String getUpdateProductPage(Model model, @PathVariable long id) {
        Product product = this.productService.getProductById(id);
        model.addAttribute("product", product);
        return "admin/product/update";
    }

    @PostMapping("/admin/product/update")
    public String updateProduct(@ModelAttribute("product") @Valid Product product, BindingResult productBindingResult,
            @RequestParam("imgFile") MultipartFile file) {
        if (productBindingResult.hasErrors()) {

            return "admin/product/update";
        }
        Product currentProduct = this.productService.getProductById(product.getId());
        String imgName = "";
        if (!file.isEmpty()) {
            imgName = uploadService.handleSaveUploadFile(file, "product");
            currentProduct.setImage(imgName);
        }

        currentProduct.setName(product.getName());
        currentProduct.setPrice(product.getPrice());
        currentProduct.setDetailDesc(product.getDetailDesc());
        currentProduct.setShortDesc(product.getShortDesc());
        currentProduct.setQuantity(product.getQuantity());
        currentProduct.setFactory(product.getFactory());
        currentProduct.setTarget(product.getTarget());

        this.productService.handleSaveProduct(currentProduct);

        return "redirect:/admin/product";
    }

    @GetMapping("/admin/product/delete/{id}")
    public String getDeleteProductPage(@PathVariable long id, Model model) {
        Product product = this.productService.getProductById(id);
        model.addAttribute("product", product);
        return "admin/product/delete";
    }

    @PostMapping("/admin/product/delete")
    public String deleteProduct(@ModelAttribute("product") Product product) {
        this.productService.handleDeleteProduct(product.getId());
        return "redirect:/admin/product";
    }

}
