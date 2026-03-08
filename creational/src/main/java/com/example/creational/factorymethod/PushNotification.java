package com.example.creational.factorymethod;

/**
 * Push notification implementation.
 * Represents mobile/desktop push notifications.
 */
public class PushNotification implements Notification {
    @Override
    public void send(String message) {
        // Simulate push notification sending
        System.out.println("Sending push notification: " + message);
        // In real implementation: integrate with FCM/APNs
    }
}
