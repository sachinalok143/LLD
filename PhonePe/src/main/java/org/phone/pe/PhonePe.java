package org.phone.pe;

import org.phone.pe.Models.Transaction;
import org.phone.pe.controllers.OfferController;
import org.phone.pe.controllers.UserController;
import org.phone.pe.controllers.WallerController;
import org.phone.pe.impl.filters.FilterByAmount;
import org.phone.pe.impl.offers.CashBackOffer;

import java.util.List;

import static org.phone.pe.Models.PaymentMethodType.*;
import static org.phone.pe.impl.offers.CashBackTypeEnum.FLAT;

public class PhonePe {


    public static void main(String[] args) {
        OfferController offerController = new OfferController();
        offerController.addOffer(new CashBackOffer(FLAT, 100));
        offerController.addOffer(new CashBackOffer(FLAT, 10));
        UserController userController = new UserController();
        userController.registerUser("Sachin");
        userController.registerUser("Amit");
        userController.registerUser("Alok");


        User sachin = userController.getUser("Sachin");
        WallerController wallerController = sachin.getWallerController();
        wallerController.topUpWallet(1000, UPI);
        wallerController.topUpWallet(2000, DC);
        wallerController.topUpWallet(3000, CC);
        System.out.println("current balance:" + sachin.getWallerController().fetchBalance());
        userController.sendMoney(100, sachin.getUsername(), "Alok", offerController);
        userController.sendMoney(1000, sachin.getUsername(), "Amit", offerController);
        userController.sendMoney(90, sachin.getUsername(), "Alok", offerController);
        userController.sendMoney(10, sachin.getUsername(), "Alok", offerController);
        System.out.println("current balance after transaction:" + sachin.getWallerController().fetchBalance());
        List<Transaction> transactions = wallerController.filterTransactions(new FilterByAmount(10));
        transactions.forEach(transaction -> {
            System.out.println(transaction.getFrom().getUsername() + "->" + transaction.getSentTo().getUsername() + ":" + transaction.getAmount());
            System.out.println(transaction.getFrom().getUsername() + ":" + transaction.getFrom().getWallerController().fetchBalance());
            System.out.println(transaction.getSentTo().getUsername() + ":" + transaction.getSentTo().getWallerController().fetchBalance());
        });


        //need to call sorting and


    }
}
