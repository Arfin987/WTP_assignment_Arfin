package day_5_Assignment;


class Payment{
	public final void processPayment(double amount) {
		System.out.println(" Process transactions..");
		System.out.println("processed amount: "+amount);
	}
}

class Upi extends Payment{
	public void show() {
		System.out.println("transaction by UPI");
	}
}

public class Final_usecase2 {

	public static void main(String[] args) {
		Upi t1=new Upi();
		t1.show();
		t1.processPayment(5000.98);

	}

}
