package com.example.creational.factorymethod;

/**
 * Demonstration of Factory Method pattern with realistic notification scenarios.
 * Shows enum-based factory usage and error handling.
 */
public class Demo {
    public static void main(String[] args) {
        System.out.println("=== Factory Method Pattern Demo ===\n");

        // Enum-based factory (recommended)
        System.out.println("1. Enum-based notification creation:");
        Notification email = NotificationFactory.createNotification(NotificationFactory.NotificationType.EMAIL);
        email.send("Welcome to our platform!");

        Notification sms = NotificationFactory.createNotification(NotificationFactory.NotificationType.SMS);
        sms.send("Your verification code is 123456");

        Notification push = NotificationFactory.createNotification(NotificationFactory.NotificationType.PUSH);
        push.send("New message received");

        // Legacy string-based factory
        System.out.println("\n2. String-based notification creation (legacy):");
        Notification email2 = NotificationFactory.createNotification("email");
        email2.send("Account activated successfully");

        // Error handling
        System.out.println("\n3. Error handling:");
        try {
            NotificationFactory.createNotification((String) null);
        } catch (IllegalArgumentException e) {
            System.out.println("Caught expected error: " + e.getMessage());
        }

        try {
            NotificationFactory.createNotification("unknown");
        } catch (IllegalArgumentException e) {
            System.out.println("Caught expected error: " + e.getMessage());
        }

        System.out.println("\n=== Demo Complete ===");
    }
}
