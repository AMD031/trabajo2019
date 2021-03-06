package classes;
import java.util.GregorianCalendar;
import java.util.ArrayList;
/**
* Pilot.class
* Descripcion: Clase Pilot que hereda los metodos de la clase Employee y tiene
* metodos propios y utiliza el constructor abstracto de la clase padre.
* @author: Antonio Adamuz
* @version: 0.0.8
*/
public class Pilot extends Employee{
	private final static double plus=5000;
	private final static double Salary=100000;
	private int assignedFlight;
	private double Flytime;


	public Pilot(String DNI,String Name, String Subname,
	GregorianCalendar Birthdate, String Nationaly,
	ArrayList<String> Lenguages,double flytime)throws Exception{
		super(DNI,Name,Subname,Birthdate,Nationaly,Lenguages);
		this.setFlytime(flytime);
		this.assignedFlight=0;
	}
/**
*Funcion que calcula el salario total de un piloto el resultado lo devuelve
* en € anuales
@return devuelve el salario anual de un piloto.
*/
 public double calculateSalary(){
	 double total;
	 total=this.assignedFlight * this.plus;
	 total=this.Salary + total;
	 return total;
 }

 //setter
 public void incrementAssignedFlight(){
	 this.assignedFlight++;
 }
  public void decrementAssignedFlight(){
	 this.assignedFlight--;
 }

 public void setFlytime(double flytime){
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
		 return super.toString()+"\n Salario Total: "+calculateSalary()+"\n Vuelos Asignados: "
		 +this.assignedFlight+"\n Tiempo de vuelo: "+this.Flytime+" min";
	 }

}
