package day_2_Assignment;

public class sal_inc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double sal[]= {50000,20000,30000,25000,40000};
		for(int i=0;i<sal.length;i++) {
			sal[i]=sal[i]+(sal[i]*0.1);
		}
		for(int i=0;i<sal.length;i++) {
		    System.out.println("updated salary emp"+(i+1)+":"+sal[i]);
		}
		

	}

}
