package org.phone.pe;

import org.phone.pe.Models.Transaction;
import org.phone.pe.controllers.WallerController;

public class User {
    private String username;
    private WallerController wallerController = new WallerController();

    public User(String username, WallerController wallerController) {
        this.username = username;
        this.wallerController = wallerController;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public WallerController getWallerController() {
        return wallerController;
    }


    public void sendMoney(Transaction transaction) {
        wallerController.sendMoney(transaction);
    }
//    String userType''
}
