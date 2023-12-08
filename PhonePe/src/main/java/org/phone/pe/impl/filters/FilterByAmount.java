package org.phone.pe.impl.filters;

import org.phone.pe.FilterStrategy;
import org.phone.pe.Models.Transaction;

import java.util.List;
import java.util.stream.Collectors;

public class FilterByAmount extends FilterStrategy {
    private int amount;

    private FilterByAmount() {
    }

    public FilterByAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public List<Transaction> filter(List<Transaction> transactions) {
        return transactions.stream()
                .filter(transaction -> transaction.getAmount() >= amount)
                .collect(Collectors.toList());
    }
}
