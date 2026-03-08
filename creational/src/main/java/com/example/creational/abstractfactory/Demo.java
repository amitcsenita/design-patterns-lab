package com.example.creational.abstractfactory;

/**
 * Demonstration of Abstract Factory pattern with cross-platform UI theming.
 * Shows how different themes create consistent component families.
 */
public class Demo {
    public static void main(String[] args) {
        System.out.println("=== Abstract Factory Pattern Demo ===\n");

        // Windows theme
        System.out.println("1. Windows Theme:");
        UITheme windowsTheme = new WindowsTheme();

        Button winButton = windowsTheme.createButton();
        winButton.render();

        Window winWindow = windowsTheme.createWindow();
        winWindow.render();

        Checkbox winCheckbox = windowsTheme.createCheckbox();
        winCheckbox.render();
        winCheckbox.check();

        TextField winTextField = windowsTheme.createTextField();
        winTextField.render();
        winTextField.setText("Hello Windows");

        // Mac theme
        System.out.println("\n2. macOS Theme:");
        UITheme macTheme = new MacTheme();

        Button macButton = macTheme.createButton();
        macButton.render();

        Window macWindow = macTheme.createWindow();
        macWindow.render();

        Checkbox macCheckbox = macTheme.createCheckbox();
        macCheckbox.render();
        macCheckbox.check();

        TextField macTextField = macTheme.createTextField();
        macTextField.render();
        macTextField.setText("Hello macOS");

        System.out.println("\n=== Demo Complete ===");
    }
}
