package dev.alperdonmez.ecommerceordermanagement.enums;

public enum OrderStatus {
    WAITING_FOR_APROVAL(1),
    PROCESSING(2),
    SHIPPED(3),
    COMPLETED(4);

    private final int code;

    OrderStatus(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static OrderStatus getOrderStatus(int code) {
        for(OrderStatus orderStatus : OrderStatus.values()) {
            if(orderStatus.getCode() == code) {
                return orderStatus;
            }
        }
        throw new IllegalArgumentException("No OrderStatus with code " + code + " found");
    }
}
