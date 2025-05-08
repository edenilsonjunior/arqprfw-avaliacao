package edu.ifsp.inventorymanager.controllers;

import edu.ifsp.inventorymanager.models.entities.StockMovement;
import edu.ifsp.inventorymanager.models.repositories.ProductRepository;
import edu.ifsp.inventorymanager.models.repositories.StockMovementRepository;
import edu.ifsp.inventorymanager.models.repositories.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/stock-movement")
public class StockMovementController {

    private final StockMovementRepository stockMovementRepository;
    private final ProductRepository productRepository;
    private final UserRepository userRepository;

    public StockMovementController(
            StockMovementRepository stockMovementRepository,
            ProductRepository productRepository,
            UserRepository userRepository
    ) {
        this.stockMovementRepository = stockMovementRepository;
        this.productRepository = productRepository;
        this.userRepository = userRepository;
    }

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("products", productRepository.findAll());
        model.addAttribute("users", userRepository.findAll());
        model.addAttribute("stockMovement", new StockMovement());
        return "create-stock-movement";
    }

    @PostMapping("/save")
    public String save(StockMovement stockMovement) {
        log.info(stockMovement.toString());
        stockMovementRepository.save(stockMovement);
        return "redirect:/stock-movement/list";
    }

    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("stockMovements", stockMovementRepository.findAll());
        return "stock-movement/list-stock-movement";
    }

}
