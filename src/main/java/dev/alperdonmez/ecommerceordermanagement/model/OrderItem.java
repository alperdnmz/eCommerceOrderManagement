package dev.alperdonmez.ecommerceordermanagement.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
    @JsonBackReference
    private CustomerOrder customerOrder;

    @ManyToOne
    @JoinColumn(name = "productId")
    private Product product;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "purchasePrice")
    private  double purchasePrice;
}
