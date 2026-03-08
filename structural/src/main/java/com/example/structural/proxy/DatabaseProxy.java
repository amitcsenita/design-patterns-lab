package com.example.structural.proxy;

public class DatabaseProxy implements DatabaseConnection {
    private RealDatabaseConnection realConnection;

    @Override
    public void connect() {
        if (realConnection == null) {
            realConnection = new RealDatabaseConnection();
        }
        realConnection.connect();
    }

    private static class RealDatabaseConnection implements DatabaseConnection {
        @Override
        public void connect() {
            System.out.println("Connecting to database");
        }
    }
}
