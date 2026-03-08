package com.example.behavioral.strategy;

public class Crypto implements PaymentStrategy {
    @Override
    public void pay(double amount) {
        System.out.println("Paying " + amount + " with crypto");
    }
}
