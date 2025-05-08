package edu.ifsp.inventorymanager.models.entities;

import edu.ifsp.inventorymanager.models.enums.StockMovementType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity(name = "stock_movement")
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StockMovement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "movement_type", nullable = false)
    @Enumerated(EnumType.STRING)
    private StockMovementType movementType;

    @Column(nullable = false)
    private Integer quantity;

    @Column(name = "movement_date", nullable = false)
    private LocalDateTime movementDate;

    @Column(nullable = false)
    private String observations;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @PrePersist
    public void prePersist() {
        this.movementDate = LocalDateTime.now();
    }

}
