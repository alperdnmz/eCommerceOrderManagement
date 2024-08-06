package dev.alperdonmez.ecommerceordermanagement.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Table(name="Product")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product extends BaseEntityAudit{

    @OneToMany(mappedBy = "product")
    private List<ProductHistory> productHistory;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private double price;

    @Column(name = "quantity")
    private int quantity;
}
