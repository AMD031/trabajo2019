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
			language.add("Ingles");
			language.add("Portuges");
			language.add("Español");
			language.add("Fraces");

			//idiomas de la empresa
			ArrayList<String>lc = new ArrayList<String>();
			lc.add("Ingles");
			lc.add("Frances");
			lc.add("Portuges");
			lc.add("Español");

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
		airports.add(new Airport("SVQ","bar","Sevilla","España", servicios));
		airports.add(new Airport("CDR","vez","Cordoba","España", servicios));

		//aviones
		planes.add(new Boing787("1945ABC",new GregorianCalendar(2000,1,0)));
		planes.add(new Boing787("1264AZB",new GregorianCalendar(1975,2,12)));
		planes.add(new AirBusA320("1234ABZ", new GregorianCalendar(1995,6,4)));

		//clientes	
		clients.add(new Client("12654658N","Pedro","Sanchez",new GregorianCalendar(1972,1,1),"Español"));
		clients.add(new Client("12345678Z","Maria","Perez",new GregorianCalendar(1990,8,5),"Española"));
	
		//empleados
			//ceo
		CEO boss =new CEO("12654658N","Pedro","Ruiz",new GregorianCalendar(1999,1,1),"Español",language,150000,4000);
			//tripulacion
	
		emps.add(new Crew("30568446C","Pedro","Ruiz",new GregorianCalendar(1999,1,1),"Español",language));
		emps.add( new Crew("12345678Z","Juan","Ruiz",new GregorianCalendar(1972,1,1),"Español",language));
			
			//pilotos
		emps.add(new Pilot("87654321X","Maria","Ruiz",new GregorianCalendar(1999,1,1),"Español",language,80));
		emps.add(new Pilot("30851231C","Juan","Ruiz",new GregorianCalendar(1980,1,1),"Español",language,80));

			//compañia
		AirCompany iberia = new AirCompany("IBERIA",code,boss,new GregorianCalendar(1999,1,1),
									  clients,tickets,emps,flights,planes,airports);
		
		//Agregacion vuelos y agregacion de empleados
		Flight  IB1009SVQ = new Flight(iberia,iberia.listAirports().get(0),iberia.listAirports().get(1),planes.get(0),
						 new GregorianCalendar(2019,3,20,10,9),80,100);
		
		Flight  IB1109CDR = new Flight(iberia,iberia.listAirports().get(1),iberia.listAirports().get(0),planes.get(1),
						 new GregorianCalendar(2019,3,20,11,9),80,100);

		Flight  IB1400CDR = new Flight(iberia,iberia.listAirports().get(1),iberia.listAirports().get(0),planes.get(2),
						 new GregorianCalendar(2019,3,20,14,0),80,100);
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
		  	try{
				System.out.println("Bienvenido.");
				System.out.println("Escribe un numero para elegir una opcion.");
				mainMenu(iberia);
				System.out.println("Adios, gracias por usar nuestras aerolineas.");
			}catch(InputMismatchException e){
				System.out.println("No se puede introducir letras.");
				mainMenu(iberia);
			}catch(Exception e){
			    System.out.println(e);
			}


		}catch(NullPointerException e){
			System.out.println("Error: "+e);
		}catch(Exception e){
			System.out.println("Error: "+e);
		}

	}

	static void mainMenu(AirCompany comp){
	 System.out.println("hoy es: "+ new GregorianCalendar().getTime()+"\n");
	 Scanner sc = new Scanner(System.in);
	 int op=0;
	 int op2 =1;
	 int op3 =1;
	 String dni;
	 String id;
	 boolean flightfound = false;
	 printMainOptions();
	    do{

	    	op = sc.nextInt();
	 		switch(op){
	 			case 1:
	 			 do{
	 				System.out.println("Intruduzca aeropuerto destino, por favor.");
	 				String o= sc.next();
	 			 	System.out.println("Intruduzca aeropuerto origen, por favor.");
	 			    String d= sc.next();
	 			    sc.nextLine();
	 			    do{
		 				if(comp.searchFlight(o,d).size()>0){
		 				  for(Flight f:comp.searchFlight(o,d)){
		 				   System.out.println((comp.searchFlight(o,d).indexOf(f)+1)+") "+f);
		 				  }
		 				  flightfound = true;
			 			}else{
			 				System.out.println("Vuelo no encontrado.");
			 			}	

		 				System.out.println("Seleccione el vuelo deseadoo vuelva atr\u00e1s (0).");
		 				//numero de vuelo
		 				op2 = sc.nextInt();

	                   if(op2>0 && flightfound){
	   					
		 				int NFlight = (op2-1);
		 			
		 				Flight sFlight = comp.searchFlight(o,d).get(NFlight);
		 				ArrayList<Seat>tmpSeats = sFlight.getSeatsFlight();

		 				// se imprime los asientos
		 				for(Seat s : tmpSeats){
		 					if(!s.getReserved()){
		 					  System.out.printf("%-20s",(tmpSeats.indexOf(s)+1)+") "+s);
		 					}
		 				}
		 				
		 				System.out.println("Selecione un asiento.");
		 				//selecion de asiento 

		 				op3 = sc.nextInt();
		 				if(op3>0){
		 					 int nSeat = (op3-1); 
			 				System.out.print("\nHas selecionado el asiento: ");
			 				Seat tmpSeat = tmpSeats.get(op3);
			 				System.out.print(tmpSeat);
			 				//datos de cliente

			 				System.out.println("\nIntroduce tu dni para proceder a la compra.");
			 				 do{
			 				 	dni = sc.next();
			 				 	if(!Person.checkDni(dni)){
			 				 		System.out.println("Dni no valido. Introducelo otra vez.");
			 				 	}	
			 				 }while(!Person.checkDni(dni));
			 					if(comp.searchClient(dni)!=null){
				 					Client tmpClient = comp.searchClient(dni);
				 					Ticket t = new Ticket(tmpClient,tmpSeat,sFlight);
				 					if(comp.buyTicket(t)){
				 						System.out.println("Compra realizada con existo.");
				 						System.out.println(t);
				 						op3 = 0;
				 						op2 = 0;
				 					}	
			 					}else{
			 						try{
			 							//datos para crear usuario
				 						System.out.println("Su dni no se encuentra registrado.");
				 						System.out.println("Introduzca su nombre.");
				 						String name = sc.next();
				 						System.out.println("Introduzca su apellido.");
				 						String subName= sc.next();
				 						System.out.println("Datos de la fecha de nacimento.");
				 						System.out.println("Introduzca agno.");
				 						int year = sc.nextInt();
				 						System.out.println("Introduzca mes.");
				 						int month = sc.nextInt();
				 						System.out.println("Introduzca dia.");
				 						int day = sc.nextInt();
				 						System.out.println("Introduzca su nacionalidad.");
				 						String natinality= sc.next();

				 						GregorianCalendar Birth = new GregorianCalendar(year,month,day);
				 						Client newClient = new Client(dni,name,subName,Birth,natinality);
			 						if(comp.addClient(newClient)){
					 						Ticket t = new Ticket(newClient,tmpSeat,sFlight);
					 						if(comp.buyTicket(t)){
						 						System.out.println("Compra realizada con existo.");
						 						System.out.println(t);
						 						op3 = 0;
						 						op2 = 0;
						 					}
					 					}

					 					System.out.println("Escribe cero para salir o otro numero si desea hacer otra compra.");
				 						op2 = sc.nextInt();
					 				}catch(InputMismatchException e){
					 					System.out.println(e);
					 				}catch(Exception e){
					 					System.out.print(e);
					 				}	
			 					}
				 				
			 			   	}
		 				 }
		 				
	 			  }while(op2!=0);
 				}while(op3!=0);
 				
	 				System.out.println("\n");
	 				printMainOptions();
	 			break;

	 			case 2:
	 				System.out.println("Introduce id");
	 				id = sc.next();
	 				System.out.println("Introduce dni");
	 				dni = sc.next();
	 				sc.nextLine();

	 				if(comp.searchTicket(dni,id)!=null){
	 					System.out.println(comp.searchTicket(dni,id));
	 				}else{
	 					System.out.println("Ticket no encontrado");
	 				}
	 				
	 				printMainOptions();
	 			break;

	 			case 3:
	 				System.out.println("Introduce id");
	 				id = sc.next();
	 				System.out.println("Introduce dni");
	 				dni = sc.next();
	 				sc.nextLine();
	 				if(comp.removeTicket(dni,id)){
	 					System.out.println("El Ticket se ha borrado con existo.");
	 				}else{

	 					System.out.println("El Ticket no se ha borrado.");
	 				}


	 				
	 				printMainOptions();
	 			break;

	 			case 4:
	 				System.out.println("la lista de vuelos son: ");
	 					for (Flight f: comp.listFlight()){
	 						System.out.println(f);
	 					}	
					System.out.println("\nEscribe un caracter y pulsa una tecla para continuar.");
					sc.next();
	 				printMainOptions();

	 			break;

	 			case 5:
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

	 			case 6:
	 				System.out.println("La lista de clientes son: ");
	 					for (Client cli: comp.listClients()) {
	 						System.out.println(cli+"\n");
	 					    System.out.println("\nEscribe un caracter y pulsa una tecla para continuar.");
	 					    sc.next();

	 					}
	 				printMainOptions();
	 			break;

	 			case 7:
	 				System.out.println("La lista de aviones son: ");
	 					for (Plane p: comp.listPlanes()) {
	 						System.out.println(p+"\n");
	 						    System.out.println("\nEscribe un caracter y pulsa una tecla para continuar.");
	 					    sc.next();
	 					}
	 				printMainOptions();
	 			break;

	 			case 8:
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

	 			case 9:
	 			    System.out.println("Introduce un codigo de vuelo");
	 			    String code = sc.next();
	 			    Flight tmp = comp.searchFlight(code);
	 			    System.out.println("La rentabiladad del vuelo es: "+tmp.calculateProfitability());
	 				printMainOptions();
	 			break;
	 		}

	 	}while(op!=0);
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

	static double checkPrice(Seat s, Flight f){
		double price = 0;
		if(s.getVip()){
		  price = f.getPrice()*1.20;
		}else{
			price = f.getPrice();
		}
		return price;
	}
}