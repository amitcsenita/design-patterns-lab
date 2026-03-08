package com.example.structural.flyweight;

public class Demo {
    public static void main(String[] args) {
        Forest forest = new Forest();
        forest.plantTree(1, 2, "Oak", "Green", "Rough");
        forest.plantTree(3, 4, "Pine", "Dark Green", "Smooth");
        forest.plantTree(5, 6, "Oak", "Green", "Rough"); // reuse type
        forest.draw();
    }
}
