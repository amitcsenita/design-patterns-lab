package com.example.structural.decorator;

public class SugarDecorator implements Coffee {
    private Coffee coffee;

    public SugarDecorator(Coffee coffee) {
        this.coffee = coffee;
    }

    @Override
    public double cost() {
        return coffee.cost() + 0.2;
    }

    @Override
    public String description() {
        return coffee.description() + ", sugar";
    }
}
