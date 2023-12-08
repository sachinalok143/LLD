package org.phone.pe.controllers;

import org.phone.pe.Models.Offer;
import org.phone.pe.Models.Transaction;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class OfferController {
    private final List<Offer> availableOffers = new ArrayList<>();

    public void addOffer(Offer offer) {
        availableOffers.add(offer);
    }

    public List<Offer> getApplicableOffers(Transaction transaction) {
        return availableOffers.stream().filter(offer -> offer.isApplicable(transaction)).collect(Collectors.toList());
    }

    public void applyOffers(Transaction transaction) {
        getApplicableOffers(transaction).forEach(offer -> offer.applyOffer(transaction));
    }

}
