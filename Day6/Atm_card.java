package day_6_Assignment;
import java.util.Scanner;

public class Atm_card {

	    public void insertCard() {
	        System.out.println("Card inserted.");
	    }

	    public void enterPin(int pin) {
	    	
	    	int correctPin = 908890; 
	        if (pin != correctPin) {
	            throw new RuntimeException("Incorrect PIN entered!");
	        } else {
	            System.out.println("PIN accepted. Access granted.");
	        }
	    }

	    public static void main(String[] args) {
	        Atm_card atm = new Atm_card();
	        Scanner sc=new Scanner(System.in);
	        atm.insertCard();
	        System.out.println("Enter your pin");
	    	int pin =sc.nextInt();

	        try {
	            atm.enterPin(pin);
	        } catch (RuntimeException e) {
	            System.out.println("Exception caught: " + e.getMessage());
	        } finally {
	            System.out.println("Transaction log! Thank you....");
	            sc.close();
	        }
	        
	    }
	


}
