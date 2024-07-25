package dev.alperdonmez.ecommerceordermanagement.model;

import org.hibernate.cache.spi.support.AbstractReadWriteAccess;

public class OrderItem extends BaseEntityAudit {
    private Product product;
    private int quantity;
    private double totalPrice;
}
