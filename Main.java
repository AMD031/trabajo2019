import classes.*;
import java.util.GregorianCalendar;
import java.util.Calendar;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class Main{
	public static void main(String[] args) {

		try{
			//idiomas del empleado
			ArrayList<String>language = new ArrayList<String>();
			language.add("Ingl\u00e9s");
			language.add("Portug\u00e9s");
			language.add("Espa\u00f1ol");
			language.add("Frac\u00e9s");

			//idiomas de la empresa
			ArrayList<String>lc = new ArrayList<String>();
			lc.add("Ingl\u00e9s");
			lc.add("Franc\u00e9s");
			lc.add("Portug\u00e9s");
			lc.add("Espa\u00f1ol");

	 	Employee.setLenguagesCompany(lc);
		char code[] = {'I','B','E'};
		//lista de de objetos con los que parte la compañia
		ArrayList<Client>clients = new ArrayList<Client>();
		ArrayList<Employee>emps = new ArrayList<Employee>();
		ArrayList<Ticket>tickets = new ArrayList<Ticket>();
		ArrayList<Flight>flights = new ArrayList<Flight>();
		ArrayList<Plane>planes = new ArrayList<Plane>();
		ArrayList<Airport>airports = new ArrayList<Airport>();
		
		//servicios de vuelo.
		ArrayList<String>servicios= new ArrayList<String>();
		servicios.add("Cafeteria");
		servicios.add("Hotel");
		servicios.add("Tiendas");
	
		//Aeropuertos
		airports.add(new Airport("SVQ","Sev","Sevilla","Espa\u00f1a", servicios));
		airports.add(new Airport("CDR","Cor","C\u00f3rdoba","Espa\u00f1a", servicios));

		//aviones
		planes.add(new Boing787("1945ABC",new GregorianCalendar(2000,1,0)));
		planes.add(new Boing787("1264AZB",new GregorianCalendar(1975,2,12)));
		planes.add(new AirBusA320("1234ABZ", new GregorianCalendar(1995,6,4)));

		//clientes	
		clients.add(new Client("12654658N","Pedro","Sanchez",new GregorianCalendar(1972,1,1),"Espa\u00f1ol"));
		clients.add(new Client("12345678Z","Maria","Perez",new GregorianCalendar(1990,8,5),"Espa\u00f1ola"));
	
		//empleados
			//ceo
		CEO boss =new CEO("12654658N","Pedro","Ruiz",new GregorianCalendar(1999,1,1),"Espa\u00f1ol",language,150000,4000);
			//tripulacion
	
		emps.add(new Crew("30568446C","Pedro","Ruiz",new GregorianCalendar(1999,1,1),"Espa\u00f1ol",language));
		emps.add( new Crew("12345678Z","Juan","Ruiz",new GregorianCalendar(1972,1,1),"Espa\u00f1ol",language));
			
			//pilotos
		emps.add(new Pilot("87654321X","Maria","Ruiz",new GregorianCalendar(1999,1,1),"Espa\u00f1ol",language,80));
		emps.add(new Pilot("30851231C","Juan","Ruiz",new GregorianCalendar(1980,1,1),"Espa\u00f1ol",language,80));

			//compañia
		AirCompany iberia = new AirCompany("IBERIA",code,boss,new GregorianCalendar(1999,1,1),
									  clients,tickets,emps,flights,planes,airports);
		
		//Agregacion vuelos y agregacion de empleados
		Flight  IB1009SVQ = new Flight(iberia,iberia.listAirports().get(0),iberia.listAirports().get(1),planes.get(0),
						 new GregorianCalendar(2040,3,20,10,9),80,100);
		
		Flight  IB1109CDR = new Flight(iberia,iberia.listAirports().get(1),iberia.listAirports().get(0),planes.get(1),
						 new GregorianCalendar(2040,3,20,11,9),80,100);

		Flight  IB1400CDR = new Flight(iberia,iberia.listAirports().get(1),iberia.listAirports().get(0),planes.get(2),
						 new GregorianCalendar(1999,3,4,14,0),80,100);
			//agregacion de empleados a los buelos
		IB1009SVQ.setCrew((Crew)iberia.listEmployees().get(0));
		IB1009SVQ.setPilot((Pilot)iberia.listEmployees().get(2));
			
			// agregando vuelo a la compañia
		iberia.addFlight(IB1009SVQ);
		iberia.addFlight(IB1109CDR);
		iberia.addFlight(IB1400CDR);
		


		//eliminacion de listas y variables despues de agregarlas a la compañia.
		boss = null;
		clients.clear(); 
		emps.clear();  
		tickets.clear(); 
		flights.clear();  
		planes.clear();
		airports.clear(); 
		language.clear();
		lc.clear();
		//lamada al menu
		System.out.println("Bienvenido.");
		Menu menu = new Menu(iberia);
		
		}catch(NullPointerException e){
			System.out.println("Error: "+e);
		}catch(Exception e){
			System.out.println("Error: "+e);
		}

	  }
   }

	