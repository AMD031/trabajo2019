package classes;
/**
* Pilot.class
* @author: Antonio Adamuz
* @version: 0.0.1
*/
public class Crew extends Employee{
	private int Amount;
	private double Salary;
	//String DNI, int NEmployee, String Name, String Subname,
 //GregorianCalendar Birthdate, String Nationaly,int quantity,String[] Lenguages
	public Crew(int amount, int flytime, double salary){
		this.Amount=amount;
		this.Salary=salary;
	}
}
