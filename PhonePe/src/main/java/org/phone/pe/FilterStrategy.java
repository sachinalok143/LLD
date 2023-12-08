package org.phone.pe;

import org.phone.pe.Models.Transaction;

import java.util.List;

abstract public class FilterStrategy {
    abstract public List<Transaction> filter(List<Transaction> transactions);
}
