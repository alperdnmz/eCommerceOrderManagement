package dev.alperdonmez.ecommerceordermanagement.model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
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

    private  double purchasePrice;
    private int quantity;
}
