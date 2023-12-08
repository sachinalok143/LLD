package org.phone.pe.controllers;

import org.phone.pe.Factory.PaymentMethodFactory;
import org.phone.pe.FilterStrategy;
import org.phone.pe.Models.PaymentMethodType;
import org.phone.pe.Models.Transaction;
import org.phone.pe.PaymentMethod;
import org.phone.pe.SortingStrategy;
import org.phone.pe.Wallet;

import java.util.List;

public class WallerController {
    private final Wallet wallet = new Wallet();


    public void topUpWallet(int amount, PaymentMethodType paymentMethodType) {
        PaymentMethod paymentMethod = PaymentMethodFactory.getPaymentMethod(paymentMethodType);
        paymentMethod.transferToWallet(amount, this);
    }

    public void addAmountToWallet(int amount) {
        wallet.addBalance(amount);
    }

    public void subAmountToWallet(int amount) {
        wallet.addBalance(-1 * amount);
    }

    public void sendMoney(Transaction transaction) {
        wallet.sendMoney(transaction);
    }


    public int fetchBalance() {
        return wallet.getCurrentBalance();
    }

    public List<Transaction> filterTransactions(FilterStrategy filterStrategy) {
        return wallet.filterTransactions(filterStrategy);
    }

    public List<Transaction> sortTransactions(SortingStrategy sortingStrategy) {
        return wallet.sortTransactions(sortingStrategy);
    }

}
