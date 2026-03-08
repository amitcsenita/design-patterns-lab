package com.example.creational.builder;

/**
 * Immutable Order class representing a purchase order.
 * Uses Builder pattern for flexible, validated construction.
 *
 * <p>Benefits:
 * - Immutable: Thread-safe and prevents accidental modification
 * - Validation: Ensures data integrity at build time
 * - Flexible: Optional parameters handled gracefully
 *
 * <p>Trade-offs:
 * - Verbose: Requires builder for construction
 * - Memory: Each builder instance has some overhead
 *
 * <p>Time Complexity: O(1) for getters
 * <p>Space Complexity: O(1) - fixed fields
 */
public final class Order {
    private final String item;
    private final int quantity;
    private final double price;
    private final String customerName;
    private final String shippingAddress;

    // Private constructor - only accessible via builder
    private Order(String item, int quantity, double price, String customerName, String shippingAddress) {
        this.item = item;
        this.quantity = quantity;
        this.price = price;
        this.customerName = customerName;
        this.shippingAddress = shippingAddress;
    }

    // Getters for immutable access
    public String getItem() { return item; }
    public int getQuantity() { return quantity; }
    public double getPrice() { return price; }
    public String getCustomerName() { return customerName; }
    public String getShippingAddress() { return shippingAddress; }

    public double getTotalPrice() {
        return quantity * price;
    }

    @Override
    public String toString() {
        return String.format("Order{item='%s', quantity=%d, price=%.2f, customer='%s', address='%s', total=%.2f}",
                item, quantity, price, customerName, shippingAddress, getTotalPrice());
    }

    // Static builder class
    public static class Builder {
        // Required parameters
        private final String item;
        private final int quantity;
        private final double price;

        // Optional parameters with defaults
        private String customerName = "Anonymous";
        private String shippingAddress = "Default Address";

        public Builder(String item, int quantity, double price) {
            // Validation in builder
            if (item == null || item.trim().isEmpty()) {
                throw new IllegalArgumentException("Item cannot be null or empty");
            }
            if (quantity <= 0) {
                throw new IllegalArgumentException("Quantity must be positive");
            }
            if (price < 0) {
                throw new IllegalArgumentException("Price cannot be negative");
            }

            this.item = item.trim();
            this.quantity = quantity;
            this.price = price;
        }

        public Builder customerName(String customerName) {
            if (customerName != null && !customerName.trim().isEmpty()) {
                this.customerName = customerName.trim();
            }
            return this;
        }

        public Builder shippingAddress(String shippingAddress) {
            if (shippingAddress != null && !shippingAddress.trim().isEmpty()) {
                this.shippingAddress = shippingAddress.trim();
            }
            return this;
        }

        public Order build() {
            // Additional validation if needed
            if (customerName.length() > 100) {
                throw new IllegalStateException("Customer name too long");
            }
            if (shippingAddress.length() > 500) {
                throw new IllegalStateException("Shipping address too long");
            }

            return new Order(item, quantity, price, customerName, shippingAddress);
        }
    }
}
