interface PaymentProcessor {
    void processPayment(double amount);
}

class RazorpayGateway {
    public void makePayment(double amount) {
        System.out.println("Paid via Razorpay: Rs. " + amount);
    }
}

class StripeGateway {
    public void stripeCharge(double amount) {
        System.out.println("Paid via Stripe: Rs. " + amount);
    }
}

class RazorpayAdapter implements PaymentProcessor {
    private RazorpayGateway razorpay = new RazorpayGateway();
    public void processPayment(double amount) {
        razorpay.makePayment(amount);
    }
}

class StripeAdapter implements PaymentProcessor {
    private StripeGateway stripe = new StripeGateway();
    public void processPayment(double amount) {
        stripe.stripeCharge(amount);
    }
}

class AdapterTest {
    public static void main(String[] args) {
        PaymentProcessor razor = new RazorpayAdapter();
        PaymentProcessor stripe = new StripeAdapter();

        razor.processPayment(1000);
        stripe.processPayment(2000);
    }
}
