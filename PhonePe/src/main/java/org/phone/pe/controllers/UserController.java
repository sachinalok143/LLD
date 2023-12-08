package org.phone.pe.controllers;

import org.phone.pe.Models.Transaction;
import org.phone.pe.User;

import java.util.HashMap;
import java.util.Map;

public class UserController {
    private final Map<String, User> userMap = new HashMap<>();

    public void registerUser(String username) {
        if (!userMap.containsKey(username)) {
            userMap.put(username, new User(username, new WallerController()));
        } else {
            System.out.println("user with the username already exist: " + username);
        }
    }

    public void registerUser(User user) {
        String username = user.getUsername();
        if (!userMap.containsKey(username)) {
            userMap.put(username, user);
        } else {
            System.out.println("user with the username already exist: " + username);
        }
    }

    public User getUser(String username) {
        if (userMap.containsKey(username)) {
            return userMap.get(username);
        } else {
            System.out.println("user with the username does not exist: " + username);
        }
        return null;
    }

    public void sendMoney(int amount, String from, String to, OfferController offerController) {
        User u1 = userMap.get(from);
        User u2 = userMap.get(to);
        if (u1 != null && u2 != null && amount > 0) {
            Transaction newTrxn = new Transaction(u1, u2, amount);
            u1.sendMoney(newTrxn);
            offerController.applyOffers(newTrxn);
        }
    }

}
