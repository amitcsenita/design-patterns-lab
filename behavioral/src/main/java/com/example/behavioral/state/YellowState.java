package com.example.behavioral.state;

public class YellowState implements State {
    @Override
    public void handle(TrafficLight trafficLight) {
        System.out.println("Yellow light - Caution!");
        trafficLight.setState(new RedState());
    }
}
