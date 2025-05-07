package edu.ifsp.inventorymanager.controllers;

import edu.ifsp.inventorymanager.models.entities.Supplier;
import edu.ifsp.inventorymanager.models.repositories.SupplierRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/supplier")
public class SupplierController {

    private final SupplierRepository supplierRepository;

    public SupplierController(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("supplier", new Supplier());
        return "create-supplier";
    }

    @PostMapping("/save")
    public void save(Model model, Supplier supplier) {
        supplierRepository.save(supplier);
    }

}
