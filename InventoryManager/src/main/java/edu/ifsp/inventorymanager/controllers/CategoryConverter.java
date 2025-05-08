package edu.ifsp.inventorymanager.controllers;

import edu.ifsp.inventorymanager.models.entities.Category;
import edu.ifsp.inventorymanager.models.repositories.CategoryRepository;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class CategoryConverter implements Converter<String, Category> {

    private final CategoryRepository categoryRepository;

    public CategoryConverter(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category convert(String source) {

        var code = Long.parseLong(source);
        return categoryRepository.findById(code).get();
    }
}