package classes;
import java.util.GregorianCalendar;
import java.util.ArrayList;
/**
* Crew.class
* Descripcion: Clase Crew que hereda los metodos de la clase Employee y tiene
* metodos propios y utiliza el constructor abstracto de la clase padre.
* @author: Antonio Adamuz
* @version: 0.0.8
*/
public class Crew extends Employee{
	private final static double Salary=40000;
	private final static double plus=1000;
	private int assignedFlight;



	public Crew(String DNI,String Name, String Subname,
	 GregorianCalendar Birthdate,
	 String Nationaly,ArrayList<String> Lenguages)throws Exception{
		super(DNI,Name,Subname,Birthdate,Nationaly,Lenguages);
		this.assignedFlight =0;
	}

	/**
	* Funcion que calcula el salario total.
	*@return devuelve  el salario calculado de un tripulate.
	*/

	public double calculateSalary(){
		double total;
		total = this.plus * this.assignedFlight;
		total=total + this.Salary;
		return total;
	}

	public void incrementAssignedFlight(){
	 	this.assignedFlight++;
	}

  	public void decrementAssignedFlight(){
		 this.assignedFlight--;
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
 		 return super.toString()+"\n Salario Total: "+calculateSalary()+"\n Vuelos Asignados: "
 		 +this.assignedFlight;
 	 }
}
