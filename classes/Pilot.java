package classes;
/**
* Pilot.class
* @author: Antonio Adamuz
* @version: 0.0.1
*/
public class Pilot extends Employee{
	private final static int plus=1000;

	private int Amount;
	private int Flytime;
	private double Salary;
	private int amountflight;
 //String DNI, int NEmployee, String Name, String Subname,
//GregorianCalendar Birthdate, String Nationaly,int quantity,String[] Lenguages
	public Pilot(String DNI, int NEmployee, String Name, String Subname,
	GregorianCalendar Birthdate, String Nationaly,int quantity,String[] Lenguages,
	int amount, int flytime, double salary){
		super(DNI,NEmployee,Name,Subname,Birthdate,Nationaly,quantity,Lenguages);
		this.Amount=amount;
		this.Flytime=flytime;
		this.Salary=salary;
	}
 public double calculateSalary(){
	 return 1;
 }


}
