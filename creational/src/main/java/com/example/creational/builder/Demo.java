package com.example.creational.builder;

/**
 * Demonstration of Builder pattern with realistic order creation scenarios.
 * Shows validation, optional parameters, and immutability benefits.
 */
public class Demo {
    public static void main(String[] args) {
        System.out.println("=== Builder Pattern Demo ===\n");

        // Basic order with required fields
        System.out.println("1. Basic order:");
        Order basicOrder = new Order.Builder("Laptop", 1, 999.99).build();
        System.out.println(basicOrder);

        // Order with optional fields
        System.out.println("\n2. Complete order:");
        Order completeOrder = new Order.Builder("Mouse", 2, 25.50)
            .customerName("John Doe")
            .shippingAddress("123 Main St, Anytown, USA")
            .build();
        System.out.println(completeOrder);

        // Validation examples
        System.out.println("\n3. Validation examples:");

        // Invalid item
        try {
            new Order.Builder("", 1, 10.0).build();
        } catch (IllegalArgumentException e) {
            System.out.println("Caught validation error: " + e.getMessage());
        }

        // Invalid quantity
        try {
            new Order.Builder("Book", -1, 15.0).build();
        } catch (IllegalArgumentException e) {
            System.out.println("Caught validation error: " + e.getMessage());
        }

        // Invalid price
        try {
            new Order.Builder("Pen", 1, -5.0).build();
        } catch (IllegalArgumentException e) {
            System.out.println("Caught validation error: " + e.getMessage());
        }

        // Demonstrate immutability
        System.out.println("\n4. Immutability demonstration:");
        Order order = new Order.Builder("Tablet", 1, 299.99)
            .customerName("Jane Smith")
            .build();
        System.out.println("Original: " + order);

        // order.setCustomerName("New Name"); // This would not compile - immutable!

        System.out.println("\n=== Demo Complete ===");
    }
}
