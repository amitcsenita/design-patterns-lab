package com.example.creational.abstractfactory;

public class MacTheme implements UITheme {
    @Override
    public Button createButton() {
        return new MacButton();
    }

    @Override
    public Window createWindow() {
        return new MacWindow();
    }

    private static class MacButton implements Button {
        @Override
        public void render() {
            System.out.println("Rendering Mac button");
        }
    }

    private static class MacWindow implements Window {
        @Override
        public void render() {
            System.out.println("Rendering Mac window");
        }
    }
}
