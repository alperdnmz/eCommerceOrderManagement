package dev.alperdonmez.ecommerceordermanagement.model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Table(name="ProductHistory")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductHistory extends BaseEntityAudit {

    @ManyToOne
    @JoinColumn(name = "productId")
    private Product product;

    private double oldPrice;
    private LocalDateTime date;
}
