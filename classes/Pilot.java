package classes;
import java.util.GregorianCalendar;
import java.util.ArrayList;
/**
* Pilot.class
* Descripcion: Clase Pilot que hereda los metodos de la clase Employee y tiene
* metodos propios y utiliza el constructor abstracto de la clase padre.
* @author: Antonio Adamuz
* @version: 0.0.1
*/
public class Pilot extends Employee{
	private final static double plus=5000;
	private final static double Salary=100000;
	private int assignedFlight;
	private int Flytime;


	public Pilot(String DNI,String Name, String Subname,
	GregorianCalendar Birthdate, String Nationaly,
	ArrayList<String> Lenguages,ArrayList<String> LenguagesCompany,
	int flytime,int assignedFlight)throws Exception{
		super(DNI,Name,Subname,Birthdate,Nationaly,Lenguages,LenguagesCompany);
		setFlytime(flytime);
		setAssignedFlight(assignedFlight);
	}
 public double calculateSalary(){
	 double total;
	 total=this.assignedFlight * this.plus;
	 total=this.Salary + total;
	 return total;
 }

 //setter
 public void setAssignedFlight(int assignedFlight){
	 this.assignedFlight=assignedFlight;
 }

 public void setFlytime(int flytime){
	 this.Flytime=flytime;
 }

 //getter
 public double getAssignedFlight(){
	 return this.assignedFlight;
 }

 public double getFlytime(){
	 return this.Flytime;
 }

 @Override
	 public String toString(){
		 return super.toString()+"\n Total Salary: "+calculateSalary()+"\n Assigned Flight: "
		 +this.assignedFlight+"\n Fly time: "+this.Flytime+" min";
	 }

}
