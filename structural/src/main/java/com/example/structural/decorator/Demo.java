package com.example.structural.decorator;

public class Demo {
    public static void main(String[] args) {
        Coffee coffee = new SimpleCoffee();
        coffee = new MilkDecorator(coffee);
        System.out.println(coffee.description() + " costs " + coffee.cost());
    }
}
