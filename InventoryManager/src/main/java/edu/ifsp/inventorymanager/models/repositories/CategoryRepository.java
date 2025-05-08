package edu.ifsp.inventorymanager.models.repositories;

import edu.ifsp.inventorymanager.models.entities.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long> {
}