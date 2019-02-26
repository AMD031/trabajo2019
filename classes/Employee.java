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



	public Employee() throws Exception{
		super();
		setNEmployee();
	}

	public Employee (String DNI,String Name, String Subname,
	 GregorianCalendar Birthdate,
	 String Nationaly,ArrayList<String> Lenguages)throws Exception{
		 super(DNI,Name,Subname,Birthdate,Nationaly);
		 setNEmployee();
		 setLenguages(Lenguages);
		 chekBirthDate(Birthdate);
	 }

	 public void setLenguages(ArrayList<String> Lenguages){
		 if(Lenguages.size()>0){
		 	for(int i=0;i<Lenguages.size();i++){
			 		this.Lenguages.add(Lenguages.get(i));
		 		}
			}
	 }

	 public void chekBirthDate(GregorianCalendar Birthdate)throws Exception{
		 if(!checkAge(Birthdate, 18)){
			 throw new Exception("Eres menor de edad");
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

	 public ArrayList<String> getLenguages(){
		 return this.Lenguages;
	 }

	 public int getNEmployee(){
		 return this.NEmployee;
	 }

	 public ArrayList<String> getLenguagesCompany(){
		 return this.LenguagesCompany;
	 }


	  abstract public double calculateSalary();

		@Override
			public String toString(){
				return super.toString()+" Number Employee: "+this.NEmployee+"\n Lenguages: "
				+this.Lenguages;
			}
}
