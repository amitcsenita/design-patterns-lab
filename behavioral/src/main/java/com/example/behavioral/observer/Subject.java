package com.example.behavioral.observer;


import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Subject in the Observer pattern.
 * Manages a list of observers and notifies them of state changes.
 *
 * <p>Thread-safe implementation using CopyOnWriteArrayList to handle
 * concurrent additions/removals during notifications.
 *
 * <p>Benefits:
 * - Thread-safe observer management
 * - No external synchronization needed
 * - Fail-safe iteration during notifications
 *
 * <p>Trade-offs:
 * - Memory overhead for copy-on-write
 * - Not suitable for frequent modifications
 *
 * <p>Time Complexity: O(1) for add/remove, O(n) for notify
 * <p>Space Complexity: O(n) for observers
 */
public class Subject {
    // Thread-safe list for concurrent access
    private List<Observer> observers = new CopyOnWriteArrayList<>();

    /**
     * Adds an observer to the notification list.
     * Thread-safe operation.
     *
     * @param observer the observer to add
     */
    public void addObserver(Observer observer) {
        if (observer != null) {
            observers.add(observer);
        }
    }

    /**
     * Removes an observer from the notification list.
     * Thread-safe operation.
     *
     * @param observer the observer to remove
     */
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    /**
     * Notifies all registered observers of a state change.
     * Thread-safe - uses fail-safe iteration.
     *
     * @param message the notification message
     */
    public void notifyObservers(String message) {
        for (Observer observer : observers) {
            try {
                observer.update(message);
            } catch (Exception e) {
                // Log error but continue notifying others
                System.err.println("Error notifying observer: " + e.getMessage());
            }
        }
    }
}
