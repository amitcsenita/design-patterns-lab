package com.example.behavioral.memento;

public class TextEditor {
    private String text = "";

    public void write(String newText) {
        text += newText;
    }

    public String getText() {
        return text;
    }

    public Memento save() {
        return new Memento(text);
    }

    public void restore(Memento memento) {
        text = memento.getState();
    }
}
