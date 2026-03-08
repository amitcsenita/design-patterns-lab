package com.example.behavioral.strategy;

public class CreditCard implements PaymentStrategy {
    @Override
    public void pay(double amount) {
        System.out.println("Paying " + amount + " with credit card");
    }
}
