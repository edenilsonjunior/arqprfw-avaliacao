package edu.ifsp.inventorymanager.controllers;

import edu.ifsp.inventorymanager.models.entities.Supplier;
import edu.ifsp.inventorymanager.models.repositories.SupplierRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
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
        return "suppliers/create-supplier";
    }

    @PostMapping("/save")
    public String save(Supplier supplier) {
        log.info(supplier.toString());
        supplierRepository.save(supplier);
        return "redirect:/supplier/list";
    }

    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("suppliers", supplierRepository.findAll());
        return "suppliers/list-suppliers";
    }

}
