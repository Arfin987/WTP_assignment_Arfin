package day_2_Assignment;
import java.util.Scanner;
public class atm_menu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		 int choice;
	        double balance = 1000; 

	        do {
	            System.out.println("1. Check Balance");
	            System.out.println("2. Deposit");
	            System.out.println("3. Withdraw");
	            System.out.println("4. Exit");
	            System.out.print("Enter your choice: ");

	            choice = sc.nextInt();

	            switch(choice) {
	                case 1:
	                    System.out.println("Your Balance: " + balance);
	                    break;

	                case 2:
	                    System.out.print("Enter deposit amount: ");
	                    break;

	                case 3:
	                    System.out.print("Enter withdraw amount: ");
	                    break;
	                case 4:
	                    System.out.println("Thank you for using ATM.");
	                    break;

	                default:
	                    System.out.println("Invalid choice. Try again.");
	            }

	        } while(choice != 4);
		

	}

}
