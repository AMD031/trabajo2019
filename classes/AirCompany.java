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
public class AirCompany implements IAirCompany {
	private String name;
	private char charcode[];
	private CEO ceo;
	private GregorianCalendar foundationDate;
	private ArrayList<Client>clients;
	private ArrayList<Ticket>tickets;
	private ArrayList<Employee>employees;
	private ArrayList<Flight>flights;
	private ArrayList<Plane>planes;
	public  ArrayList<Airport>airports;
	
	public AirCompany(String name, char[] charcode, 
					 CEO ceo, GregorianCalendar foundationDate, ArrayList<Client> clients, ArrayList<Ticket>tickets,
					 ArrayList<Employee>employees, ArrayList<Flight>flights, ArrayList<Plane>planes,ArrayList<Airport> airports)throws Exception{
		this.name = name;
		this.charcode = charcode;
		this.ceo = ceo;
		this.foundationDate = foundationDate;
		this.clients = new ArrayList<Client>();
		this.setClients(clients);
		this.tickets = new ArrayList<Ticket>();
		this.setTickets(tickets);
		this.employees =  new ArrayList<Employee>();
		this.setEmployees(employees);
		this.flights = new ArrayList<Flight>();
		this.setFlights(flights);
		this.planes = new ArrayList<Plane>();
		this.setPlanes(planes);
		this.airports = new ArrayList<Airport>();
		this.setAirports(airports);
		}

		public AirCompany(String name, char[] charcode, 
					 CEO ceo, GregorianCalendar foundationDate)throws Exception{
		this.name = name;
		this.charcode = charcode;
		this.ceo = ceo;
		this.foundationDate = foundationDate;
		this.clients = new ArrayList<Client>();
        this.tickets = new ArrayList<Ticket>();
	    this.employees =  new ArrayList<Employee>();
		this.flights = new ArrayList<Flight>();
		this.planes = new ArrayList<Plane>();
		this.airports = new ArrayList<Airport>();
		}





	public boolean checkAirport(Airport a){
		boolean found = false;
		for(int i =0;i<airports.size() && !found;i++){
			if(airports.get(i).equals(a)){
				found = true;
			}
		}
		return found;
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

	public void setAirports(ArrayList<Airport> airports)throws Exception{
			if(airports.size()>0){
				for(int i=0; i<airports.size(); i++){
				 	if(airports.get(i)!=null  && !this.checkAirport(airports.get(i))){
				 		this.addAirport(airports.get(i));	
				 	}
				}
			}
	}


	public void setClients(ArrayList<Client> clients)throws Exception{
			if(clients.size()>0){
				for(int i=0; i<clients.size(); i++){
				  if(clients.get(i)!=null){
					this.addClient(clients.get(i));
				   }
				}
			}
	}

	public void setTickets(ArrayList<Ticket> tickets){	
		if(tickets.size()>0){
			for(int i=0; i<tickets.size(); i++){
			  if(tickets.get(i)!=null){
				this.tickets.add(tickets.get(i));
			  }
			}
		}	
	
	}

	public void setEmployees(ArrayList<Employee> employees)throws Exception{
		if(employees.size()>0){
			for(int i=0; i<employees.size(); i++){
			  if(employees.get(i)!=null){
					this.hireEmployee(employees.get(i));
				}
			}
		}	
	}

	public void setFlights(ArrayList<Flight> flights)throws Exception{
		if(flights.size()>0){
			for(int i=0; i<flights.size(); i++){
			   if(flights.get(i)!=null){		
					this.addFlight(flights.get(i));
				}
			}
		}


	}

	public void setPlanes(ArrayList<Plane> planes)throws Exception{
		if(planes.size()>0){
			for(int i=0; i<planes.size(); i++){
			   	if(planes.get(i)!=null){	
					this.addPlane(planes.get(i));
				}
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

	public String getFoundationDateString(){
		return "YEAR: "+foundationDate.YEAR+" MONTH "+foundationDate.MONTH+" DATE "+foundationDate.DATE;
	}




	//metodos de la interfaz
	@Override
	public boolean hireEmployee(Employee e)throws Exception{
		boolean correct= false;
		for (Employee employee : employees) {
			if( employee.getDni().equals(e.getDni()) ){
			   throw new Exception("Empleado duplicado no se puede contratar");
			}
		}
		if(this.employees.add(e)){
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
	public ArrayList<Employee>listEmployees(){
		return this.employees;
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
		boolean duplicated = false;
		
		for (Plane plane : planes) {
			if(plane.getIDPlane().equals(p.getIDPlane())){
				duplicated= true;		
			}
		}
			if(duplicated){	
				throw new Exception("Avion con matricula duplicada. No se pude introducir");
			}else{
				if(this.planes.add(p)){
					correct = true;
				}

			}

		return correct;
	}

	@Override
	public ArrayList<Plane> listPlanes(){
		return this.planes;
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
		boolean correct = false;
		if(this.flights.add(f)){
		  correct = true;
		}
		return correct;
	}

	@Override
	public ArrayList<Flight> listFlight(){
		return this.flights;
	}

	@Override
	public Flight serachFlight(String destinationAirport
	, String originAirport){
		Flight f =null;
		boolean stop =false;
		this.flights.get(0).getOriginAirport().equals(destinationAirport);
		for(int i = 0;i<this.flights.size() && !stop;i++){
			if(this.flights.get(i).getDestinationAirport().equals(destinationAirport)&&
			   this.flights.get(i).getOriginAirport().equals(originAirport)){
			    f =this.flights.get(i);
				stop = true;
			}
		}


		return f;
	}

	@Override
	public boolean removeFlight(String code){
		boolean found = false;
	


		return found;
	}

	@Override
	public boolean buyTicket(Ticket t){
		boolean correct = false;
		if(t!=null && this.tickets.add(t)){
			correct = true;
		}
		return correct;
	}

	@Override
	public boolean removeTicket(String dni, String id ){
		boolean found = false;
		searchTicket(dni, id).setClient(null);
		searchTicket(dni, id).setSeat(null);
		searchTicket(dni, id).setId("");
		searchTicket(dni, id).setClient(null);
		for (int i =0;i<tickets.size();i++) {	
			if( tickets.get(i).getClient().getDni().equals(dni)&&
			    tickets.get(i).getId().equals(id)  ){
				tickets.remove(i);
				found=true;
			}
		}
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
		if(this.clients.add(c)){
			correct = true;
		}
		return correct;
	}




	@Override
	public ArrayList<Client> listClients(){
		return this.clients;
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
		for(int i = 0; i<clients.size();i++){
			if(clients.get(i).getDni().equals(dni)){
				clients.remove(i);
			}
		}
		return found;
	}


	public boolean addAirport(Airport a){
		boolean correct = false;
		if(this.airports.add(a)){
			correct = true;	
		}
		return correct;
	}

	public ArrayList<Airport>listAirports(){
		return this.airports;
	}





}


