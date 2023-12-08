package org.phone.pe.controllers;

import org.phone.pe.FilterStrategy;
import org.phone.pe.Models.Transaction;
import org.phone.pe.SortingStrategy;

import java.util.ArrayList;
import java.util.List;

public class TransactionController {

    List<Transaction> transactions = new ArrayList<>();

    public void doTransaction(Transaction transaction) {
        transactions.add(transaction);
        transaction.getFrom().getWallerController().subAmountToWallet(transaction.getAmount());
        transaction.getSentTo().getWallerController().addAmountToWallet(transaction.getAmount());
        String stringBuilder = "Amount " + transaction.getAmount() +
                " has been transferred from user " +
                transaction.getFrom().getUsername() +
                "to " +
                transaction.getSentTo().getUsername();
        System.out.println(stringBuilder);
    }

    public List<Transaction> filterTransactions(FilterStrategy filterStrategy) {
        return filterStrategy.filter(transactions);
    }

    public List<Transaction> sortTransactions(SortingStrategy sortingStrategy) {
        return sortingStrategy.sort(transactions);
    }


}
