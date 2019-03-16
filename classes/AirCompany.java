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

	/**
	  comprueba si un aeropuesto esta repetido 
	  @param a aeropuerto a comparar.
	  @return devuelve true si encuentra 
	  el aeropuerto false en el caso contrario.
	*/	
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
	/**
		cambia un seo por otro.
		@param ceo sustituto del seo actual.
	*/

	public void setCeo(CEO ceo){
	  if(ceo!=null){	
		this.ceo = ceo;
		}
	}


	/**
	  Establece la iniciales de la compañia
	  @param charcode array de caracteres de la compñia
	*/
	public void setCharcode(char[] charcode){
		if(charcode.length==3){
			for (int i =0;i<charcode.length;i++){
				 this.charcode[i] = charcode[i];
				}
			}
		}

	/**
	 esctables o cambia el nombre de la compañia
	 @param name nombre de la compañia que sera añadido.
	*/	

	public void setName(String name){
		this.name = name;
	}

	/**
	  cambia o establece el dia de fundacion de la empresa.
	  @param year año de fundacion
	  @param month mes de la fundacion
	  @param dayOfMonth día de la fundacion
	*/
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

	/**
	  @return devuelve objeto de tipo GregorianCalendar que contiene la fecha de fundacion.
	*/
	public GregorianCalendar getFoundationDate(){
		return foundationDate;
	}

	/**
		@return devuelve un String con la fecha de fundacion.
	*/
	public String getFoundationDateString(){
		return "A\u00d1o: "+foundationDate.YEAR+" Mes:"+foundationDate.MONTH+" d\u00eda "+foundationDate.DATE;
	}




	//metodos de la interfaz

	/**
		Método usado para contratar empleados.
		@param e empleado a contratar.
		@throws Exception devuelve una mensaje si se introduce un empleado con dni duplicado.
	*/
	public boolean hireEmployee(Employee e)throws Exception{
		boolean correct= false;
		for (Employee employee : employees) {
			if( employee.getDni().equalsIgnoreCase(e.getDni()) ){
			   throw new Exception("Empleado duplicado no se puede contratar");
			}
		}
		if(this.employees.add(e)){
			correct = true;
		}
		return correct;
	}


	/**
		Método usado para despedir empleados.
		@param dni dni del empleado a despedir
		@param NEmployee id el empleado a despedir
		@return devuelve true si se ha podido despedir en caso contrario false.
	*/

	public boolean fireEmployee(String dni, int NEmployee){

		boolean found = false;	
		for(int i =0; i<this.flights.size();i++){
			
			//array crew
			Crew[] crews = this.flights.get(i).getCrewSeats();
			for(int j =0;j<crews.length && !found;j++){
			   if(crews[j]!=null){
				if(crews[j].getDni().equalsIgnoreCase(dni)&&
				   crews[j].getNEmployee()== NEmployee){
				   crews[j] =null;
				}
			  }
			}


			//array pilotos
			
			Pilot[] pilots = this.flights.get(i).getPilotSeats();
			for(int z =0;z<pilots.length && !found;z++){
			   if(pilots[z]!=null){

			   	 System.out.println(pilots[z].getNEmployee()==NEmployee);

				if(pilots[z].getDni().equalsIgnoreCase(dni)&&
				   pilots[z].getNEmployee()==NEmployee){
			
				   pilots[z] =null;
			
				}
			  }
			}
		   
		for(int x =0;x<this.employees.size();x++){
		 if(this.employees.get(x)!=null){	
			if(employees.get(x).getDni().equalsIgnoreCase(dni)&&
			   employees.get(x).getNEmployee()==NEmployee){
			  	employees.remove(x);
			  	found =true;

		   	}
		   }
		 }

		}
		return found;
	}
	/**
	 @return devuelve un array de empleados contratados.
	*/
	public ArrayList<Employee>listEmployees(){
		return this.employees;
	}


	/**
	busca un empleado por nombre y dni.
     @param NEmployee id del empleado a buscar.
	 @param dni dni del empleado a buscar.
	 @param name nombre del empleado a buscar.
	 @return devuelve un objeto de tipo employees.
	*/
	public Employee searchEMployee(String name,String dni, int NEmployee){
		Employee e = null;
		boolean found = false;
	
		for(int i=0; i<employees.size() && !found; i++){
			if( (employees.get(i).getDni().equalsIgnoreCase(dni)&&    
				 employees.get(i).getName().equalsIgnoreCase(name))||
				 (employees.get(i).getDni().equalsIgnoreCase(dni)&&
				 employees.get(i).getNEmployee()==NEmployee)||
				 employees.get(i).getDni().equalsIgnoreCase(dni)){
					e = employees.get(i);
					found = true;
				}
			}
		return e;
	}


	/**
	@return devuelve un double con el salario total de todos los empleados.
	*/
	public double totalSalary(){
		double totalSalary = 0;	
		for(Employee e: employees){
			totalSalary+=e.calculateSalary();
		}
		return totalSalary;
	}


	/**
	  método encargado de añadir aviones a la compañia.
	  @param p avion a añadir a la lista.
	  @throws Exception en caso de que el avion este duplicado devuelve un mensaje.
	*/
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

	/**
		devuelve una ArrayList de aviones.
	*/
	public ArrayList<Plane> listPlanes(){
		return this.planes;
	}

	/**
		Borra un avion que tenga la misma matricula que la que se la pasa por parametro.
		@param idPlane matricula avion a borra de la lista
		@return devuelve true si se ha podido borra el avion de la lista.
	*/
	public boolean removePlane(String idPlane){
		boolean found = false;
		if(idPlane.length()>0){
			for (int i=0;i<this.planes.size()&& !found;i++ ) {
					if(this.planes.get(i).getIDPlane().equals(idPlane)){
					   this.planes.remove(i);
					   found = true;
					}	
				}
			}		
		return found;
	}

    /**
		devuelve un avion que tenga la misma matricula que la que se la pasa por parametro.
		@param idPlane matricula del avion a buscar
		@return devuelve un objeto de tipo avion si lo encuentra y null en caso contrario.


    */
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

	/**
	 metedo que se encarga de añadir aviones a la compañia.
	 @param f objeto de tipo vuelo a añadir al ArryaList de vuelos. 
	 @return devuelve true si a podido ser añadido y false en caso contrario.
	 @throws Exception devuelve un mesaje si uno de los aeropuerto no existe.
	*/


	public boolean addFlight(Flight f)throws Exception{
		boolean correct = false;
		
      if(f!=null){
			if(!checkAirport(f.getObjectDestinationAirport())){
					throw new Exception("El Aeropuerto"+f+"no existe.");
			}
			if(!checkAirport(f.getObjectOriginAirport())){
					throw new Exception("El Aeropuerto"+f+"no existe.");
			}

			if(this.flights.add(f)){
			  correct = true;
			}
	    }
		return correct;
	}


	/**
	 devuelve una lista de vuelos 	
	*/
	public ArrayList<Flight> listFlight(){
		return this.flights;
	}


	/**
		Método que busca un vuelo por destion y orige.
		@param destinationAirport aropuerto origen
		@param originAirport aropuerto destino
		@return devuelve un objeto de tipo Flight si se ha encontrado y null en caso 
		contrario.

	*/
	public ArrayList<Flight> searchFlight(String destinationAirport
	, String originAirport){
		ArrayList<Flight>tmp = new ArrayList<Flight>();
		for(int i = 0;i<this.flights.size();i++){
			if(this.flights.get(i).getDestinationAirport().equalsIgnoreCase(destinationAirport)&&
			   this.flights.get(i).getOriginAirport().equalsIgnoreCase(originAirport)){
			     tmp.add(this.flights.get(i));
			}
		}		
		return tmp;
	}

	/**

	 Método que busca un buelo usado su code.
	 @param code codigo del vuelo a buscar.
	 @return devuelve un objeto de tipo Flight si se ha encontrado y null en caso 
		contrario.
	*/
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

	/**
		Método que elimina un buelo usado el codigo de vuelo
		@param code codigo del vuelo a borrar.
		@return devuelve true si se ha borrado correctamente.

	*/
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


	/**
		Método que añade ticket al ArrayList de tickets de la compañia.
		@param t objeto de tipo Ticket a añadir.
		@return devuelve true si el ticket se ha añasido correctamente.
	*/
	public boolean buyTicket(Ticket t){
		boolean correct = false;
		  if(!t.getSeat().getReserved()){
			t.getSeat().setReserved(true);
			if(t!=null && this.tickets.add(t)){
				t.getClient().incrementNbuys();
				correct = true;
			}
		}
		return correct;
	}

	public boolean removeTicket(String dni, String id ){
		boolean found = false;
		GregorianCalendar today = new GregorianCalendar();
		today.add(Calendar.DATE,-1);
			for (int i =0;i<this.tickets.size() && !found; i++){
				if(this.tickets.get(i).getClient().getDni().equalsIgnoreCase(dni)&&
				   this.tickets.get(i).getId().equals(id)){

				   	 if( !(today.after(tickets.get(i).getFlight().getDateAndTime())) ){
					   this.tickets.get(i).getSeat().setReserved(false);
					   this.tickets.get(i).getClient().incrementNrefund();
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
		
		for (int i =0;i<this.tickets.size() && !found; i++ ){
			if(this.tickets.get(i).getClient().getDni().equalsIgnoreCase(dni)&&
			   this.tickets.get(i).getId().equals(id)){
			   t = tickets.get(i);
			   found = true;
			}
		}
		return t;
	}

	/**
		Agrega un cliente a la lista de clientes de la empresa.
		@param c cliente a añadir
		@throws Exception devuelve un mensaje si el el cliente está duplicado.
	*/

	public boolean addClient(Client c)throws Exception{
		boolean correct = false;
		for (Client client : this.clients) {
			if( client.getDni().equalsIgnoreCase(c.getDni()) ){
			   throw new Exception("Cliente duplicado no se puede agregar el registro.");
			}
		}
		if(this.clients.add(c)){
			correct = true;
		}
		return correct;
	}



	/**
		@return devuleve un ArrayList de Client
	*/
	public ArrayList<Client> listClients(){
		return this.clients;
	}



	/**
	   Busca un cliente usado el dni del mismo.
	   @param dni dni del cliente a buscar.
	   @return devuelve un objeto de tipo Client si lo encuentra o null en caso contrario.
	*/
	public Client searchClient(String dni){
	
		boolean found = false;
		Client c = null;
		for(int i = 0; i<this.clients.size() && !found; i++){
			if(this.clients.get(i).getDni().equalsIgnoreCase(dni)){
				c = this.clients.get(i);
				found=true;
				
			}
		}
		return c;
	}

	/**
	   Elimina un cliente usado el dni del mismo.
	   @param dni dni del cliente a eliminar.
	   @return devuelve true si lo borra y false en caso contrario.
	*/


	public boolean removeClient(String dni){
		boolean found = false;	
		for(int i = 0; i<this.clients.size();i++){
			if(this.clients.get(i).getDni().equalsIgnoreCase(dni)){
			   this.clients.remove(i);
			}
		}
		return found;
	}


	/**
	  @param a objeto de tipo Airpor a añidir al ArrayList de airports 
	  @return devuel true si se a añadido con existo y false en caso contrario.
	  @throws Exception devuelve un mesaje si el aeropuerto esta duplicado.
	*/
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

	/**
	 @return devuelve un ArrayList de Airport.
	*/
	public ArrayList<Airport>listAirports(){
		return this.airports;
	}





}


