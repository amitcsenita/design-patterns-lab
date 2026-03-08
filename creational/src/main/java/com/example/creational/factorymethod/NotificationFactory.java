package com.example.creational.factorymethod;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Factory Method pattern implementation for notification creation.
 * Provides centralized notification instantiation with type safety.
 *
 * <p>Benefits:
 * - Encapsulates object creation logic
 * - Easy to extend with new notification types
 * - Type-safe enum-based factory method
 *
 * <p>Trade-offs:
 * - Static factory limits testability (use dependency injection in real apps)
 * - Switch statement grows with new types (consider registry pattern for many types)
 *
 * <p>Time Complexity: O(1) for enum-based lookup
 * <p>Space Complexity: O(1) - no significant storage
 */
public class NotificationFactory {

    // Enum for type safety and extensibility
    public enum NotificationType {
        EMAIL, SMS, PUSH
    }

    // Registry for extensibility (alternative to switch)
    private static final Map<NotificationType, Notification> registry = new ConcurrentHashMap<>();

    static {
        registry.put(NotificationType.EMAIL, new EmailNotification());
        registry.put(NotificationType.SMS, new SMSNotification());
        registry.put(NotificationType.PUSH, new PushNotification());
    }

    /**
     * Creates notification using enum-based factory method.
     * More type-safe than string-based approach.
     *
     * @param type the notification type
     * @return configured notification instance
     * @throws IllegalArgumentException if type is null
     */
    public static Notification createNotification(NotificationType type) {
        if (type == null) {
            throw new IllegalArgumentException("Notification type cannot be null");
        }

        Notification notification = registry.get(type);
        if (notification == null) {
            throw new IllegalArgumentException("Unknown notification type: " + type);
        }

        // Return new instance to avoid shared state issues
        return createNewInstance(type);
    }

    /**
     * Legacy string-based method for backward compatibility.
     * Prefer enum-based method for new code.
     */
    public static Notification createNotification(String type) {
        if (type == null || type.trim().isEmpty()) {
            throw new IllegalArgumentException("Type cannot be null or empty");
        }

        try {
            NotificationType enumType = NotificationType.valueOf(type.toUpperCase());
            return createNotification(enumType);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Unknown notification type: " + type, e);
        }
    }

    // Helper method to create new instances
    private static Notification createNewInstance(NotificationType type) {
        return switch (type) {
            case EMAIL -> new EmailNotification();
            case SMS -> new SMSNotification();
            case PUSH -> new PushNotification();
        };
    }

    /**
     * Registers a custom notification implementation.
     * Useful for testing or custom extensions.
     */
    public static void registerNotification(NotificationType type, Notification notification) {
        registry.put(type, notification);
    }
}
