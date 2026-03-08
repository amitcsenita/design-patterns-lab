package com.example.behavioral.templatemethod;

public class Demo {
    public static void main(String[] args) {
        DataExporter exporter = new CSVExporter();
        exporter.export();
    }
}
