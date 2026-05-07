package day_3_Assignment;

class vehicle {
  private boolean engine;
  private int speed;
  private double fuelLevel;
  
  public vehicle(double fuelLevel) {
	  this.fuelLevel=fuelLevel;
	  this.engine=false;
	  this.speed=0;
  }
  
  public boolean engine() {
	  return engine;
  }
  
  public double fuelLevel() {
	  return fuelLevel;
  }
  
  public int speed() {
	  return speed;
  }
  
  public void start() {
	  if(fuelLevel>0) {
		  engine=true;
		  System.out.println("car started");
	  }else {
		 System.out.println("car not start");
	  }
  }
  
  
  public void stop() {
	  engine=false;
	  speed=0;
	  System.out.println("stopped");
  }
}

public class car{
	public static void main(String[] args) {
		vehicle car=new vehicle(20);
		car.engine();
		car.fuelLevel();
		car.speed();
		car.start();
		car.stop();
		
	}
}
