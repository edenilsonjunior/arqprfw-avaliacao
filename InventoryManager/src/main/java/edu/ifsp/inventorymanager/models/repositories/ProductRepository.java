package edu.ifsp.inventorymanager.models.repositories;

import edu.ifsp.inventorymanager.models.entities.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {
}