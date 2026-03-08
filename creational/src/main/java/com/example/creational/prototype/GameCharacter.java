package com.example.creational.prototype;

import java.util.HashMap;
import java.util.Map;

/**
 * Prototype pattern for game character creation.
 * Demonstrates shallow vs deep cloning and prototype registry.
 *
 * <p>Benefits:
 * - Performance: Avoid expensive initialization
 * - Flexibility: Runtime cloning of complex objects
 * - Memory efficiency: Share common state
 *
 * <p>Trade-offs:
 * - Cloning complexity: Deep vs shallow copy decisions
 * - Hidden dependencies: Cloned objects may share mutable state
 *
 * <p>Time Complexity: O(1) for registry lookup, O(n) for deep clone
 * <p>Space Complexity: O(n) for deep cloned objects
 */
public abstract class GameCharacter implements Cloneable {
    protected String name;
    protected int health;
    protected int[] skills; // Mutable array to demonstrate deep clone
    protected Map<String, Object> attributes;

    public GameCharacter(String name, int health) {
        this.name = name;
        this.health = health;
        this.skills = new int[]{10, 20, 30}; // Default skills
        this.attributes = new HashMap<>();
        attributes.put("level", 1);
        attributes.put("experience", 0);
    }

    public abstract void attack();

    /**
     * Shallow clone - shares mutable references
     */
    @Override
    public GameCharacter clone() {
        try {
            GameCharacter cloned = (GameCharacter) super.clone();
            // Shallow clone: skills array is shared!
            return cloned;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Clone not supported", e);
        }
    }

    /**
     * Deep clone - creates independent copies
     */
    public GameCharacter deepClone() {
        try {
            GameCharacter cloned = (GameCharacter) super.clone();
            // Deep clone: create new instances for mutable fields
            cloned.skills = skills.clone();
            cloned.attributes = new HashMap<>(attributes);
            return cloned;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Deep clone not supported", e);
        }
    }

    // Getters and setters
    public String getName() { return name; }
    public int getHealth() { return health; }
    public int[] getSkills() { return skills; }
    public Map<String, Object> getAttributes() { return attributes; }

    public void setHealth(int health) { this.health = health; }

    // Prototype registry
    private static final Map<String, GameCharacter> registry = new HashMap<>();

    public static void registerPrototype(String key, GameCharacter prototype) {
        registry.put(key, prototype);
    }

    public static GameCharacter getPrototype(String key) {
        GameCharacter prototype = registry.get(key);
        return prototype != null ? prototype.deepClone() : null;
    }

    @Override
    public String toString() {
        return String.format("%s{name='%s', health=%d, skills=%s, attributes=%s}",
                getClass().getSimpleName(), name, health,
                java.util.Arrays.toString(skills), attributes);
    }
}
