package day_5_Assignment;
interface payment{
	void pay(double amount);
	default void paid(double amount) {
		System.out.println("Paid "+amount);
	}
	
}

class Cash implements payment{
	public void pay(double amount) {
		paid(amount);
		System.out.println("paid by cash");
	}
}

class upi implements payment{
	public void pay(double amount) {
		paid(amount);
		System.out.println("paid by upi");
	}
	
	
	
}





public class paymentSystem {

	public static void main(String[] args) {
		payment p1=new Cash();
		payment p2=new upi();
		
		p1.pay(1000);
		p2.pay(500);
		

	}

}
