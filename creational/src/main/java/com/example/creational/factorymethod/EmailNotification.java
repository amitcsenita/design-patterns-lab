package com.example.creational.factorymethod;

/**
 * Email notification implementation.
 * Sends messages via email using SMTP or similar protocols.
 *
 * <p>In production, this would integrate with email services like SendGrid,
 * Amazon SES, or JavaMail API.
 */
public class EmailNotification implements Notification {
    @Override
    public void send(String message) {
        // Simulate email sending
        System.out.println("Sending email: " + message);
        // Production: integrate with email service
    }
}
