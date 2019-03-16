package classes;
import java.util.GregorianCalendar;
import java.util.ArrayList;
/**
	* nombre: Employee.class
	* Descripcion: La clase Employee (es una clase abstracta)
	* lo que hace es instaciar los empleados de la empresa utilizando
	* la clase Person.java
	* @author: Antonio Adamuz
	* @version: 0.0.8
*/

abstract public class Employee extends Person{
	private static ArrayList<String> LenguagesCompany=new ArrayList<String>();
	private ArrayList<String> Lenguages=new ArrayList<String>();

	protected static int NEmployee=0;
	private int id;


	public Employee (String DNI,String Name, String Subname,
	 GregorianCalendar Birthdate,
	 String Nationaly,ArrayList<String> Lenguages)throws Exception{
		 super(DNI,Name,Subname,Birthdate,Nationaly);
		 this.id=setNEmployee();
		 setLenguages(Lenguages);
		 chekBirthDate(Birthdate);
	 }


	 //setter
	 /**
	 *Setter de lenguajes que recibe un ArrayList de lenguajes
	 *@param lenguages objeto de tipo ArrayList que contiene la lista de idiomas que conoce el 
	 * empleado.
	 *
	 */
	 public void setLenguages(ArrayList<String> lenguages){
		  if(lenguages.size()>0){
			for(int i = 0; i<lenguages.size();i++){
				if(!checkLenguages(this.Lenguages,lenguages.get(i))
					&& checkLenguages(this.LenguagesCompany,lenguages.get(i))){
					this.Lenguages.add(lenguages.get(i));
				}
			}
		}
	 }

	 /**
	 metodo que comprueba si un idioma esta en un ArraList de idomas
	 @param l idioma a buscar en la lista.
	 @param lenguages lista de idiomas en la que se buscara el idioma en particular.
	 @return devuelve true si  encuentra el idioma en la lista.
	 */
	  private static boolean checkLenguages(ArrayList<String>lenguages, String l){
	 	boolean found = false;
	 	if(lenguages.size()>0){
	 		for(int i = 0;i<lenguages.size() && !found;i++){
	 			if(lenguages.get(i).equals(l)){
	 				found = true;
	 			}
	 		}
	 	}
	 	return found;
	  }

	 /**
	 *Metodo que comprueba si el empleado es mayor o menor de edad.
	 @param Birthdate objeto de tipo GregorianCalendar que contiene el  
	 cupleaños de la persona a comprobar.
	 @throws Exception devuelve un mensaje si el empleado es menor de 18 años. 
	 */
	 public void chekBirthDate(GregorianCalendar Birthdate)throws Exception{
		 if(!checkAge(Birthdate, 18)){
			 throw new Exception("No puedes ser contratado eres menor de edad");
		 }
	 }

	 /**
	 *Setter que hace contar el numero de empleados y sumar uno a uno cuando se
	 *crea un empleado.
	 @return devuelve el id del empleado
	 */
	 public static int setNEmployee(){
		 return Employee.NEmployee++;

	 }

	 /**
	 *setter que recibe el ArrayList de los lenguajes de la compañia minimos que
	 *un empleado debe tener.
	 @param LenguagesCompany ArrayList que contiene la lista de idiomas de la compañia.
	 */
	 public static void setLenguagesCompany(ArrayList<String> LenguagesCompany){
		 if(LenguagesCompany.size()>0){

				 for(int i=0;i<LenguagesCompany.size();i++){
				 	if(!checkLenguages(Employee.LenguagesCompany,LenguagesCompany.get(i))){
					 Employee.LenguagesCompany.add(LenguagesCompany.get(i));
				 	}
				 }
			}
	 }

	 //getter
	 public ArrayList<String> getLenguages(){
		 return this.Lenguages;
	 }

	 public int getNEmployee(){
		 return this.id;
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
				return super.toString()+"\n Numero de empleado: "+this.id+"\n Lenguajes: "
				+LG.toString();
			}
}
