package com.example.creational.abstractfactory;

public class WindowsTheme implements UITheme {
    @Override
    public Button createButton() {
        return new WindowsButton();
    }

    @Override
    public Window createWindow() {
        return new WindowsWindow();
    }

    private static class WindowsButton implements Button {
        @Override
        public void render() {
            System.out.println("Rendering Windows button");
        }
    }

    private static class WindowsWindow implements Window {
        @Override
        public void render() {
            System.out.println("Rendering Windows window");
        }
    }
}
