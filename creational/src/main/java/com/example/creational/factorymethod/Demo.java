package com.example.creational.factorymethod;

public class Demo {
    public static void main(String[] args) {
        Notification email = NotificationFactory.createNotification("email");
        email.send("Hello via email");
        Notification sms = NotificationFactory.createNotification("sms");
        sms.send("Hello via SMS");
    }
}
