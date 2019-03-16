
import classes.*;
import java.util.GregorianCalendar;
import java.util.Calendar;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Collections;
/**
Clase encargada de generar un menú 
para gestionar la aerolinea.
*/
public class Menu{
	private AirCompany comp;
	private static Menu menu;

	private Menu(AirCompany comp ){
		this.comp =comp;
		this.mainMenu(this.comp);
	}	

public static Menu getSingletonInstance(AirCompany comp) {
        if (Menu.menu == null){
            Menu.menu = new Menu(comp);
        }
        return Menu.menu;
    }
	/**	
	Método que permite interatuar con las diferentes opciones del menú principal.
	@param comp Objeto de tipo AirCompany que se usa para extraer los datos necesarios de la 
	compañia a lo largo de la gestión del programa.
	*/
	public void mainMenu(AirCompany comp){
	 System.out.println("hoy es: "+ new GregorianCalendar().getTime()+"\n");
	 Scanner sc = new Scanner(System.in);
	 int op=0;
	 System.out.println("Escribe un numero para elegir una opcion.");
	 printMainOptions();
		try{
	  	  do{
	    	op = sc.nextInt();
	 		switch(op){
	 			case 1:
	 				this.searchFlightSeat(sc);
	 			break;

	 			case 2:
	 				this.checkTicketSelected(sc);
	 			break;
					
	 			case 3:
	 			   this.removeTicketSelected(sc);
	 			break;

	 			case 4:
	 				this.printFlights(sc);
	 			break;

	 			case 5:
	 				this.printEmployee(sc);
	 			break;

	 			case 6:
	 			   this.printClients(sc);
	 			break;

	 			case 7:
	 			   this.printPlanes(sc);
	 			break;

	 			case 8:
	 				this.printAiports(sc);
	 			break;

	 			case 9:
	 			  this.salariesEmployees();
	 			break;

	 			case 10:
	 			  this.printProfitability(sc);
	 			break;
	 			default:
	 			 this.printMainOptions();
	 			break;
	 		}
	 	}while(op!=0);

	 	System.out.println("Adi\u00f3s, gracias por usar nuestras aerol\u00edneas.");
		}catch(InputMismatchException e){
			System.out.println("Acci\u00f3n no valida.");
			this.mainMenu(this.comp);
		}catch(Exception e){
		    System.out.println(e);
		}
	 	
	}
	/**
	Método que permite buscar vuelo, listar su asientos y proceder a la compra del billete.
	@param sc se usa para pedir los diferentes datos que se usaran en la compra del billete.
	*/
	private void searchFlightSeat(Scanner sc){
		 int op=0;
		 int op2 =1;
		 int op3 =1;
		 String o ="";
		 String d="";
		 String dni="";
		 String id="";
		 String letter="";
		 boolean flightfound = false;

	   try{
	 	do{	
	 		ArrayList<Airport>airports = comp.listAirports();
	 		System.out.println("Lista de aeropuertos");
	 		if(airports.size()>0){
	 			for (Airport a :airports){
	 				if(a!=null){
	 					System.out.println(a.getName());
	 				}

	 			}
	 		}
			System.out.println("\nIntruduzca aeropuerto destino, por favor.");
			o= sc.next();
		 	System.out.println("Intruduzca aeropuerto origen, por favor.");
		    d= sc.next();
		    sc.nextLine();
		  
		    do{
		    	//op3 = 1;
		    	flightfound = false;
				if(this.comp.searchFlight(o,d).size()>0){
				  //se imprime los vuelos	
				  for(Flight f:this.comp.searchFlight(o,d)){
				    System.out.println("\n "+(this.comp.searchFlight(o,d).indexOf(f)+1)+")"+f);
				  }
				  flightfound = true;//flag de vuelo vuelo encontrado
				}else{
					System.out.println("Vuelo no encontrado.");
				}
				  do{
					System.out.println("\n\nSeleccione el vuelo deseado vuelva atr\u00e1s (0).");
					//numero de vuelo
					op2 = sc.nextInt();

					if(op2>this.comp.searchFlight(o,d).size()){
						System.out.println("Opncion no valida");
					}
				  }while(op2>0 && op2>this.comp.searchFlight(o,d).size());	

	       if(op2>0 && flightfound){
				int NFlight = (op2-1);
			
				Flight sFlight = this.comp.searchFlight(o,d).get(NFlight);
				ArrayList<Seat>tmpSeats = sFlight.getSeatsFlight();

				// se imprime los asientos
				int contLine =0;
				int cont =1;
				sc.nextLine();
				Collections.sort(tmpSeats);
				for(Seat s : tmpSeats){

					if(!s.getReserved()){
					  System.out.printf("%-30s",(tmpSeats.indexOf(s)+1)+")"+s+" ("+checkPrice(s,sFlight)+"$"+")");
				
					}
					if(contLine%4==0){
					   System.out.println("");
					   contLine=1;
					}
					if(cont%49==0){
						System.out.println("\nPulsa intro para continuar.");
						letter=sc.nextLine();
						if(letter.isEmpty()){}

					}
					cont++;
					contLine++;
				}
				do{
			    System.out.println("\n\nSeleccione el asiento deseado vuelva atr\u00e1s (0).");
				//selecion de asiento 
				op3 = sc.nextInt();

				if(op3>tmpSeats.size()){
					  System.out.println("Opncion no valida");
					}
				}while(op3>0 && op3>tmpSeats.size());	
				
				if(op3>0){
					 int nSeat = (op3-1); 

					System.out.print("\nHas selecionado el asiento: ");
					Seat tmpSeat = tmpSeats.get(op3-1);
					System.out.println(tmpSeat);
					 if(tmpSeat.getReserved()) {
						 System.out.println("Asiento ocupado");
					 }
					
					//datos de cliente
					 if(!tmpSeat.getReserved()){
						System.out.println("\nIntroduce tu dni para proceder a la compra.");
				
						 do{
						 	dni = sc.next();
						 	if(!Person.checkDni(dni)){
						 		System.out.println("Dni no valido. Introducelo otra vez.");
						 	}	
						 }while(!Person.checkDni(dni));

							if(this.comp.searchClient(dni)!=null){
		 					Client tmpClient = this.comp.searchClient(dni);
		 					Ticket t = new Ticket(tmpClient,tmpSeat,sFlight);
		 					if(this.comp.buyTicket(t)){
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
		 						System.out.println("Introduzca a\u00f1o.");
		 						int year = sc.nextInt();
		 						System.out.println("Introduzca mes.");
		 						int month = sc.nextInt();
		 						System.out.println("Introduzca dia.");
		 						int day = sc.nextInt();
		 						System.out.println("Introduzca su nacionalidad.");
		 						String natinality= sc.next();

		 						GregorianCalendar Birth = new GregorianCalendar(year,month,day);
		 						Client newClient = new Client(dni,name,subName,Birth,natinality);
								if(this.comp.addClient(newClient)){
			 						Ticket t = new Ticket(newClient,tmpSeat,sFlight);
			 						if(this.comp.buyTicket(t)){
				 						System.out.println("Compra realizada con existo.");
				 						System.out.println(t);
				 						op3 = 0;
				 						op2 = 0;
				 					}
			 					}
			 					System.out.println("Escribe cero para salir y pulsa intro.");
		 						op2 = sc.nextInt();
			 				}catch(InputMismatchException e){
			 					System.out.println(e);
			 				}catch(Exception e){
			 					System.out.print(e);
			 				}	
						   }

						}
	 				
				   	}
				 }
			
			  }while(op2!=0);
		}while(op3!=0);	
	}catch(InputMismatchException e){
		System.out.print("Dato introducido no valido");
	}catch(Exception e){
		System.out.println("Error "+e);
	}
		System.out.println("\n");
		printMainOptions();
	}
	/**
	Imprime la lista de opciones del menu principal.	
	*/
	private void printMainOptions(){
		System.out.println("1 Buscar Vuelo");
		System.out.println("2 Consultar Billete");
		System.out.println("3 Eliminar Billete");
		System.out.println("4 Listar Vuelos ");
		System.out.println("5 Listar Empleados (alpha)");
		System.out.println("6 Listar Clientes (alpha) ");
		System.out.println("7 Listar Flota (alpha)");
		System.out.println("8 Listar Aeropuertos");
		System.out.println("9 Calcular Salarios total (alpha)");
		System.out.println("10 Calcular la rentabilidad de un vuelo (alpha)");
		System.out.println("0 Salir");
	}

	/**
		Busca un ticket en el ArrayList tickets de la clase AirCompany que coincida con el dni
		del cliente y el id del vuelo y si lo encuentra lo imprime
		@param sc se usa para pedir el dni y el id del vuelo a buscar. 
	*/
	private void checkTicketSelected(Scanner sc){
		System.out.println("Introduce id");
		String id = sc.next();
		System.out.println("Introduce dni");
		String dni = sc.next();
		sc.nextLine();
		if(this.comp.searchTicket(dni,id)!=null){
			System.out.println(this.comp.searchTicket(dni,id));
		}else{
			System.out.println("Ticket no encontrado");
		}
		printMainOptions();
	}
	/**
	Metodo que borra un ticke que consida con el id del vuelo y el dni del cliente
	@param sc recibe un objeto de tipo Scanner que se usa para pedir el dni y el id por
	teclado.
	*/
	private void removeTicketSelected(Scanner sc){
		System.out.println("Introduce id");
		String id = sc.next();
		System.out.println("Introduce dni");
		String dni = sc.next();
		sc.nextLine();
		if(this.comp.removeTicket(dni,id)){
			System.out.println("El Ticket se ha borrado con existo.");
		}else{
			System.out.println("El Ticket no se ha borrado.");
		}
		printMainOptions();
	}
	/**
	Imprime la lista de vuelos.
	@param sc recibe un objeto de tipo Scanner que se usa para volver al menú principal
	una vez finalizada la imprecion pidiendo que pulse intro.
	*/
	private void printFlights(Scanner sc){
		String letter=sc.nextLine();
		if(this.comp.listFlight().size()>0){
			System.out.println("la lista de vuelos son: ");
			for (Flight f: this.comp.listFlight()){
				System.out.println("\n"+f);
			}	
			System.out.println("\nPulsa intro para continuar.");		
			letter=sc.nextLine();
			if(letter.isEmpty()){
				System.out.println("");
			}
		}
		printMainOptions();
	}
	/**
	imprime la lista de empleados de la empresa.
	@param sc recibe un objeto de tipo Scanner que se usa para volver al menú principal
	una vez finalizada la imprecion pidiendo que pulse intro.
	*/
	private void printEmployee(Scanner sc){
	    	String letter=sc.nextLine();
	    	 if(this.comp.listEmployees().size()>0){
 				System.out.println("La lista de empleados son: ");
				for (Employee e: this.comp.listEmployees()) {
					
					if(  e instanceof Crew){
						System.out.println("\nTripulacion: ");
						System.out.println(e);
					    System.out.println("\nPulsa intro para continuar.");
					
					letter=sc.nextLine();
					if(letter.isEmpty()){
						System.out.println("");
						}
				    }
				}
			
				for (Employee e: this.comp.listEmployees()) {
					if(  e instanceof Pilot){
						System.out.println("\nPiloto: ");
						System.out.println(e);
					    System.out.println("\nPulsa intro para continuar.");
					 
					letter=sc.nextLine();
					if(letter.isEmpty()){
						System.out.println("");
					}
				  }
				}
			 }	
 		   printMainOptions();	
		}


		/**
		Imprime la lista de clientes de la empresa.	
		@param sc recibe un objeto de tipo Scanner que se usa para volver al menú principal
		una vez finalizada la imprecion pidiendo que pulse intro.
		*/
		private void printClients(Scanner sc){
			String letter=sc.nextLine();
				if(this.comp.listClients().size()>0){
					System.out.println("La lista de clientes son: ");
						for (Client cli: this.comp.listClients()) {	
							System.out.println(cli+"\n");
						    System.out.println("\nPulsa intro para continuar.");
						   	letter=sc.nextLine();
						if(letter.isEmpty()){
							System.out.println("");
						}

					}
				}
		 	printMainOptions();
		}

		/**
		Imprime todos los aviones con sus datos.
		@param sc recibe un objeto de tipo Scanner que se usa para volver al menú principal
		una vez finalizada la imprecion pidiendo que pulse intro.
		*/
		private void printPlanes(Scanner sc){
			String letter=sc.nextLine();
			 if(this.comp.listPlanes().size()>0){
				System.out.println("La lista de aviones son: ");
					for (Plane p: this.comp.listPlanes()) {
						System.out.println(p+"\n");
						System.out.println("\nPulsa intro para continuar.");
					   	letter=sc.nextLine();
					if(letter.isEmpty()){
						System.out.println("");
					}
				 }
			  } 
				printMainOptions();
		}

		/**
		@param sc recibe un objeto de tipo Scanner que se usa para volver al menú principal
		una vez finalizada la imprecion pidiendo que pulse intro.*/

		private void printAiports(Scanner sc){
			String letter=sc.nextLine();
			if(this.comp.listAirports().size()>0){
				for(Airport a :this.comp.listAirports()){
					System.out.println(a);
				}
				System.out.println("\nPulsa intro para continuar.");
			   	letter=sc.nextLine();
				if(letter.isEmpty()){
					System.out.println("");
				}
			}
		  printMainOptions();	
		}

		/**
		  Imprime el salario anual de todos los empleados.
		*/
		
	     private void salariesEmployees(){
	   		 System.out.println("Los salarios totales son: ");
	 				double totalCrew =0;
	 				double totalPilot =0;
	 				System.out.println("");
	 				if(this.comp.listEmployees().size()>0){
		 				for (Employee e :this.comp.listEmployees() ) {
		 				  if( e instanceof Crew){	
		 					totalCrew += e.calculateSalary();
		 					}	
		 				   if( e instanceof Pilot){	
		 					 totalPilot += e.calculateSalary();
		 					}
		 					
		 				}
	 				}	
	 				double totalCeo =this.comp.getCeo().calculateSalary();
	 				System.out.println("El salario anual del CEO es: "+totalCeo);
	 				System.out.println("El total de la tripulacion es: "+totalCrew);
	 				System.out.println("El salario de los piltos es: "+totalPilot);
	 				System.out.println("La suma de todos los salarios anuales es: "
	 				+(totalPilot+totalCrew+totalCeo)+"\n");
	 				printMainOptions();
	   		}
	   /**		
		Imprime la rentabilidad de un vuelo.
		@param sc recibe un objeto de tipo Scanner que se usa para pedir los datos del vuelo y volver al 
		menu una vez finalizada la impresión.
		*/
	   private void printProfitability(Scanner sc){
	   	  System.out.println("Introduce un codigo de vuelo");
		  String code = sc.next();
		  	if(this.comp.searchFlight(code)!=null){
			  Flight tmp = this.comp.searchFlight(code);
			  System.out.println("La rentabiladad del vuelo es: "+tmp.calculateProfitability());
			}else{
				System.out.println("Vuelo no encontrado.");
			}
		  printMainOptions();
	   }
	/**
	  Método auxiliar que calcula precio final de un billete en función de si es vip o no.		
	 @param s objeto de tipo Seat del que se extra si es vip a partir del
	 método getVip().
	 @param f objeto de tipo Flight del que se extrae el precio base
	 @return devuelve el precio final

	*/
	private double checkPrice(Seat s, Flight f){
		double price = 0;
		if(s.getVip()){
		  price = f.getPrice()*1.20;
		}else{
			price = f.getPrice();
		}
		return price;
	}

}	












