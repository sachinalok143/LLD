package org.phone.pe.impl.offers;

import org.phone.pe.Models.Offer;
import org.phone.pe.Models.Transaction;

public class CashBackOffer extends Offer {

    private final CashBackTypeEnum cashBackType; // flat , percentage
    private final int cashBack;

    public CashBackOffer(CashBackTypeEnum cashBackType, int cashBack) {
        this.cashBackType = cashBackType;
        this.cashBack = cashBack;
    }


    private int calculateCashBack(int amount) {

        // calculate cashback on the basis of type
        return 20;//(int) (Math.random()%10);
    }

    @Override
    public boolean isApplicable(Transaction transaction) {
        return true;//Math.random()%2 ==0?true:false ;
    }

    @Override
    public void applyOffer(Transaction transaction) {
        if (isApplicable(transaction)) {
            transaction.getFrom().getWallerController().addAmountToWallet(calculateCashBack(transaction.getAmount()));
            System.out.println("Offer Applied : " + transaction.getFrom().getUsername() + " of amount : " + calculateCashBack(transaction.getAmount()));
        }
    }
}
