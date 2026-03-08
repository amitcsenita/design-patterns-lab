package com.example.behavioral.observer;

/**
 * Observer interface in the Observer pattern.
 * Defines the contract for objects that want to be notified of subject state changes.
 *
 * <p>Implementations should handle notifications asynchronously and avoid
 * blocking operations to prevent slowing down the subject.
 */
public interface Observer {
    /**
     * Called when the subject notifies observers of a state change.
     *
     * @param message the notification message from the subject
     */
    void update(String message);
}
