package com.example.behavioral.memento;

public class Demo {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor();
        History history = new History();

        editor.write("Hello ");
        history.push(editor.save());

        editor.write("world!");
        System.out.println("Current text: " + editor.getText());

        editor.restore(history.pop());
        System.out.println("After undo: " + editor.getText());
    }
}
