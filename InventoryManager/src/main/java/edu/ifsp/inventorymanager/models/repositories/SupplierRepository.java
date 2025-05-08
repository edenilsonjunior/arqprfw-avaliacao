package edu.ifsp.inventorymanager.models.repositories;


import edu.ifsp.inventorymanager.models.entities.Supplier;
import org.springframework.data.repository.CrudRepository;

public interface SupplierRepository extends CrudRepository<Supplier, Long> {
}