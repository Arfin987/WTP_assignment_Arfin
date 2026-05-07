package day_3_Assignment;

class hospital{
	private String name ;
	private int id;
	private int age;
	
	//public hospital(String name,int id,int age)
	
	public String getname() {
		return name;
	}
	
	public int getage() {
		return age;
	}
	
	public int getid() {
		return id;
	}
	
	public void setname(String name) {
		this.name=name;
	}
	public void setage(int age) {
		this.age=age;
	}
	public void setname(int id) {
		this.id=id;
	}
}
public class patient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		hospital pat1=new hospital();
		pat1.setname("John");
		pat1.setage(45);
		pat1.setname(99);
		pat1.getname();
		pat1.getage();
		pat1.getid();

	}

}
