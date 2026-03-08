package com.example.behavioral.chainofresponsibility;

public class LevelOneSupport extends Handler {
    @Override
    public void handleRequest(SupportTicket ticket) {
        if (ticket.getLevel() == 1) {
            System.out.println("Level 1 support handled the ticket.");
        } else if (next != null) {
            next.handleRequest(ticket);
        }
    }
}
