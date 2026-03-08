package com.example.structural.adapter;

public class Demo {
    public static void main(String[] args) {
        LegacyAPI legacy = new LegacyAPI();
        ModernAPI adapter = new APIAdapter(legacy);
        adapter.newMethod();
    }
}
