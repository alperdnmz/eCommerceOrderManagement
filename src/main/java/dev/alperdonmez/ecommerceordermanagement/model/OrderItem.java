package dev.alperdonmez.ecommerceordermanagement.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name="OrderItem")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderItem extends BaseEntityAudit {

    @ManyToOne
    @JoinColumn(name = "orderId")
    private CustomerOrder customerOrder;

    @ManyToOne
    @JoinColumn(name = "productId")
    private Product product;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "purchasePrice")
    private  double purchasePrice;
}
