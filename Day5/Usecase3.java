package day_5_Assignment;

 final class security{
	public String encrypt(String data) {
		return "ENCRYPTED_"+data;
	}
}

public class Usecase3 {

	public static void main(String[] args) {
		security scr=new security();
		String data="AccountNumber";
		String str=scr.encrypt(data);
		System.out.println("Original: "+data);
		System.out.println("Secure : "+str);
	}

}
