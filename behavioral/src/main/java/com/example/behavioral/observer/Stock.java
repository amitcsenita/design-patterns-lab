package com.example.behavioral.observer;

public class Stock extends Subject {
    private String symbol;
    private double price;

    public Stock(String symbol, double price) {
        this.symbol = symbol;
        this.price = price;
    }

    public void setPrice(double price) {
        this.price = price;
        notifyObservers("Stock " + symbol + " price changed to " + price);
    }
}
