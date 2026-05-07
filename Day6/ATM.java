package day_6_Assignment;

interface BankOperation { 
    void withdraw(double amount); 
} 
 
public class ATM implements BankOperation { 
    private double balance = 5000; 
 
    public void withdraw(double amount) { 
        try { 
            if (amount > balance) { 
                throw new RuntimeException("Insufficient balance"); 
            } 
            balance -= amount; 
            System.out.println("Withdrawal successful. Remaining balance: " + balance); 
        } catch (RuntimeException e) { 
            System.out.println("Exception caught: " + e.getMessage()); 
        } finally { 
            System.out.println("Transaction log."); 
        } 
    } 
 
    public static void main(String[] args) { 
        ATM atm = new ATM(); 
        atm.withdraw(6000); 
        atm.withdraw(2000); 
    } 
}