package com.example.creational.prototype;

public abstract class GameCharacter implements Cloneable {
    protected String name;
    protected int health;

    public GameCharacter(String name, int health) {
        this.name = name;
        this.health = health;
    }

    public abstract void attack();

    @Override
    public GameCharacter clone() {
        try {
            return (GameCharacter) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}
