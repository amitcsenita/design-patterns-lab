package com.example.creational.prototype;

public class Warrior extends GameCharacter {
    public Warrior(String name, int health) {
        super(name, health);
    }

    @Override
    public void attack() {
        System.out.println(name + " swings sword!");
    }
}
