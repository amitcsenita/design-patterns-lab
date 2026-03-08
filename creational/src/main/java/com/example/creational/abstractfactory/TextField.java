package com.example.creational.abstractfactory;

/**
 * Abstract text field component.
 */
public interface TextField {
    void render();
    void setText(String text);
    String getText();
}
