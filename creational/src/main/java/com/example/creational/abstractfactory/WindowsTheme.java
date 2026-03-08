package com.example.creational.abstractfactory;

/**
 * Windows-specific UI theme implementation.
 * Creates Windows-styled components with consistent look and feel.
 */
public class WindowsTheme implements UITheme {
    @Override
    public Button createButton() {
        return new WindowsButton();
    }

    @Override
    public Window createWindow() {
        return new WindowsWindow();
    }

    @Override
    public Checkbox createCheckbox() {
        return new WindowsCheckbox();
    }

    @Override
    public TextField createTextField() {
        return new WindowsTextField();
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

    private static class WindowsCheckbox implements Checkbox {
        private boolean checked = false;

        @Override
        public void render() {
            System.out.println("Rendering Windows checkbox");
        }

        @Override
        public void check() {
            checked = !checked;
            System.out.println("Windows checkbox " + (checked ? "checked" : "unchecked"));
        }

        @Override
        public boolean isChecked() {
            return checked;
        }
    }

    private static class WindowsTextField implements TextField {
        private String text = "";

        @Override
        public void render() {
            System.out.println("Rendering Windows text field");
        }

        @Override
        public void setText(String text) {
            this.text = text;
            System.out.println("Windows text field set to: " + text);
        }

        @Override
        public String getText() {
            return text;
        }
    }
}
