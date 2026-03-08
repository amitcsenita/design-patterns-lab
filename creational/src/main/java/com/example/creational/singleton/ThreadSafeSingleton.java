package com.example.creational.singleton;

import java.io.Serial;
import java.io.Serializable;

/**
 * Thread-safe Singleton implementation using Double-Checked Locking (DCL) pattern.
 * Ensures only one instance exists, with lazy initialization for performance.
 *
 * <p>Trade-offs:
 * - Lazy initialization: Instance created only when first accessed (saves memory if never used)
 * - Thread-safe: Uses volatile and synchronized blocks to prevent race conditions
 * - Performance: Minimal overhead after first access due to DCL
 *
 * <p>Common pitfalls:
 * - Reflection can break singleton (handled by throwing exception in constructor)
 * - Serialization can create multiple instances (handled by readResolve)
 * - ClassLoader issues in multi-classloader environments
 *
 * <p>Time Complexity: O(1) after initialization
 * <p>Space Complexity: O(1) - single instance
 */
public class ThreadSafeSingleton implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    // Volatile ensures visibility across threads; prevents reordering by JVM
    private static volatile ThreadSafeSingleton instance;

    // Private constructor prevents external instantiation
    private ThreadSafeSingleton() {
        // Prevent reflection attacks
        if (instance != null) {
            throw new IllegalStateException("Singleton already initialized. Use getInstance() instead.");
        }
    }

    /**
     * Returns the singleton instance, creating it if necessary.
     * Thread-safe using Double-Checked Locking pattern.
     *
     * @return the singleton instance
     */
    public static ThreadSafeSingleton getInstance() {
        // First check: avoid synchronization if already initialized
        if (instance == null) {
            synchronized (ThreadSafeSingleton.class) {
                // Second check: ensure another thread didn't initialize while waiting
                if (instance == null) {
                    instance = new ThreadSafeSingleton();
                }
            }
        }
        return instance;
    }

    // Prevent multiple instances during deserialization
    @Serial
    protected Object readResolve() {
        return getInstance();
    }

    // Example method to demonstrate usage
    public void doSomething() {
        System.out.println("Singleton instance: " + this.hashCode());
    }
}
