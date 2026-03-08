package com.example.behavioral.strategy;

public class Demo {
    public static void main(String[] args) {
        PaymentStrategy strategy = new CreditCard();
        strategy.pay(100.0);
    }
}
