package com.example.structural.proxy;

public class Demo {
    public static void main(String[] args) {
        DatabaseConnection proxy = new DatabaseProxy();
        proxy.connect();
    }
}
