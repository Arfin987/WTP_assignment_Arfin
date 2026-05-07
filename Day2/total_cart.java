package day_2_Assignment;
import java.util.Scanner;
public class total_cart {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		double price;
		double tot=0;
		while(true) {
			price=sc.nextDouble();
			if(price==0)
				break;
			tot+=price;
		}
		System.out.println("Total price"+tot);
		
		

	}

}
