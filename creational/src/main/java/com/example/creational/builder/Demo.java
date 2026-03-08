package com.example.creational.builder;

public class Demo {
    public static void main(String[] args) {
        Order order = new OrderBuilder()
            .setItem("Laptop")
            .setQuantity(1)
            .setPrice(1000.0)
            .build();
        System.out.println("Order: " + order.getItem());
    }
}
