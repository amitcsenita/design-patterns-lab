package com.example.behavioral.state;

public class GreenState implements State {
    @Override
    public void handle(TrafficLight trafficLight) {
        System.out.println("Green light - Go!");
        trafficLight.setState(new YellowState());
    }
}
