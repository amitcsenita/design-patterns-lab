package com.example.creational.prototype;

/**
 * Warrior character prototype.
 * High health, melee-focused skills.
 */
public class Warrior extends GameCharacter {
    public Warrior(String name, int health) {
        super(name, health);
        // Customize warrior skills
        skills[0] = 15; // Strength
        skills[1] = 10; // Agility
        skills[2] = 20; // Defense
        attributes.put("class", "Warrior");
        attributes.put("weapon", "Sword");
    }

    @Override
    public void attack() {
        System.out.println(name + " swings sword with " + skills[0] + " strength!");
    }
}
