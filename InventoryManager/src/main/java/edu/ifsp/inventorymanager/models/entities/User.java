package edu.ifsp.inventorymanager.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Data
public class User {

    @Id
    private Long id;

    @NotBlank(message = "Informe o nome")
    @Column(nullable = false, length = 100)
    private String name;

    @NotBlank(message = "Informe o email")
    @Column(nullable = false, length = 100)
    @Email(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}")
    private String email;

    @Column(nullable = false, length = 100)
    @Min(value = 8, message = "A senha precisa ter no minimo 8 caracteres")
    private String password;
}