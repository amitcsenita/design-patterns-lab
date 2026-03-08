package com.example.behavioral.templatemethod;

public class JSONExporter extends DataExporter {
    @Override
    protected void openFile() {
        System.out.println("Opening JSON file");
    }

    @Override
    protected void writeData() {
        System.out.println("Writing JSON data");
    }

    @Override
    protected void closeFile() {
        System.out.println("Closing JSON file");
    }
}
