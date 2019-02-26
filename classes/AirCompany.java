package classes;
import java.util.ArrayList;
import interfaces.IAirCompany;
import java.util.GregorianCalendar;
import java.util.Iterator;
import classes.*;
/**
AirCompany.class
clase que representa una empresa de vuelos su fucion
es gestionar los empleado, clientes, aviones y vuelos.
@author Antonio Martinez Diaz 
*/
public class AirCompany implements IAirCompany{
	private String name;
	private char charcode[];
	private String ceo;
	private GregorianCalendar foundationDate;
	private ArrayList<Client>clients;
	private ArrayList<Ticket>tickets;
	private ArrayList<Employee>employees;
	private ArrayList<Flight>Flights;
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

	@Override
	public boolean hireEmployee(Employee e){
		boolean correct= false;
		if(employees.add(e)){
			correct = true;
		}
		return correct;
	}

	@Override
	public boolean fireEmployee(String dni, String NEmployee){
		boolean found = false;


		return found;
	}

	@Override
	public ArrayList<Employee>listEmployee(){
		return employees;
	}

	@Override
	public Employee searchEMployee(String name,String dni, String NEmployee){
		Employee e = null;

		for(int i; i<employees.size(); i++){
			if((employees.get(i).getDni().equals(dni)&&    
				 employees.get(i).getName().equals(name))||
				 (employees.get(i).getNEmployee().equals(NEmployee)&&    
				 employees.get(i).getName().equals(name))){
					e.employees.get(i);
				}
			}

		
		return found;
		
	}

	@Override
	public double totalSalary(){
		return 0;
	}

	/**
	 *Metodo agregar aviones.
	 *@author Samuel Hermosilla Aguilera.
	*/
	@Override
	public boolean addPlane(Plane p){
		boolean found = false;
		if(planes.add(p)){
			found = true;
		}
		return found;
	}

	
	/**
	 *Metodo para listar aviones.
	 *@author Samuel Hermosilla Aguilera.
	*/
	@Override
	public ArrayList<Plane> listPlane(){
		return planes;
	}

	@Override
	public boolean removePlane(String idPlane){
		boolean found = false;

		return found;
	}

	/**
	 *Metodo para buscar aviones.
	 *@author Samuel Hermosilla Aguilera.
	*/
	@Override
	public Plane searchPlane(String idPlane){
		boolean found = false;
		Plane p =null;
		for(int i = 0; i<planes.size() && !found; i++){
			if(planes.get(i).getIDPlane().equals(idPlane)){
				found=true;
				p=planes.get(i);
			}
		}
		return p;
	}

	@Override
	public boolean addFlight(Flight f){
		boolean found = false;
		if(addFlight(f)){
		  found = true;
		}
		return found;
	}

	@Override
	public ArrayList<Flight> listFlight(){
		return Flights;
	}

	@Override
	public boolean serachFlight(String destinationAirpor
	, String originAirport){
		boolean found = false;

		return found;
	}

	@Override
	public boolean removeFlight(String code){
		boolean found = false;

		return found;
	}

	@Override
	public boolean buyTicket(String codeFlight){
		boolean found = false;

		return found;

	}

	@Override
	public boolean removeTicket(){
		boolean found = false;

		return found;

	}
	@Override
 	public Ticket searchTicket(String dni, String id){
		Ticket t = null;
		for (int i =0;i<tickets.size() && !found; i++ ) {
			if(tickets.get(i).getDni().equals(dni) &&
			   	

				){
			  found=true;
			  t=tickets.get(i);
			}
		}
		return t
	}

	/**
		Agrega un cliente a la lista de clientes de la empresa.
		@author Antonio Martinez Diaz
	*/
	@Override
	public boolean addClient(Client client){
		boolean correct = false;
		if(clients.add(client)){
			correct = true;
		}
		return correct;
	}

	@Override
	public ArrayList<Client> listClient(){
		return clients;
	}

	@Override
	public Client searchClient(String dni){
		boolean found = false;
		Client c = null;
		for(int i = 0; i<clients.size() && !found; i++){
			if(clients.get(i).getDni().equals(dni)){
				found=true;
				c=clients.get(i);
			}
		}
		return c;
	}

	@Override
	public boolean removeClient(String dni){
		boolean found = false;
		for(int i = 0; i<clients.size() && !found; i++){
			if(clients.get(i).getDni().equals(dni)){
				clients.remove(i);
				found = true;
			}
		}
		return found;
	}

	




}


