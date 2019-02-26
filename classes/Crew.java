package classes;
import java.util.GregorianCalendar;
import java.util.ArrayList;
/**
* Crew.class
* @author: Antonio Adamuz
* @version: 0.0.1
*/
public class Crew extends Employee{
	private int Amount;
	private double Salary;

	public Crew(String DNI,String Name, String Subname,
	 GregorianCalendar Birthdate,
	 String Nationaly,ArrayList<String> Lenguages, int Amount, double Salary)throws Exception{
		super(DNI,Name,Subname,Birthdate,Nationaly,Lenguages);
		this.Amount=Amount;
		this.Salary=Salary;
	}

	public double calculateSalary(){
		return this.Salary;
	}
}
