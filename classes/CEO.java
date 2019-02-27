package classes;
import java.util.GregorianCalendar;
import java.util.ArrayList;
/**
	* nombre: CEO.class
  * Descripcion: Clase CEO que hereda los metodos de la clase Employee y tiene
  * metodos propios y utiliza el constructor abstracto de la clase padre.
	* @author: Antonio Adamuz
	* @version: 0.0.1
*/

public class CEO extends Employee{
  private double bonus;
  private double salary;

  public CEO(String DNI,String Name, String Subname,
	 GregorianCalendar Birthdate,
	 String Nationaly,ArrayList<String> Lenguages, ArrayList<String> LenguagesCompany, int bonus ,int salary)throws Exception{
     super(DNI,Name,Subname,Birthdate,Nationaly,Lenguages,LenguagesCompany);
     this.bonus=bonus;
     this.salary=salary;
   }

   public double calculateSalary(){
     double total;
     total=this.salary + this.bonus;
     return total;
   }

   //setter
   public void setBonus(double b){
     this.bonus=b;
   }

   public void setSalary(double s){
     this.salary=s;
   }

   //getter
   public double getBonus(){
     return this.bonus;
   }

   public double getSalary(){
     return this.salary;
   }

   @Override
  	 public String toString(){
  		 return super.toString()+" Total Salary: "+calculateSalary()+"\n Bonus: "
  		 +this.bonus;
  	 }
}
