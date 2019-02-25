package classes;
import java.util.GregorianCalendar;
import java.util.ArrayList;
/**
	* nombre: Employee.class
	* Descripcion:
	* @author: Antonio Adamuz
	* @version: 0.0.1
*/

abstract public class Employee extends Person{
	private final static int QUANTITY_DEF=0;

	private ArrayList<String> LenguagesCompany;
	private ArrayList<String> Lenguages;


	protected static int NEmployee;
	protected int Quantity;


	public Employee() throws Exception{
		super();
		setNEmployee();
		this.Quantity=QUANTITY_DEF;
	}

	public Employee (String DNI, int NEmployee, String Name, String Subname,
	 GregorianCalendar Birthdate,
	 String Nationaly,int quantity,ArrayList<String> Lenguages)throws Exception{
		 super(DNI,Name,Subname,Birthdate,Nationaly);
		 setNEmployee();
		 setLenguages(Lenguages);
	 }

	 public void setLenguages(ArrayList<String> Lenguages){
		 if(Lenguages.size()>0){
		 	for(int i=0;i<Lenguages.size();i++){
			 		this.Lenguages.add(Lenguages.get(i));
		 		}
			}
	 }

	 public static void setNEmployee(){
		 Employee.NEmployee++;
	 }

	 public void setLenguagesCompany(ArrayList<String> LenguagesCompany){
		 if(LenguagesCompany.size()>0){
				 for(int i=0;i<LenguagesCompany.size();i++){
					 this.LenguagesCompany.add(LenguagesCompany.get(i));
				 }
			}	 
	 }


	  abstract public double calculateSalary();
}
