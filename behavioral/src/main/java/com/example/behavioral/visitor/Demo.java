package com.example.behavioral.visitor;

import java.util.Arrays;
import java.util.List;

public class Demo {
    public static void main(String[] args) {
        List<Shape> shapes = Arrays.asList(
            new Circle(5),
            new Rectangle(4, 6)
        );

        Visitor calculator = new AreaCalculator();

        for (Shape shape : shapes) {
            shape.accept(calculator);
        }
    }
}
