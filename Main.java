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
			ArrayList<String>idiomas = new ArrayList<String>();
			idiomas.add("Ingles");
			idiomas.add("Portuges");
			idiomas.add("Español");
			idiomas.add("Fraces");

			//idiomas de la empresa
			ArrayList<String>ic = new ArrayList<String>();
			ic.add("Ingles");
			ic.add("Frances");
			ic.add("Portuges");
			ic.add("Español");

	 	Employee.setLenguagesCompany(ic);
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
		airports.add(new Airport("SVQ","bar","Sevilla","España", servicios));
		airports.add(new Airport("CDR","vez","Cordoba","España", servicios));

		//aviones
		planes.add(new Boing787("1945ABC",new GregorianCalendar(2000,1,0)));
		planes.add(new Boing787("1264AZB",new GregorianCalendar(1975,2,12)));
		planes.add(new AirBusA320("1234ABZ", new GregorianCalendar(1995,6,4)));

		//clientes	
		clients.add(new Client("30987544N","Pedro","Sanchez",new GregorianCalendar(1972,1,1),"Español"));
		clients.add(new Client("12345678Z","Maria","Perez",new GregorianCalendar(1990,8,5),"Española"));
	
		//empleados
			//ceo
		CEO jefe =new CEO("30987544N","Pedro","Ruiz",new GregorianCalendar(1999,1,1),"Español",idiomas,150000,4000);
			//tripulacion
	
		emps.add(new Crew("30568446C","Pedro","Ruiz",new GregorianCalendar(1999,1,1),"Español",idiomas));
		emps.add( new Crew("12345678Z","Juan","Ruiz",new GregorianCalendar(1972,1,1),"Español",idiomas));
			
			//pilotos
		emps.add(new Pilot("87654321X","Maria","Ruiz",new GregorianCalendar(1999,1,1),"Español",idiomas,80));
		emps.add(new Pilot("30851231C","Juan","Ruiz",new GregorianCalendar(1980,1,1),"Español",idiomas,80));

			//compañia
		AirCompany iberia = new AirCompany("IBERIA",code,jefe,new GregorianCalendar(1999,1,1),
									  clients,tickets,emps,flights,planes,airports);
		
		//Agregacion vuelos y agregacion de empleados
		Flight  IB1009SVQ = new Flight(iberia,iberia.listAirports().get(0),iberia.listAirports().get(1),planes.get(0),
						 new GregorianCalendar(2019,3,20,10,9),80,100);
		Flight  IB1009SVQ2 = new Flight(iberia,iberia.listAirports().get(1),iberia.listAirports().get(0),planes.get(0),
						 new GregorianCalendar(2019,3,20,11,9),80,100);
		IB1009SVQ.setCrew((Crew)iberia.listEmployees().get(0));
		IB1009SVQ.setPilot((Pilot)iberia.listEmployees().get(2));

		iberia.addFlight(IB1009SVQ);
		iberia.addFlight(IB1009SVQ2);

		//eliminacion de listas despues de agregarlas a la compañia.
		jefe = null;
		clients.clear(); 
		emps.clear();  
		tickets.clear(); 
		flights.clear();  
		planes.clear();
		airports.clear(); 

		mainMenu(iberia);


		}catch(InputMismatchException e){
			System.out.println("No se puede introducir letras.");

		}catch(NullPointerException e){
			System.out.println("Error: "+e);
		}catch(Exception e){
			System.out.println("Error: "+e);
		}

	}




	static void mainMenu(AirCompany comp) throws Exception{

	 Scanner sc = new Scanner(System.in);
	 char op;
	 printMainOptions();
	    do{
	       op = sc.next().charAt(0);
	 		switch(op){

	 			case '1':
	 				System.out.println("Intruduzca aeropuerto destino, por favor.");
	 				String o= sc.next();
	 			 	System.out.println("Intruduzca aeropuerto origen, por favor.");
	 			    String d= sc.next();
	 				sc.nextLine();
	 				System.out.println(comp.serachFlight(o,d));
	 				printMainOptions();
	 			break;

	 			case '2':
	 				
	 				printMainOptions();
	 			break;

	 			case '3':
	 				
	 				printMainOptions();
	 			break;

	 			case '4':
	 				System.out.println("la lista de vuelos son: ");
	 					for (Flight f: comp.listFlight()){
	 						System.out.println(f);
	 					}	
					System.out.println("\nEscribe un caracter y pulsa una tecla para continuar.");
					sc.next();
	 				printMainOptions();

	 			break;

	 			case '5':
	 				System.out.println("La lista de empleados son: ");
	 					for (Employee e: comp.listEmployees()) {
	 						System.out.println("\nTripulacion: ");
	 						if(  e instanceof Crew){
		 						System.out.println(e);
		 					    System.out.println("\nEscribe un caracter y pulsa una tecla para continuar.");
		 					    sc.next();
	 					    }
	 					}
	 					System.out.println("\nPiloto: ");
	 					for (Employee e: comp.listEmployees()) {
	 						if(  e instanceof Pilot){
		 						System.out.println(e);
		 					    System.out.println("\nEscribe un caracter y pulsa una tecla para continuar.");
		 					    sc.next();
		 					 }
	 					}



	 				printMainOptions();
	 			break;

	 			case '6':
	 				System.out.println("La lista de clientes son: ");
	 					for (Client c: comp.listClients()) {
	 						System.out.println(c+"\n");
	 					    System.out.println("\nEscribe un caracter y pulsa una tecla para continuar.");
	 					    sc.next();

	 					}
	 				printMainOptions();
	 			break;

	 			case '7':
	 				System.out.println("La lista de aviones son: ");
	 					for (Plane p: comp.listPlanes()) {
	 						System.out.println(p+"\n");
	 						    System.out.println("\nEscribe un caracter y pulsa una tecla para continuar.");
	 					    sc.next();
	 					}
	 				printMainOptions();
	 			break;

	 			case '8':
	 				System.out.println("Los salarios totales son: ");
	 				double totalCrew =0;
	 				double totalPilot =0;
	 				System.out.println("");
	 				for (Employee e :comp.listEmployees() ) {
	 				  if( e instanceof Crew){	
	 					totalCrew += e.calculateSalary();
	 					}	
	 				   if( e instanceof Pilot){	
	 					 totalPilot += e.calculateSalary();
	 					}
	 					
	 				}
	 				double totalCeo =comp.getCeo().calculateSalary();
	 				System.out.println("El salario anual del CEO es: "+totalCeo);
	 				System.out.println("El total de la tripulacion es: "+totalCrew);
	 				System.out.println("El salario de los piltos es: "+totalPilot);
	 				System.out.println("La suma de todos los salarios anuales es: "
	 				+(totalPilot+totalCrew+totalCeo)+"\n");
	 				printMainOptions();
	 			break;

	 			case '9':
	 				
	 				printMainOptions();
	 			break;

	 			default:
	 			 	System.out.println("Adios");
	 			break;

	 			
	 		
	 		}

	 	}while(op!='0');
	}





	static void printMainOptions(){
		System.out.println("1 Buscar Vuelo");
		System.out.println("2 Consultar Billete");
		System.out.println("3 Eliminar Billete");
		System.out.println("4 Listar Vuelos ");
		System.out.println("5 Listar Empleados ");
		System.out.println("6 Listar Clientes ");
		System.out.println("7 Listar Flota");
		System.out.println("8 Calcular Salarios total ");
		System.out.println("9 Calcular la rentabilidad de un vuelo ");
		System.out.println("0 Salir");
	}


}