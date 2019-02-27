package classes;
import java.util.ArrayList;
import interfaces.IAirCompany;
import java.util.GregorianCalendar;
import java.util.Iterator;
import classes.*;
/**
AirCompany.class
clase que representa una empresa de vuelos su fucion
es gestionar los empleado, clientes, aviones,vuelos y aeropuertos en los que
trabaja.
@author Antonio Martinez Diaz 
*/
public class AirCompany implements IAirCompany{
	private String name;
	private char charcode[];
	private CEO ceo;
	private GregorianCalendar foundationDate;
	private ArrayList<Client>clients=new ArrayList<Client>();
	private ArrayList<Ticket>tickets=new ArrayList<Ticket>();
	private ArrayList<Employee>employees=new ArrayList <Employee>();
	private ArrayList<Flight>Flights=new ArrayList <Flight>();
	private ArrayList<Plane>planes=new ArrayList <Plane>();

	public AirCompany(String name, char[] charcode, 
					 CEO ceo, GregorianCalendar foundationDate, ArrayList<Client> clients, ArrayList<Ticket>tickets,
					 ArrayList<Employee>employees, ArrayList<Flight>flights, ArrayList<Plane>planes){
		this.name = name;
		this.charcode = charcode;
		this.ceo = ceo;
		this.foundationDate = foundationDate;
		setClients(clients);
		setTickets(tickets);
		setEmployees(employees);
		setFlights(flights);
		setPlanes(planes);
	}


	//setters
	public void setCeo(CEO ceo){
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

	public void setClients(ArrayList<String> clients){
		if(clients!=null){
			for(int i=0; i<clients.size(); i++){
				this.clients.add(clients.get(i));
			}
		}	
	}

	public void setTickets(ArrayList<String> tickets){
		if(tickets!=null){
			for(int i=0; i<tickets.size(); i++){
				this.tickets.add(tickets.get(i));
			}
		}	
	}

	public void setEmployees(ArrayList<String> employees){
		if(employees!=null){
			for(int i=0; i<employees.size(); i++){
				this.employees.add(employees.get(i));
			}
		}	
	}

	public void setFlights(ArrayList<String> flights){
		if(flights!=null){
			for(int i=0; i<flights.size(); i++){
				this.flights.add(flights.get(i));
			}
		}	
	}

	public void setPlanes(ArrayList<String> planes){
		if(planes!=null){
			for(int i=0; i<planes.size(); i++){
				this.planes.add(planes.get(i));
			}
		}	
	}

	//getters
	public CEO getCeo(){
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
	/**
		

	*/
	@Override
	public boolean hireEmployee(Employee e)throws Exception{
		boolean correct= false;
		for (Employee employee : employees) {
			if( employee.getDni().equals(e.getDni()) ){
			   throw new Exception("Empleado duplicado no se puede introducir");
			}
		}
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
	public Employee searchEMployee(String name,String dni, int NEmployee){
		Employee e = null;
		boolean found = false;


		for(int i=0; i<employees.size() && !found; i++){
			System.out.println(employees.get(i).getNEmployee());
			if( (employees.get(i).getDni().equals(dni)&&    
				 employees.get(i).getName().equals(name))||
				 (employees.get(i).getDni().equals(dni)&&
				 employees.get(i).getNEmployee()==NEmployee)||
				 employees.get(i).getDni().equals(dni)){
					e = employees.get(i);
					found = true;
				}
			}
		return e;
	}

	@Override
	public double totalSalary(){
		double totalSalary = 0;	
		for(Employee e: employees){
			totalSalary+=e.calculateSalary();
		}
		return totalSalary;
	}

	@Override
	public boolean addPlane(Plane p)throws Exception{
		boolean correct = false;
		for (Plane plane : planes) {
			if(plane.getIDPlane().equals(p.getIDPlane())){
				throw new Exception("Avion duplicado no se pude introducir");
			}
		}
		if(planes.add(p)){
			correct = true;
		}
		return correct;
	}

	/**
	  *Metodo para listar aviones
	  *@author Samuel Hermosilla Aguilera
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
	public boolean removeTicket(String dni, String id ){
  	 /**private Client client;
		private Seat seat;
		private String id;
		private Flight flight;*/
		boolean found = false;





		return found;

	}
	@Override
 	public Ticket searchTicket(String dni, String id){
		Ticket t = null;
		boolean found = false;
		for (int i =0;i<tickets.size() && !found; i++ ){
			if(tickets.get(i).getClient().getDni().equals(dni)&&
			   tickets.get(i).getId().equals(id)){
			   t = tickets.get(i);
			}
		}
		return t;
	}

	/**
		Agrega un cliente a la lista de clientes de la empresa.
		@author Antonio Martinez Diaz
	*/
	@Override
	public boolean addClient(Client c)throws Exception{
		for (Client client : clients) {
			if( client.getDni().equals(c.getDni()) ){
			   throw new Exception("Cliente duplicado no se puede introducir");
			}
		}
		boolean correct = false;
		if(clients.add(c)){
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
		boolean correct = false;
		



		return correct;
	}

	




}


