package dev.alperdonmez.ecommerceordermanagement.model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
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

    private double purchasePrice;
    private int quantity;

}
