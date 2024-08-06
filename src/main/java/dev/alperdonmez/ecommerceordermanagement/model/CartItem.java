package dev.alperdonmez.ecommerceordermanagement.model;

import jakarta.persistence.*;
import lombok.*;

@Table(name="CartItem")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartItem extends BaseEntityAudit{

    @ManyToOne
    @JoinColumn(name = "cartId")
    private Cart cart;

    @ManyToOne
    @JoinColumn(name = "productId")
    private Product product;

    @Column(name = "purchasePrice")
    private double purchasePrice;

    @Column(name = "quantity")
    private int quantity;
}
