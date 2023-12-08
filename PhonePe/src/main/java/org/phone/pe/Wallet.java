package org.phone.pe;

import org.phone.pe.Models.Currency;
import org.phone.pe.Models.Offer;
import org.phone.pe.Models.Transaction;
import org.phone.pe.controllers.TransactionController;

import java.util.ArrayList;
import java.util.List;

public class Wallet {
    TransactionController transactionController = new TransactionController();
    List<Offer> appliedOffers = new ArrayList<>();
    private int currentBalance;
    private Currency currency;

    public void applyOffer(Offer offer) {
        appliedOffers.add(offer);
    }

    public void addBalance(int amount) {
        currentBalance = currentBalance + amount;
    }

    public int getCurrentBalance() {
        return currentBalance;
    }

    public void sendMoney(Transaction transaction) {
        transactionController.doTransaction(transaction);
//        Transaction newTrxn=new Transaction(from,to,amount);
    }

    public List<Transaction> filterTransactions(FilterStrategy filterStrategy) {
        return transactionController.filterTransactions(filterStrategy);
    }

    public List<Transaction> sortTransactions(SortingStrategy sortingStrategy) {
        return transactionController.sortTransactions(sortingStrategy);
    }


}
