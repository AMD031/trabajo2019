package classes;
import java.util.GregorianCalendar;
import java.util.ArrayList;
/**
* Pilot.class
* @author: Antonio Adamuz
* @version: 0.0.1
*/
public class Pilot extends Employee{
	private final static double plus=5000;
	private final static double Salary=100000;
	private int assignedFlight;
	private int Flytime;

	private int amountflight;
 //String DNI, int NEmployee, String Name, String Subname,
//GregorianCalendar Birthdate, String Nationaly,int quantity,String[] Lenguages
	public Pilot(String DNI,String Name, String Subname,
	GregorianCalendar Birthdate, String Nationaly,
	ArrayList<String> Lenguages, int flytime)throws Exception{
		super(DNI,Name,Subname,Birthdate,Nationaly,Lenguages);
		this.Flytime=flytime;
	}
 public double calculateSalary(){
	 double total;
	 total=this.assignedFlight * this.plus;
	 total=this.Salary + total;
	 return total;
 }

 @Override
	 public String toString(){
		 return super.toString()+" Total Salary: "+calculateSalary()+"\n Assigned Flight: "
		 +this.assignedFlight+"\n Fly time: "+this.Flytime;
	 }

}
