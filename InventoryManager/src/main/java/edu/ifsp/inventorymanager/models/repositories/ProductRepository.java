package edu.ifsp.inventorymanager.models.repositories;

import edu.ifsp.inventorymanager.models.entities.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> { }


