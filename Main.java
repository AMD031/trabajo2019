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
		servicios.add("Cafeter\u00eda");
		servicios.add("Hotel");
		servicios.add("Tiendas");

		ArrayList<String>servicios2= new ArrayList<String>();
		servicios2.add("Cafeter\u00eda");
		servicios2.add("Hotel");
		servicios2.add("Tiendas");
		servicios2.add("bar");


	
		//Aeropuertos
		airports.add(new Airport("SVQ","Sev","Sevilla","Espa\u00f1a", servicios));
		airports.add(new Airport("CDR","Cor","C\u00f3rdoba","Espa\u00f1a", servicios2));
		airports.add(new Airport("MAD","Mad","Madrid","Espa\u00f1a", servicios2));
		airports.add(new Airport("BAR","Bar","Barcelona","Espa\u00f1a", servicios));


		//aviones
		planes.add(new Boing787("1945ABC",new GregorianCalendar(2000,Calendar.FEBRUARY,0)));
		planes.add(new Boing787("1264AZB",new GregorianCalendar(1975,Calendar.MARCH,12)));
		planes.add(new AirBusA320("1234ABZ", new GregorianCalendar(1995,Calendar.DECEMBER,4)));
		planes.add(new AirBusA320("9512ABZ", new GregorianCalendar(2015,Calendar.MAY,4)));

		//clientes	
		clients.add(new Client("12654658N","Pedro","Sanchez",new GregorianCalendar(1972,Calendar.MARCH,1),"Espa\u00f1ol"));
		clients.add(new Client("12345678Z","Maria","Perez",new GregorianCalendar(1990,Calendar.NOVEMBER,5),"Espa\u00f1ola"));
	
		//empleados
			//ceo
		CEO boss =new CEO("12654658N","Pedro","Ruiz",new GregorianCalendar(1999,Calendar.MAY,1),"Espa\u00f1ol",language,150000,4000);
			//tripulacion
	
		emps.add(new Crew("30568446C","Pedro","Ruiz",new GregorianCalendar(1990,Calendar.DECEMBER,1),"Espa\u00f1ol",language));
		emps.add(new Crew("12345678Z","Juan","Martinez",new GregorianCalendar(1972,Calendar.APRIL,1),"Espa\u00f1ol",language));
		emps.add(new Crew("80213581T","Juan","Perez",new GregorianCalendar(2000,Calendar.JANUARY,1),"Espa\u00f1ol",language));
		emps.add(new Crew("80215581E","Enrique","Ruiz",new GregorianCalendar(1980,Calendar.MARCH,1),"Espa\u00f1ol",language));
		emps.add(new Crew("80275581S","Ana","Sanchez",new GregorianCalendar(1972,Calendar.JUNE,1),"Espa\u00f1ol",language));
		emps.add(new Crew("10275581D","Susana","Ruiz",new GregorianCalendar(1972,Calendar.FEBRUARY,1),"Espa\u00f1ol",language));
			
			//pilotos
		emps.add(new Pilot("85275581E","Maria","Ruiz",new GregorianCalendar(1999,Calendar.MARCH,1),"Espa\u00f1ol",language,2000));
		emps.add(new Pilot("85775581W","Ana","Malicia",new GregorianCalendar(1985,Calendar.APRIL,1),"Espa\u00f1ol",language,15));
		emps.add(new Pilot("45775581S","Pedro","Color",new GregorianCalendar(1989,Calendar.FEBRUARY,1),"Espa\u00f1ol",language,500));
		emps.add(new Pilot("48775581X","Carlos","Espinosa",new GregorianCalendar(1995,Calendar.JANUARY,1),"Espa\u00f1ol",language,200));
		emps.add(new Pilot("48975581W","Maria","Martinez",new GregorianCalendar(1997,Calendar.MARCH,1),"Espa\u00f1ol",language,110));
		emps.add(new Pilot("98975581A","Elena","Oscura",new GregorianCalendar(1951,Calendar.SEPTEMBER,1),"Espa\u00f1ol",language,90));

			//compañia
		AirCompany iberia = new AirCompany("IBERIA",code,boss,new GregorianCalendar(1999,Calendar.FEBRUARY,1),
									  clients,tickets,emps,flights,planes,airports);
		
		//Agregacion vuelos y agregacion de empleados

		//cor_sev
		Flight  IBE1009SVQ = new Flight(iberia,iberia.listAirports().get(0),iberia.listAirports().get(1),planes.get(0),
						 new GregorianCalendar(2019,Calendar.MARCH,20,10,9),30,100);
		//sev_cor
		Flight  IBE1112CDR = new Flight(iberia,iberia.listAirports().get(1),iberia.listAirports().get(0),planes.get(1),
						 new GregorianCalendar(2019,Calendar.DECEMBER,20,11,12),30,100);
		//sev_cor
		Flight  IBE1400CDR = new Flight(iberia,iberia.listAirports().get(1),iberia.listAirports().get(0),planes.get(2),
						 new GregorianCalendar(2019,Calendar.MARCH,4,14,0),30,100);
		//bar_Mad
		Flight  IBE1600MAD = new Flight(iberia,iberia.listAirports().get(2),iberia.listAirports().get(3),planes.get(2),
						 new GregorianCalendar(2019,Calendar.MARCH,5,16,0),80,150);
		//sev_Mad
		Flight  IBE1900SVQ = new Flight(iberia,iberia.listAirports().get(0),iberia.listAirports().get(3),planes.get(3),
		new GregorianCalendar(2019,Calendar.JUNE,4,19,0),80,150);	



		//agregacion de empleados a los buelos
			//cor_sev
				//tripulacion	
		IBE1009SVQ.setCrew((Crew)iberia.listEmployees().get(0));
		IBE1009SVQ.setCrew((Crew)iberia.listEmployees().get(1));
		IBE1009SVQ.setCrew((Crew)iberia.listEmployees().get(2));
		IBE1009SVQ.setCrew((Crew)iberia.listEmployees().get(3));
		IBE1009SVQ.setCrew((Crew)iberia.listEmployees().get(4));
		IBE1009SVQ.setCrew((Crew)iberia.listEmployees().get(5));
			//pilotos
		IBE1009SVQ.setPilot((Pilot)iberia.listEmployees().get(6));
		IBE1009SVQ.setPilot((Pilot)iberia.listEmployees().get(7));
		   

		 //sev_cor
			//tripulacion
		IBE1112CDR.setCrew((Crew)iberia.listEmployees().get(0));
		IBE1112CDR.setCrew((Crew)iberia.listEmployees().get(1));
		IBE1112CDR.setCrew((Crew)iberia.listEmployees().get(2));
		IBE1112CDR.setCrew((Crew)iberia.listEmployees().get(3));
		IBE1112CDR.setCrew((Crew)iberia.listEmployees().get(4));
		IBE1112CDR.setCrew((Crew)iberia.listEmployees().get(5));	

			//pilotos	
		IBE1112CDR.setPilot((Pilot)iberia.listEmployees().get(8));
		IBE1112CDR.setPilot((Pilot)iberia.listEmployees().get(9));


		//sev_cor
			//tripulacion
		IBE1400CDR.setCrew((Crew)iberia.listEmployees().get(0));
		IBE1400CDR.setCrew((Crew)iberia.listEmployees().get(1));
		IBE1400CDR.setCrew((Crew)iberia.listEmployees().get(2));
		IBE1400CDR.setCrew((Crew)iberia.listEmployees().get(3));
		IBE1400CDR.setCrew((Crew)iberia.listEmployees().get(4));
		IBE1400CDR.setCrew((Crew)iberia.listEmployees().get(5));	

			//pilotos	
		IBE1400CDR.setPilot((Pilot)iberia.listEmployees().get(10));
		IBE1400CDR.setPilot((Pilot)iberia.listEmployees().get(11));


		//bar_Mad
			//tripulacion
		IBE1600MAD.setCrew((Crew)iberia.listEmployees().get(0));
		IBE1600MAD.setCrew((Crew)iberia.listEmployees().get(1));
		IBE1600MAD.setCrew((Crew)iberia.listEmployees().get(2));
		IBE1600MAD.setCrew((Crew)iberia.listEmployees().get(3));
		IBE1600MAD.setCrew((Crew)iberia.listEmployees().get(4));
		IBE1600MAD.setCrew((Crew)iberia.listEmployees().get(5));	

			//pilotos	
		IBE1600MAD.setPilot((Pilot)iberia.listEmployees().get(10));
		IBE1600MAD.setPilot((Pilot)iberia.listEmployees().get(11));

		//bar_Mad
			//tripulacion
		IBE1900SVQ.setCrew((Crew)iberia.listEmployees().get(0));
		IBE1900SVQ.setCrew((Crew)iberia.listEmployees().get(1));
		IBE1900SVQ.setCrew((Crew)iberia.listEmployees().get(2));
		IBE1900SVQ.setCrew((Crew)iberia.listEmployees().get(3));
		IBE1900SVQ.setCrew((Crew)iberia.listEmployees().get(4));
		IBE1900SVQ.setCrew((Crew)iberia.listEmployees().get(5));	

			//pilotos	
		IBE1900SVQ.setPilot((Pilot)iberia.listEmployees().get(10));
		IBE1900SVQ.setPilot((Pilot)iberia.listEmployees().get(11));



			
		// agregando vuelo a la compañia
		iberia.addFlight(IBE1009SVQ);
		iberia.addFlight(IBE1112CDR);
		iberia.addFlight(IBE1400CDR);
		iberia.addFlight(IBE1600MAD);
		iberia.addFlight(IBE1900SVQ);
		
	

		


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

		//iberia.fireEmployee("98975581A",12); //despide un empleado concreto.
		//iberia.removeFlight("IBE1009SVQ"); //borra un buelo concreto IBE1400CDR
		//iberia.removeFlight("IBE1400CDR");

		//lamada al menu
		System.out.println("Bienvenido.");
		Menu menu = Menu.getSingletonInstance(iberia);

		}catch(NullPointerException e){
			System.out.println("Error: "+e);
		}catch(Exception e){
			System.out.println("Error: "+e);
		}

	  }
   }

	