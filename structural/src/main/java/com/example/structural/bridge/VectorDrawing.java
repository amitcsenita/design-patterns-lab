package com.example.structural.bridge;

public class VectorDrawing implements DrawingAPI {
    @Override
    public void drawCircle(double x, double y, double radius) {
        System.out.println("Drawing vector circle at (" + x + "," + y + ") with radius " + radius);
    }

    @Override
    public void drawSquare(double x, double y, double side) {
        System.out.println("Drawing vector square at (" + x + "," + y + ") with side " + side);
    }
}
