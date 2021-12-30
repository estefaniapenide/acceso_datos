package adapter;

public class Paypal {
    
    public Paypal() {}
 
    public void payAmount(int amount) {
        System.out.println("Paying via PayPal: " + amount);
    }
}