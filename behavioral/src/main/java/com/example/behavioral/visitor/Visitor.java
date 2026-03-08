package com.example.behavioral.visitor;

public interface Visitor {
    void visit(Circle circle);
    void visit(Rectangle rectangle);
}
