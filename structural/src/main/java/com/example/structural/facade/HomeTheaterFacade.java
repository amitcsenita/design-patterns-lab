package com.example.structural.facade;

public class HomeTheaterFacade {
    private Projector projector;
    private SoundSystem soundSystem;

    public HomeTheaterFacade() {
        this.projector = new Projector();
        this.soundSystem = new SoundSystem();
    }

    public void startMovie() {
        projector.on();
        soundSystem.on();
    }

    public void endMovie() {
        projector.off();
        soundSystem.off();
    }
}
