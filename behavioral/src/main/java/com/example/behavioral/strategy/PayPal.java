package com.example.behavioral.strategy;

public class PayPal implements PaymentStrategy {
    @Override
    public void pay(double amount) {
        System.out.println("Paying " + amount + " with PayPal");
    }
}
