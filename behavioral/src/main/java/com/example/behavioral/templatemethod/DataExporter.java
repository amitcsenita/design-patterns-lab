package com.example.behavioral.templatemethod;

public abstract class DataExporter {
    public final void export() {
        openFile();
        writeData();
        closeFile();
    }

    protected abstract void openFile();

    protected abstract void writeData();

    protected abstract void closeFile();
}
