package com.example.creational.prototype;

public class Demo {
    public static void main(String[] args) {
        Warrior warrior = new Warrior("Aragorn", 100);
        Mage mage = new Mage("Gandalf", 80);
        Warrior clonedWarrior = (Warrior) warrior.clone();
        clonedWarrior.attack();
    }
}
