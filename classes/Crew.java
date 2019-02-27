package classes;
import java.util.GregorianCalendar;
import java.util.ArrayList;
/**
* Crew.class
* Descripcion: Clase Crew que hereda los metodos de la clase Employee y tiene
* metodos propios y utiliza el constructor abstracto de la clase padre.
* @author: Antonio Adamuz
* @version: 0.0.1
*/
public class Crew extends Employee{
	private final static double Salary=40000;
	private final static double plus=1000;
	private int assignedFlight;

	public Crew(String DNI,String Name, String Subname,
	 GregorianCalendar Birthdate,
	 String Nationaly,ArrayList<String> Lenguages,ArrayList<String> LenguagesCompany, int assignedFlight)throws Exception{
		super(DNI,Name,Subname,Birthdate,Nationaly,Lenguages,LenguagesCompany);
		setAssignedFlight(assignedFlight);
	}

	public double calculateSalary(){
		double total;
		total = this.plus * this.assignedFlight;
		total=total + this.Salary;
		return total;
	}

	//Setters
	public void setAssignedFlight(int assignedFlight){
		this.assignedFlight=assignedFlight;
	}

	//getter
	public int getAssignedFlight(){
		return this.assignedFlight;
	}

	@Override
 	 public String toString(){
 		 return super.toString()+"\n Total Salary: "+calculateSalary()+"\n Assigned Flight: "
 		 +this.assignedFlight;
 	 }
}
