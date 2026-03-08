package com.example.creational.singleton;

import java.lang.reflect.Constructor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Demonstration of ThreadSafeSingleton with various scenarios:
 * - Multi-threading safety
 * - Reflection attack prevention
 * - Serialization safety (would need file I/O demo)
 */
public class Demo {
    public static void main(String[] args) throws Exception {
        System.out.println("=== Singleton Pattern Demo ===\n");

        // Basic usage
        System.out.println("1. Basic singleton access:");
        ThreadSafeSingleton singleton1 = ThreadSafeSingleton.getInstance();
        ThreadSafeSingleton singleton2 = ThreadSafeSingleton.getInstance();
        System.out.println("Same instance: " + (singleton1 == singleton2));
        singleton1.doSomething();
        singleton2.doSomething();

        // Multi-threading test
        System.out.println("\n2. Multi-threading safety test:");
        ExecutorService executor = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 100; i++) {
            executor.submit(() -> {
                ThreadSafeSingleton instance = ThreadSafeSingleton.getInstance();
                instance.doSomething();
            });
        }
        executor.shutdown();
        executor.awaitTermination(5, TimeUnit.SECONDS);

        // Reflection attack prevention
        System.out.println("\n3. Reflection attack prevention:");
        try {
            Constructor<ThreadSafeSingleton> constructor = ThreadSafeSingleton.class.getDeclaredConstructor();
            constructor.setAccessible(true);
            ThreadSafeSingleton brokenSingleton = constructor.newInstance();
            System.out.println("ERROR: Reflection attack succeeded!");
        } catch (IllegalStateException e) {
            System.out.println("SUCCESS: Reflection attack prevented - " + e.getMessage());
        }

        System.out.println("\n=== Demo Complete ===");
    }
}
