package com.example.creational.prototype;

public class Mage extends GameCharacter {
    public Mage(String name, int health) {
        super(name, health);
    }

    @Override
    public void attack() {
        System.out.println(name + " casts spell!");
    }
}
