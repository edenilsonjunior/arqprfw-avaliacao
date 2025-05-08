package edu.ifsp.inventorymanager.models.repositories;

import edu.ifsp.inventorymanager.models.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface UserRepository extends CrudRepository<User, Long> { }