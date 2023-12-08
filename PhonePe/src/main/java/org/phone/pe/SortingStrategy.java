package org.phone.pe;

import org.phone.pe.Models.Transaction;

import java.util.List;

abstract public class SortingStrategy {
    abstract public List<Transaction> sort(List<Transaction> transactions);
}