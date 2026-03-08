package com.example.behavioral.interpreter;

public class Demo {
    public static void main(String[] args) {
        // 5 + (10 - 3)
        Expression expression = new AddExpression(
            new NumberExpression(5),
            new SubtractExpression(
                new NumberExpression(10),
                new NumberExpression(3)
            )
        );

        System.out.println("Result: " + expression.interpret());
    }
}
