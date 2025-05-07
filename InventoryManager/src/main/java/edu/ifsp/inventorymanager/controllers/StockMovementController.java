package edu.ifsp.inventorymanager.controllers;

import edu.ifsp.inventorymanager.models.entities.StockMovement;
import edu.ifsp.inventorymanager.models.repositories.StockMovementRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/stock-movement")
public class StockMovementController {

    private final StockMovementRepository stockMovementRepository;

    public StockMovementController(StockMovementRepository stockMovementRepository) {
        this.stockMovementRepository = stockMovementRepository;
    }

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("stockMovement", new StockMovement());
        return "create-stock-movement";
    }

    @PostMapping("/save")
    public void save(Model model, StockMovement stockMovement) {
        stockMovementRepository.save(stockMovement);
    }

}
