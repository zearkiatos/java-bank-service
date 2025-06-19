package org.example;

/**
 * Structural Design Pattern: Adapter
 * Adapter class that allows the PayPal class to be used as a PaymentGateway.
 * This class implements the PaymentGateway interface and delegates the payment
 */
public class PayPalAdapter implements PaymentGateway {
    private PayPal payPal;

    public PayPalAdapter(PayPal payPal) {
        this.payPal = payPal;
    }

    @Override
    public void pay(double amount) {
        payPal.sendPayment(amount);
    }
    
}
