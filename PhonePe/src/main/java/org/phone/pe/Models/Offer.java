package org.phone.pe.Models;

public abstract class Offer {
    abstract public boolean isApplicable(Transaction transaction);

    abstract public void applyOffer(Transaction transaction);

}
