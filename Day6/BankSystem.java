package day_6_Assignment;

abstract class Bank { 
abstract double getInterestRate(); 
} 
class SBI extends Bank { 

double getInterestRate() { 
return 3.5; 
} 
} 
class Punjab extends Bank { 

double getInterestRate() { 
return 4.2; 
} 
} 
class HDFC extends Bank { 

double getInterestRate() { 
return 5.1; 
} 
} 
 
public class BankSystem { 
    public static void main(String[] args) { 
        Bank b1 = new SBI(); 
        Bank b2 = new Punjab(); 
        Bank b3 = new HDFC(); 
 
        System.out.println("SBI: " + b1.getInterestRate() + "%"); 
        System.out.println("Punjab: " + b2.getInterestRate() + "%"); 
        System.out.println("HDFC: " + b3.getInterestRate() + "%"); 
    } 
}
