package dev.alperdonmez.ecommerceordermanagement.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import dev.alperdonmez.ecommerceordermanagement.enums.OrderStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Table(name="CustomerOrder")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerOrder extends BaseEntityAudit {

    @ManyToOne
    @JoinColumn(name = "customerId", referencedColumnName = "id")
    private Customer customer;

    @OneToMany(mappedBy = "customerOrder", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<OrderItem> orderItems;

    @Column(name = "status")
    @Enumerated(EnumType.ORDINAL)
    private OrderStatus status;

    @Column(name = "totalQuantity")
    private int totalQuantity;

    @Column(name = "totalPrice")
    private double totalPrice;
}
