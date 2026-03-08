package com.example.behavioral.templatemethod;

public class CSVExporter extends DataExporter {
    @Override
    protected void openFile() {
        System.out.println("Opening CSV file");
    }

    @Override
    protected void writeData() {
        System.out.println("Writing CSV data");
    }

    @Override
    protected void closeFile() {
        System.out.println("Closing CSV file");
    }
}
