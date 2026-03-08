package com.example.behavioral.command;

public class LightOnCommand implements Command {
    @Override
    public void execute() {
        System.out.println("Light is on");
    }
}
