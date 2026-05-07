package day_2_Assignment;
import java.util.*;


public class print_even_number {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the number");
		int n =sc.nextInt();
		for(int i=2;i<=n;i++) {
			if(i%2==0) {
				System.out.print(i+" ");
			}
		}

	}

}
