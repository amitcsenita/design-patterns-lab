package com.example.behavioral.command;

public class ThermostatCommand implements Command {
    @Override
    public void execute() {
        System.out.println("Thermostat set");
    }
}
