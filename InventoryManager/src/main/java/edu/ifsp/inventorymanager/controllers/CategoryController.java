package edu.ifsp.inventorymanager.controllers;


import edu.ifsp.inventorymanager.models.entities.Category;
import edu.ifsp.inventorymanager.models.repositories.CategoryRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryRepository categoryRepository;

    public CategoryController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @GetMapping("/register")
    public String register(Model model) {

        model.addAttribute("category", new Category());

        return "categories/create-category";
    }

    @PostMapping("/save")
    public String save(Category category, Model model) {

        log.info("saving employee {}", category);

        categoryRepository.save(category);

        return "redirect:/categories/list-categories";
    }

    @GetMapping("/list")
    public String list(Model model) {

        model.addAttribute("categories", categoryRepository.findAll());
        return "categories/list-categories";
    }
}