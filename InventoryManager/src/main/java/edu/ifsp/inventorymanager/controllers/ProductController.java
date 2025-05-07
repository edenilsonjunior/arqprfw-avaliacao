package edu.ifsp.inventorymanager.controllers;

import edu.ifsp.inventorymanager.models.entities.Category;
import edu.ifsp.inventorymanager.models.entities.Product;
import edu.ifsp.inventorymanager.models.repositories.CategoryRepository;
import edu.ifsp.inventorymanager.models.repositories.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/products")
public class ProductController {

    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("/register")
    public String register(Model model) {

        model.addAttribute("product", new Product());

        return "products/create-product";
    }

    @PostMapping("/save")
    public String save(Product product, Model model) {

        log.info("saving product {}", product);

        productRepository.save(product);

        return "redirect:/products/list";
    }

    @GetMapping("/list")
    public String list(Model model) {

        model.addAttribute("products", productRepository.findAll());
        return "products/list-products";
    }
}