package April_batch;

public class calculate_tot_sal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double basic_sal=5000;
		System.out.println("Basic salary: "+basic_sal);
		double bonus=500;
		double tot_sal=basic_sal+bonus;
		double tax=(10*tot_sal)/100;
		System.out.println("tax: "+tax);
		double net_salary=(tot_sal-tax);
		System.out.println("net salary: "+net_salary);

	}

}
