package dev.alperdonmez.ecommerceordermanagement.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Table(name="Customer")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer extends BaseEntityAudit{

    @OneToOne(mappedBy = "customer")
    private Cart cart;

    @OneToMany(mappedBy = "customer")
    private List<CustomerOrder> customerOrders;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

    @Column(name = "address")
    private String address;

    @Column(name = "city")
    private String city;

    @Column(name = "state")
    private String state;

    @Column(name = "zip")
    private String zip;

    @Column(name = "country")
    private String country;
}
