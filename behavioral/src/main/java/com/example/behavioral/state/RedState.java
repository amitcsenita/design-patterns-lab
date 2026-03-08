package com.example.behavioral.state;

public class RedState implements State {
    @Override
    public void handle(TrafficLight trafficLight) {
        System.out.println("Red light - Stop!");
        trafficLight.setState(new GreenState());
    }
}
