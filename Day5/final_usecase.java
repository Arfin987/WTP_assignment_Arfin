package day_5_Assignment;

class BankAccount{
	private final int accNo;
	private double balance;
	
  public BankAccount(int accNo, double balance) {
	        this.accNo = accNo;
	        this.balance =balance;
	    }
  
  public void deposit(double amount) {
	  balance+=amount;
	  System.out.println("Deposit: "+amount);
  }
  
  public void displayAccount() {
	  System.out.println("Account number: "+accNo);
	  System.out.println("Balance: "+balance);
  }
}

public class final_usecase {

	public static void main(String[] args) {
	  BankAccount acc=new BankAccount(893939,1000.95);
	  acc.displayAccount();
	  acc.deposit(500);
	  acc.displayAccount();
	  

	}

}
