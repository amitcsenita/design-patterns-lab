package com.example.creational.abstractfactory;

public class Demo {
    public static void main(String[] args) {
        UITheme theme = new WindowsTheme();
        Button button = theme.createButton();
        button.render();
    }
}
