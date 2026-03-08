package com.example.creational.factorymethod;

/**
 * Interface for notification services.
 * Defines the contract for sending messages through various channels.
 *
 * <p>This interface allows for polymorphic notification sending,
 * enabling different implementations (email, SMS, push) to be used interchangeably.
 */
public interface Notification {
    /**
     * Sends a message through the notification channel.
     *
     * @param message the message to send
     * @throws IllegalArgumentException if message is null or empty
     */
    void send(String message);
}
