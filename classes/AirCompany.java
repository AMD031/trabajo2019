package classes;
import java.util.ArrayList;
import interfaces.IAirCompany;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.Calendar;
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
				  	 this.clients.add(clients.get(i));
				   }
				}
			}
	}

	public void setTickets(ArrayList<Ticket> tickets)throws Exception{	
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
		return "A\u00d1o: "+foundationDate.YEAR+" Mes:"+foundationDate.MONTH+" d\u00eda "+foundationDate.DATE;
	}




	//metodos de la interfaz
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

	public boolean fireEmployee(String dni, int NEmployee){
		boolean found = false;	
		dni =dni.toUpperCase();
		for(int i =0; i<this.flights.size();i++){
			//array crew
			Crew[] crews = this.flights.get(i).getCrewSeats();
			for(int j =0;j<crews.length && !found;j++){
				if(crews[i].getDni().equals(dni)&&
				   crews[i].getNEmployee()== NEmployee){
				   crews[i] =null;
				}
			}
			//array pilotos
			Pilot[] pilots = this.flights.get(i).getPilotSeats();
			for(int z =0;z<pilots.length && !found;z++){
				if(pilots[i].getDni().equals(dni)&&
				   pilots[i].getNEmployee()==NEmployee){
				   pilots[i] =null;
				}
			}
		}
		for(int i =0;i<this.employees.size();i++){
			if(employees.get(i).getDni().equals(dni)&&
			   employees.get(i).getNEmployee()==NEmployee){
			  	employees.remove(i);
			  	found =true;
			}
		}

	

		return found;
	}


	public ArrayList<Employee>listEmployees(){
		return this.employees;
	}


	public Employee searchEMployee(String name,String dni, int NEmployee){
		Employee e = null;
		boolean found = false;
		dni =dni.toUpperCase();
		for(int i=0; i<employees.size() && !found; i++){
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


	public double totalSalary(){
		double totalSalary = 0;	
		for(Employee e: employees){
			totalSalary+=e.calculateSalary();
		}
		return totalSalary;
	}

	
	public boolean addPlane(Plane p)throws Exception{
		boolean correct = false;
		boolean duplicated = false;		
		for (Plane plane : planes) {
			if(plane.getIDPlane().equals(p.getIDPlane())){
				throw new Exception("Avion con matricula duplicada. No se pude introducir");		
			}
		}		
		if(this.planes.add(p)){
			correct = true;
		}	
		return correct;
	}

	
	public ArrayList<Plane> listPlanes(){
		return this.planes;
	}


	public boolean removePlane(String idPlane){
		boolean found = false;

		return found;
	}


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


	public boolean addFlight(Flight f)throws Exception{
		boolean correct = false;
		

		if(!checkAirport(f.getObjectDestinationAirport())){
				throw new Exception("El Aeropuerto"+f+"no existe.");
		}
		if(!checkAirport(f.getObjectOriginAirport())){
				throw new Exception("El Aeropuerto"+f+"no existe.");
		}

	
		for(Flight flight :this.flights){
			if(flight.getCode().equals(f.getCode())){
			 	throw new Exception("Vuelo duplicado.");
			}
		}


		if(this.flights.add(f)){
		  correct = true;
		}
		return correct;
	}

	
	public ArrayList<Flight> listFlight(){
		return this.flights;
	}


	public ArrayList<Flight> searchFlight(String destinationAirport
	, String originAirport){
		ArrayList<Flight>tmp = new ArrayList<Flight>();
		for(int i = 0;i<this.flights.size();i++){
			if(this.flights.get(i).getDestinationAirport().equals(destinationAirport)&&
			   this.flights.get(i).getOriginAirport().equals(originAirport)){
			     tmp.add(this.flights.get(i));
			}
		}
		return tmp;
	}


	public Flight searchFlight(String code){
		 boolean found = false;
		 Flight tmp = null;
		for(int i = 0;i<this.flights.size() && !found;i++){
			if(this.flights.get(i).getCode().equals(code)){
			     tmp = this.flights.get(i);
			     found = true;
			}
		}
		return tmp;
	}




	
	public boolean removeFlight(String code){
		boolean found = false;
		for(int i =0;i<this.tickets.size();i++){
			if(this.tickets.get(i).getFlight().getCode().equals(code)){
				this.tickets.remove(i);
			}
		}
		for(int i =0;i<this.flights.size();i++){
			if(this.flights.get(i).getCode().equals(code)){
				this.flights.remove(i);
				found=true;
			}	
		}
		
		return found;
	}


	public boolean buyTicket(Ticket t){
		boolean correct = false;
		  if(!t.getSeat().getReserved()){
			 t.getSeat().setReserved(true);
			if(t!=null && this.tickets.add(t)){
				correct = true;
			}
		}
		return correct;
	}

	public boolean removeTicket(String dni, String id ){
		boolean found = false;
		GregorianCalendar today = new GregorianCalendar();
		today.add(Calendar.DATE,-1);
		dni = dni.toUpperCase();
		System.out.println(dni);
			for (int i =0;i<this.tickets.size() && !found; i++){
				if(this.tickets.get(i).getClient().getDni().equals(dni)&&
				   this.tickets.get(i).getId().equals(id)){
					 if(today.after(tickets.get(i).getFlight().getDateAndTime())){
					   this.tickets.get(i).getSeat().setReserved(false);
					   this.tickets.remove(i);
					   found = true;
					 }
				}
			}
			
		return found;
	}

 	public Ticket searchTicket(String dni, String id){
		Ticket t = null;
		boolean found = false;
		dni =dni.toUpperCase();
		for (int i =0;i<this.tickets.size() && !found; i++ ){
			if(this.tickets.get(i).getClient().getDni().equals(dni)&&
			   this.tickets.get(i).getId().equals(id)){
			   t = tickets.get(i);
			   found = true;
			}
		}
		return t;
	}

	/**
		Agrega un cliente a la lista de clientes de la empresa.
		@author Antonio Martinez Diaz
	*/

	public boolean addClient(Client c)throws Exception{
		boolean correct = false;
		for (Client client : this.clients) {
			if( client.getDni().equals(c.getDni()) ){
			   throw new Exception("Cliente duplicado no se puede agregar el registro.");
			}
		}
		if(this.clients.add(c)){
			correct = true;
		}
		return correct;
	}





	public ArrayList<Client> listClients(){
		return this.clients;
	}


	public Client searchClient(String dni){
		dni =dni.toUpperCase();
		boolean found = false;
		Client c = null;
		for(int i = 0; i<this.clients.size() && !found; i++){
			if(this.clients.get(i).getDni().equals(dni)){
				c = this.clients.get(i);
				found=true;
				
			}
		}
		return c;
	}


	public boolean removeClient(String dni){
		boolean found = false;
		dni =dni.toUpperCase();
		for(int i = 0; i<this.clients.size();i++){
			if(this.clients.get(i).getDni().equals(dni)){
			   this.clients.remove(i);
			}
		}
		return found;
	}


	public boolean addAirport(Airport a)throws Exception{
		boolean correct = false;
		if(checkAirport(a)){
			throw new Exception("Aeropueto dublicado. No se puede insertar.");
		}
		
		if(this.airports.add(a)){
			correct = true;	
		}
		return correct;
	}

	public ArrayList<Airport>listAirports(){
		return this.airports;
	}





}


