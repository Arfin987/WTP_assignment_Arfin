package day_10_Assignment;


import java.util.*;
 
public class HospitalSystem implements Comparable<HospitalSystem> {
int id;
String name;
 
public HospitalSystem(int id, String name)
{
	this.id=id;
	this.name=name;
}
@Override
public int compareTo(HospitalSystem p)
{
	return this.id - p.id;
}
@Override
public String toString()
{
	return id + " - " + name;
}
 
public static void main(String[] args)
	{
	TreeSet<HospitalSystem> patients=new TreeSet<>();
	
	patients.add(new HospitalSystem(101, "Vinay"));
	patients.add(new HospitalSystem(102, "Sonali"));
	patients.add(new HospitalSystem(103, "Radhya"));
	patients.add(new HospitalSystem(101, "Vinay"));
	
	System.out.println("Unique Registered Patients");
	for(HospitalSystem p: patients)
	{
		System.out.println(p);
	}
 
	}
 
}
 
 