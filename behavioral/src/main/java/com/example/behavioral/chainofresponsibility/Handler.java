package com.example.behavioral.chainofresponsibility;

public abstract class Handler {
    protected Handler next;

    public void setNext(Handler next) {
        this.next = next;
    }

    public abstract void handleRequest(SupportTicket ticket);
}
