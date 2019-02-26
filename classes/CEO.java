package classes;
import java.util.GregorianCalendar;
import java.util.ArrayList;
/**
	* nombre: CEO.class
	* Descripcion:
	* @author: Antonio Adamuz
	* @version: 0.0.1
*/

public class CEO extends Employee{
  private int bonus;
  private int salary;

  public CEO(String DNI,String Name, String Subname,
	 GregorianCalendar Birthdate,
	 String Nationaly,ArrayList<String> Lenguages, int bonus ,int salary)throws Exception{
     super(DNI,Name,Subname,Birthdate,Nationaly,Lenguages);
     this.bonus=bonus;
     this.salary=salary;
   }

   public double calculateSalary(){
     this.salary=this.salary + this.bonus;
     return this.salary;
   }
}