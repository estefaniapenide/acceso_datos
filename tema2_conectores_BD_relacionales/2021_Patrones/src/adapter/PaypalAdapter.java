package adapter;

/*
PATRÓN ESTRUCTURAL


*/

public class PaypalAdapter {
    private Paypal paypal;
 
    public PaypalAdapter (Paypal paypal) {
        this.paypal = paypal;
    }
     
    public void pay(int amount) {
        this.paypal.payAmount(amount);
    }
}
