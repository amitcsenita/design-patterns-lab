package com.example.behavioral.observer;

public class Demo {
    public static void main(String[] args) {
        Stock stock = new Stock("AAPL", 150.0);
        Investor john = new Investor("John");
        Investor alice = new Investor("Alice");

        stock.addObserver(john);
        stock.addObserver(alice);

        System.out.println("First price update:");
        stock.setPrice(155.0);

        System.out.println("\nAlice unsubscribes.");
        stock.removeObserver(alice);

        System.out.println("\nSecond price update:");
        stock.setPrice(160.0);
    }
}
