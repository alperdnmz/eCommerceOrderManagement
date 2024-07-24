package dev.alperdonmez.ecommerceordermanagement.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name="Cart")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cart extends BaseEntityAudit{

    @OneToOne
    @JoinColumn(name = "customerID", referencedColumnName = "id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "productID", referencedColumnName = "id")
    private Product product;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "totalPrice")
    private double totalPrice;
}
