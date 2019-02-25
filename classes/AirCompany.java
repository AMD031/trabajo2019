package classes;
import java.util.ArrayList;
import interfaces.IAirCompany;
import java.util.GregorianCalendar;
import classes.*;
public class AirCompany implements IAirCompany{
	private String name;
	private char charcode[];
	private String ceo;
	private GregorianCalendar foundationDate;
	private ArrayList<Client>clients;
	private ArrayList<Ticket>tickets;
	private ArrayList<Employee>employees;
	private ArrayList<Plane>planes;

	public AirCompany(String name, char[] charcode, 
					  String ceo, GregorianCalendar foundationDate){
		this.name = name;
		this.charcode = charcode;
		this.ceo = ceo;
		this.foundationDate = foundationDate;
	}


	//setters
	public void setCeo(String ceo){
		this.ceo = ceo;
	}

	public void setCharcode(char[] charcode){
		if(charcode.length==3){
			for (int i =0;i<charcode.length;i++){
				 this.charcode[i] = charcode[i];
				}
			}
		}

	public void setName(String name){
		this.name = name;
	}

	public void setFoundationDate(int year, int month, int dayOfMonth){
		this.foundationDate.set(year,month,dayOfMonth);
	}

	//getters
	public String getCeo(){
		return this.ceo;
	}
	public String getName(){
		return name;
	}
	public char[] getCharcode(){
		return charcode;
	}

	public GregorianCalendar getFoundationDate(){
		return foundationDate;
	}



	//metodos de la interfaz
	public boolean hireEmployee(Employee e){
		boolean found = false;

		return found;
	}
	public boolean fireEmployee(String dni, String NEmployee){
		boolean found = false;

		return found;
	}

	public void listEmployee(){

	}
	public boolean searchEMployee(String name,String dni, String NEmployee){
		boolean found = false;

		return found;
	}
	public double totalSalary(){
		return 0;
	}

	/**
	 *Metodo agregar aviones.
	 *@author Samuel Hermosilla Aguilera.
	*/
	public boolean addPlane(Plane p){
		boolean found = false;

		planes.add(p);

		return found;
	}

	
	/**
	 *Metodo para listar aviones.
	 *@author Samuel Hermosilla Aguilera.
	*/
	public void listPlane(){
		for (Plane plane : planes){
			System.out.println(plane);
		}

	}
	public boolean removePlane(String idPlane){
		boolean found = false;

		return found;
	}

	/**
	 *Metodo para buscar aviones.
	 *@author Samuel Hermosilla Aguilera.
	*/
	public Plane searchPlane(String idPlane){

		for (Plane plane : planes){
			plane.getIDPlane().equals(idPlane);
		}

		return found;
	}

	public boolean addFlight(Flight f){
		boolean found = false;

		return found;
	}
	public boolean listFlight(){
		boolean found = false;

		return found;
	}
	public boolean serachFlight(String destinationAirpor
	, String originAirport){
		boolean found = false;

		return found;
	}
	public boolean removeFlight(String code){
		boolean found = false;

		return found;
	}
	public boolean buyTicket(String codeFlight){
		boolean found = false;

		return found;

	}
	public boolean removeTicket(){
		boolean found = false;

		return found;

	}
	public boolean searchTiket(String dni, String id){
		boolean found = false;

		return found;
	}
	public boolean addClient(Client client){
		boolean found = false;

		return found;
	}
	public void listClient(){

	}
	public boolean searchClient(String dni){
		boolean found = false;

		return found;

	}
	public boolean removeClient(String dni){
		boolean found = false;

		return found;

	}

	

	

}


