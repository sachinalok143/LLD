package org.phone.pe.Models;

import org.phone.pe.User;

public class Transaction {
    private final User from;
    private final User sentTo;
    private final int amount;
    private Currency currency = Currency.INR;

    public Transaction(User from, User sentTo, int amount) {
        this.from = from;
        this.sentTo = sentTo;
        this.amount = amount;
    }

    public User getSentTo() {
        return sentTo;
    }

    public User getFrom() {
        return from;
    }

    public int getAmount() {
        return amount;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }
}
