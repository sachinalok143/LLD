package org.phone.pe.impl.sorter;

import org.phone.pe.Models.Transaction;
import org.phone.pe.SortingStrategy;

import java.util.List;

public class SortByAmount extends SortingStrategy {
    @Override
    public List<Transaction> sort(List<Transaction> transactions) {
//        Collections.sort(transactions)
        // we can write sorting logic here
        return transactions;
    }
}
