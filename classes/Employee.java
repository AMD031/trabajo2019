package classes;
import java.util.GregorianCalendar;
import java.util.ArrayList;
/**
	* nombre: Employee.class
	* Descripcion: La clase Employee (es una clase abstracta)
	* lo que hace es instaciar los empleados de la empresa utilizando
	* la clase Person.java
	* @author: Antonio Adamuz
	* @version: 0.0.1
*/

abstract public class Employee extends Person{
	private ArrayList<String> LenguagesCompany;
	private ArrayList<String> Lenguages;

	protected static int NEmployee;


/*Constructor por defecto en caso de que no pasen ningun parametro*/
	public Employee() throws Exception{
		super();
		setNEmployee();
	}
/**
*Conctructor con todos los parametros para crear un empleado y llama a
*constructores para asignar un numero de empleado, los lenguages y que compruebe
*si em empleado es mayor de edad.
*/
	public Employee (String DNI,String Name, String Subname,
	 GregorianCalendar Birthdate,
	 String Nationaly,ArrayList<String> Lenguages,
	  ArrayList<String> LenguagesCompany)throws Exception{
		 super(DNI,Name,Subname,Birthdate,Nationaly);
		 setNEmployee();
		 setLenguages(Lenguages);
		 chekBirthDate(Birthdate);
		 setLenguagesCompany(LenguagesCompany);
	 }


	 //setter
	 /**
	 *Setter de lenguajes que recibe un ArrayList de lenguajes
	 */
	 public void setLenguages(ArrayList<String> Lenguages){
		 if(Lenguages.size()>0){
		 	for(int i=0;i<Lenguages.size();i++){
			 		this.Lenguages.add(Lenguages.get(i));
		 		}
			}
	 }

	 /**
	 *Metodo que comprueba si el empleado es mayor o menor de edad.
	 */
	 public void chekBirthDate(GregorianCalendar Birthdate)throws Exception{
		 if(!checkAge(Birthdate, 18)){
			 throw new Exception("Eres menor de edad");
		 }
	 }

	 /**
	 *Setter que hace contar el numero de empleados y sumar uno a uno cuando se
	 *crea un empleado.
	 */
	 public static void setNEmployee(){
		 Employee.NEmployee++;
	 }

	 /**
	 *setter que recibe el ArrayList de los lenguajes de la compañia minimos que
	 *un empleado debe tener.
	 */
	 public void setLenguagesCompany(ArrayList<String> LenguagesCompany){
		 if(LenguagesCompany.size()>0){
				 for(int i=0;i<LenguagesCompany.size();i++){
					 this.LenguagesCompany.add(LenguagesCompany.get(i));
				 }
			}
	 }

	 //getter
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
				StringBuilder LG=new StringBuilder();
				for(int i=0;i<this.Lenguages.size();i++){
					LG.append(" "+Lenguages.get(i)+" ");
				}
				return super.toString()+" Number Employee: "+this.NEmployee+"\n Lenguages: "
				+LG.toString();
			}
}
