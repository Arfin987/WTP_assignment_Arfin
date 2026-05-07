package day_2_Assignment;

public class grade_System {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int marks=40;
		if(marks>=90) {
			System.out.println("Grade: A");
		}else if(marks>=75 && marks<90) {
			System.out.println("Grade: A");
		}else if(marks>=60 && marks<75){
			System.out.println("Grade: B");
		}else if(marks>=45 && marks<60) {
			System.out.println("Grade: C");
		}else {
			System.out.println("Fail");
		}

	}

}
