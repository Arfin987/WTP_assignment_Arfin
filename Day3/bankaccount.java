package day_3_Assignment;

public class bankaccount {
	
	private double balance;
	public double getbalance() {
		return balance;
	}
	
	public void deposit(double amount) {
		if(amount>0) {
		balance+=amount;
		System.out.println("Deposited: "+amount);
		}
	}
	
	public void withdraw(double amount) {
		if(amount>0 && amount<=balance) {
		balance-=amount;
		System.out.println("Withdraw: "+amount);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		bankaccount acc=new bankaccount();
		
		acc.deposit(1000);
		acc.withdraw(500);
		System.out.println("Reamaining balance: "+acc.getbalance());

	}

}
