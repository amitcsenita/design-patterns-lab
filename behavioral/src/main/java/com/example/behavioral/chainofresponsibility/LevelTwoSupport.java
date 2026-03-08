package com.example.behavioral.chainofresponsibility;

public class LevelTwoSupport extends Handler {
    @Override
    public void handleRequest(SupportTicket ticket) {
        if (ticket.getLevel() == 2) {
            System.out.println("Level 2 support handled the ticket.");
        } else if (next != null) {
            next.handleRequest(ticket);
        }
    }
}
