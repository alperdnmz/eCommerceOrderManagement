package dev.alperdonmez.ecommerceordermanagement.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CartItem extends BaseEntityAudit{
    private Product product;
    private int quantity;
    private double totalPrice;
}
