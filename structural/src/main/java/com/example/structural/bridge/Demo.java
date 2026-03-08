package com.example.structural.bridge;

public class Demo {
    public static void main(String[] args) {
        Shape circle = new Circle(1, 2, 3, new RasterDrawing());
        circle.draw();

        Shape square = new Square(4, 5, 6, new VectorDrawing());
        square.draw();
    }
}
