package org.phone.pe;

import org.phone.pe.controllers.WallerController;

abstract public class PaymentMethod {
    abstract public void transferToWallet(int amount, WallerController wallerController);
}
