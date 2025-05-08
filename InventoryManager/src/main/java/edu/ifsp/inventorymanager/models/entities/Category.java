package edu.ifsp.inventorymanager.models.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity(name = "category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 50)
    private String name;

    @Column(nullable = false, length = 200)
    private String description;

}