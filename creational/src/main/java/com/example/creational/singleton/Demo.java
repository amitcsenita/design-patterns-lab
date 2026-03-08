package com.example.creational.singleton;

public class Demo {
    public static void main(String[] args) {
        ThreadSafeSingleton singleton1 = ThreadSafeSingleton.getInstance();
        ThreadSafeSingleton singleton2 = ThreadSafeSingleton.getInstance();
        System.out.println(singleton1 == singleton2); // true
    }
}
