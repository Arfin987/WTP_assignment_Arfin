package day_2_Assignment;
import java.util.*;

public class password_retyr {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		String pwd="admin@123";
		int max_attempt=3;
		int attempt=0;
		System.out.println("enter your password");
		while(attempt<max_attempt) {
			String pass=sc.nextLine();
			if(pwd.equals(pass)) {
				System.out.println("Welcome! User");
				break;
			}else {
				attempt++;
				System.out.println("try again! Your attempt left "+(max_attempt-attempt));
				
			}
		}
	}

}
