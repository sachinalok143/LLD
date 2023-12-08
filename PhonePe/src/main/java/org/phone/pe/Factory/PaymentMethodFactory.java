package org.phone.pe.Factory;

import org.phone.pe.Models.PaymentMethodType;
import org.phone.pe.PaymentMethod;
import org.phone.pe.impl.paymethods.CCPaymentMethod;
import org.phone.pe.impl.paymethods.DCPaymentMethod;
import org.phone.pe.impl.paymethods.UpiPaymentMethod;

import java.util.HashMap;
import java.util.Map;

public class PaymentMethodFactory {
    private static final Map<PaymentMethodType, PaymentMethod> paymentMethodTypePaymentMethodMap = new HashMap<>();

    static {
        paymentMethodTypePaymentMethodMap.put(PaymentMethodType.DC, new DCPaymentMethod());
        paymentMethodTypePaymentMethodMap.put(PaymentMethodType.CC, new CCPaymentMethod());
        paymentMethodTypePaymentMethodMap.put(PaymentMethodType.UPI, new UpiPaymentMethod());
    }

    public static PaymentMethod getPaymentMethod(PaymentMethodType paymentMethodType) {
        return paymentMethodTypePaymentMethodMap.get(paymentMethodType);
    }
}
