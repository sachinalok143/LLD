package org.phone.pe.impl.paymethods;

import org.phone.pe.PaymentMethod;
import org.phone.pe.controllers.WallerController;

public class DCPaymentMethod extends PaymentMethod {
    @Override
    public void transferToWallet(int amount, WallerController wallerController) {
        wallerController.addAmountToWallet(amount);
        System.out.println("wallet has been top up with amount:" + amount + ", current balance is:" + wallerController.fetchBalance() + " using DEBIT CARD.");
    }
}
