package com.example.creational.prototype;

/**
 * Mage character prototype.
 * Low health, magic-focused skills.
 */
public class Mage extends GameCharacter {
    public Mage(String name, int health) {
        super(name, health);
        // Customize mage skills
        skills[0] = 8;  // Intelligence
        skills[1] = 12; // Mana
        skills[2] = 15; // Spell power
        attributes.put("class", "Mage");
        attributes.put("spellbook", "Fire Magic");
    }

    @Override
    public void attack() {
        System.out.println(name + " casts spell with " + skills[2] + " power!");
    }
}
