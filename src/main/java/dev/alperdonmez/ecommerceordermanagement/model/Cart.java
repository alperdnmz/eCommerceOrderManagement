package dev.alperdonmez.ecommerceordermanagement.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Table(name="Cart")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cart extends BaseEntityAudit{

    @OneToOne
    @JoinColumn(name = "customerId", referencedColumnName = "id")
    private Customer customer;

    /*@ManyToOne
    @JoinColumn(name = "productId", referencedColumnName = "id")
    private Product product;*/

    @OneToMany(mappedBy = "cart" , cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CartItem> cartItems;

    @Column(name = "totalPrice")
    private double totalPrice;
}
