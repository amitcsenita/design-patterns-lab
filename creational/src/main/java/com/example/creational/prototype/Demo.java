package com.example.creational.prototype;

/**
 * Demonstration of Prototype pattern with shallow vs deep cloning
 * and prototype registry for efficient object creation.
 */
public class Demo {
    public static void main(String[] args) {
        System.out.println("=== Prototype Pattern Demo ===\n");

        // Create prototypes
        Warrior warriorPrototype = new Warrior("Aragorn", 100);
        Mage magePrototype = new Mage("Gandalf", 80);

        // Register prototypes
        GameCharacter.registerPrototype("warrior", warriorPrototype);
        GameCharacter.registerPrototype("mage", magePrototype);

        System.out.println("1. Original prototypes:");
        System.out.println(warriorPrototype);
        System.out.println(magePrototype);

        // Shallow clone demonstration
        System.out.println("\n2. Shallow clone (shares mutable state):");
        Warrior shallowWarrior = (Warrior) warriorPrototype.clone();
        shallowWarrior.setHealth(90); // Modify health
        shallowWarrior.getSkills()[0] = 20; // Modify shared skills array!

        System.out.println("Original warrior: " + warriorPrototype);
        System.out.println("Shallow clone: " + shallowWarrior);
        System.out.println("Skills shared: " + (warriorPrototype.getSkills() == shallowWarrior.getSkills()));

        // Deep clone demonstration
        System.out.println("\n3. Deep clone (independent copies):");
        Mage deepMage = (Mage) magePrototype.deepClone();
        deepMage.setHealth(70);
        deepMage.getSkills()[0] = 25; // Modify skills - should not affect original

        System.out.println("Original mage: " + magePrototype);
        System.out.println("Deep clone: " + deepMage);
        System.out.println("Skills independent: " + (magePrototype.getSkills() != deepMage.getSkills()));

        // Registry usage
        System.out.println("\n4. Prototype registry:");
        GameCharacter clonedWarrior = GameCharacter.getPrototype("warrior");
        GameCharacter clonedMage = GameCharacter.getPrototype("mage");

        if (clonedWarrior != null) {
            clonedWarrior.attack();
            System.out.println("Registry warrior: " + clonedWarrior);
        }

        if (clonedMage != null) {
            clonedMage.attack();
            System.out.println("Registry mage: " + clonedMage);
        }

        System.out.println("\n=== Demo Complete ===");
    }
}
