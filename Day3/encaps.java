package day_3_Assignment;

public class encaps {
	
	private double salary;
	public double getsalary() {
		return salary;
	}
	public void setsalary(double salary) {
		this.salary=salary;
	}

	

public static void main(String[] args) {
	// TODO Auto-generated method stub
	
	encaps obj=new encaps();
	obj.setsalary(500000);
	System.out.println(obj.getsalary());

}

}
