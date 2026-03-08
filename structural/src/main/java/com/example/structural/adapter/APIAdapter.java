package com.example.structural.adapter;

public class APIAdapter implements ModernAPI {
    private LegacyAPI legacy;

    public APIAdapter(LegacyAPI legacy) {
        this.legacy = legacy;
    }

    @Override
    public void newMethod() {
        legacy.oldMethod();
    }
}
