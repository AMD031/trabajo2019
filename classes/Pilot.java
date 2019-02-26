package classes;
import java.util.GregorianCalendar;
import java.util.ArrayList;
/**
* Pilot.class
* @author: Antonio Adamuz
* @version: 0.0.1
*/
public class Pilot extends Employee{
	private final static int plus=5000;
	private final static double Salary=100000;
	private int Amount;
	private int Flytime;

	private int amountflight;
 //String DNI, int NEmployee, String Name, String Subname,
//GregorianCalendar Birthdate, String Nationaly,int quantity,String[] Lenguages
	public Pilot(String DNI,String Name, String Subname,
	GregorianCalendar Birthdate, String Nationaly,int quantity,
	ArrayList<String> Lenguages,
	int amount, int flytime)throws Exception{
		super(DNI,Name,Subname,Birthdate,Nationaly,Lenguages);
		this.Amount=amount;
		this.Flytime=flytime;
	}
 public double calculateSalary(amountflight, plus){
	 this.Salary= this.Salary + this.amountflight * this.plus;
 }


}
