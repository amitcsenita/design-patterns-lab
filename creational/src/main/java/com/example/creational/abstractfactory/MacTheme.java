package com.example.creational.abstractfactory;

/**
 * macOS-specific UI theme implementation.
 * Creates macOS-styled components with consistent look and feel.
 */
public class MacTheme implements UITheme {
    @Override
    public Button createButton() {
        return new MacButton();
    }

    @Override
    public Window createWindow() {
        return new MacWindow();
    }

    @Override
    public Checkbox createCheckbox() {
        return new MacCheckbox();
    }

    @Override
    public TextField createTextField() {
        return new MacTextField();
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

    private static class MacCheckbox implements Checkbox {
        private boolean checked = false;

        @Override
        public void render() {
            System.out.println("Rendering Mac checkbox");
        }

        @Override
        public void check() {
            checked = !checked;
            System.out.println("Mac checkbox " + (checked ? "checked" : "unchecked"));
        }

        @Override
        public boolean isChecked() {
            return checked;
        }
    }

    private static class MacTextField implements TextField {
        private String text = "";

        @Override
        public void render() {
            System.out.println("Rendering Mac text field");
        }

        @Override
        public void setText(String text) {
            this.text = text;
            System.out.println("Mac text field set to: " + text);
        }

        @Override
        public String getText() {
            return text;
        }
    }
}
