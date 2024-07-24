package dev.alperdonmez.ecommerceordermanagement.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name="CustomerOrder")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerOrder extends BaseEntityAudit {

    @ManyToOne
    @JoinColumn(name = "customerID", referencedColumnName = "id")
    private Customer customer;


}
