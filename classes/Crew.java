package classes;
import java.util.GregorianCalendar;
import java.util.ArrayList;
/**
* Crew.class
* @author: Antonio Adamuz
* @version: 0.0.1
*/
public class Crew extends Employee{
	private final static double Salary=40000;
	private final static double plus=1000;
	private int assignedFlight;

	public Crew(String DNI,String Name, String Subname,
	 GregorianCalendar Birthdate,
	 String Nationaly,ArrayList<String> Lenguages)throws Exception{
		super(DNI,Name,Subname,Birthdate,Nationaly,Lenguages);
	}

	public double calculateSalary(){
		double total;
		total = this.plus * this.assignedFlight;
		total=total + this.Salary;
		return total;
	}

	@Override
 	 public String toString(){
 		 return super.toString()+" Total Salary: "+calculateSalary()+"\n Assigned Flight: "
 		 +this.assignedFlight;
 	 }
}
