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
  public int bonus;

  public CEO(String DNI,String Name, String Subname,
	 GregorianCalendar Birthdate,
	 String Nationaly,ArrayList<String> Lenguages, int bonus)throws Exception{
     super(DNI,Name,Subname,Birthdate,Nationaly,Lenguages);
     this.bonus=bonus;
   }

   public double calculateSalary(){
     return 1;
   }
}
