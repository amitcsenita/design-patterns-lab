package com.example.behavioral.command;

public class Demo {
    public static void main(String[] args) {
        RemoteControl remote = new RemoteControl();
        remote.setCommand(new LightOnCommand());
        remote.pressButton();
    }
}
