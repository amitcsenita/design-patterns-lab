package com.example.behavioral.chainofresponsibility;

public class LevelThreeSupport extends Handler {
    @Override
    public void handleRequest(SupportTicket ticket) {
        if (ticket.getLevel() == 3) {
            System.out.println("Level 3 support handled the ticket.");
        } else {
            System.out.println("Ticket cannot be handled.");
        }
    }
}
