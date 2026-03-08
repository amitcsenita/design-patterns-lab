package com.example.behavioral.observer;

public class Demo {
    public static void main(String[] args) {
        Stock stock = new Stock("AAPL", 150.0);
        Investor investor = new Investor("John");
        stock.addObserver(investor);
        stock.setPrice(155.0);
    }
}
