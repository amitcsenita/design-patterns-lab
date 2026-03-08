package com.example.structural.bridge;

public class RasterDrawing implements DrawingAPI {
    @Override
    public void drawCircle(double x, double y, double radius) {
        System.out.println("Drawing raster circle at (" + x + "," + y + ") with radius " + radius);
    }

    @Override
    public void drawSquare(double x, double y, double side) {
        System.out.println("Drawing raster square at (" + x + "," + y + ") with side " + side);
    }
}
