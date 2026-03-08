package com.example.behavioral.chainofresponsibility;

public class Demo {
    public static void main(String[] args) {
        Handler level1 = new LevelOneSupport();
        Handler level2 = new LevelTwoSupport();
        Handler level3 = new LevelThreeSupport();

        level1.setNext(level2);
        level2.setNext(level3);

        SupportTicket ticket1 = new SupportTicket(1);
        SupportTicket ticket2 = new SupportTicket(2);
        SupportTicket ticket3 = new SupportTicket(3);

        level1.handleRequest(ticket1);
        level1.handleRequest(ticket2);
        level1.handleRequest(ticket3);
    }
}
