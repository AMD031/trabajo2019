import classes.*;
import java.util.GregorianCalendar;
import java.util.Calendar;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;
public class Main{
	public static void main(String[] args) {

		//(String idPlane, GregorianCalendar acquisitionDate)
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

		ArrayList<Client>clients = new ArrayList<Client>();
		ArrayList<Employee>emps = new ArrayList<Employee>();
		ArrayList<Ticket>tickets = new ArrayList<Ticket>();
		ArrayList<Flight>flights = new ArrayList<Flight>();
		ArrayList<Plane>planes = new ArrayList<Plane>();

	
		//(String idPlane, GregorianCalendar acquisitionDate)
		//aviones
		planes.add(new Boing787("1945ABC",new GregorianCalendar(2000,1,0)));
		planes.add(new Boing787("1264AZB",new GregorianCalendar(1975,2,12)));
		planes.add(new AirBusA320("1234ABZ", new GregorianCalendar(1995,6,4)));

		//empleados
		emps.add(new Crew("30568446C","Pedro","Ruiz",new GregorianCalendar(1999,1,1),"Español",idiomas));
		emps.add( new Crew("12345678Z","Juan","Ruiz",new GregorianCalendar(1972,1,1),"Español",idiomas));
		
		//clientes

		/*String dni, String name,String subName,
		  GregorianCalendar birthDate, String Natinality*/
		clients.add(new Client("30987544N","Pedro","Sanchez",new GregorianCalendar(1972,1,1),"Español"));
		clients.add(new Client("12345678Z","Maria","Perez",new GregorianCalendar(1990,8,5),"Española"));

		/*CEO(String DNI,String Name, String Subname,
	 GregorianCalendar Birthdate,
	 String Nationaly,ArrayList<String> Lenguages,int bonus ,int salary)*/

 	 /*String name, char[] charcode, 
     CEO ceo, GregorianCalendar foundationDate, ArrayList<Client> clients, ArrayList<Ticket>tickets,
	 ArrayList<Employee>employees, ArrayList<Flight>flights, ArrayList<Plane>planes*/
		
		CEO jefe =new CEO("30987544N","Pedro","Ruiz",new GregorianCalendar(1999,1,1),"Español",idiomas,150000,4000);
		AirCompany iberia = new AirCompany("IBERIA",code,jefe,new GregorianCalendar(1999,1,1),
									  clients,tickets,emps,flights,planes);
		
		jefe = null;
		clients.clear(); 
		emps.clear();  
		tickets.clear(); 
		flights.clear();  
		planes.clear();  

	

		mainMenu(iberia);



		}catch(InputMismatchException e){
			System.out.println("Opcion no valida");

		}catch(NullPointerException e){

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
	 				

	 			break;

	 			case '2':
	 				

	 			break;

	 			case '3':
	 				

	 			break;

	 			case '4':
	 				System.out.println("la lista de vuelos son: ");
	 					for (Flight f: comp.listFlight()){
	 						System.out.println(f);
	 					    System.out.println("\n");
	 					    Thread.sleep(750);
	 					}
	 				printMainOptions();

	 			break;

	 			case '5':
	 				System.out.println("La lista de empleados son: ");
	 					for (Employee e: comp.listEmployees()) {
	 						System.out.println(e);
	 					    System.out.println("\n");
	 					    Thread.sleep(750);
	 					}
	 				printMainOptions();
	 			break;

	 			case '6':
	 				System.out.println("La lista de clientes son: ");
	 					for (Client c: comp.listClients()) {
	 						System.out.println(c+"\n");
	 						Thread.sleep(750);
	 					}
	 				printMainOptions();
	 			break;

	 			case '7':
	 				System.out.println("La lista de aviones son: ");
	 					for (Plane p: comp.listPlanes()) {
	 						System.out.println(p+"\n");
	 						Thread.sleep(750);
	 					}
	 				printMainOptions();
	 			break;

	 			case '8':
	 				System.out.println("Los salarios totales son: ");
	 				int total =0;
	 				for (Employee e :comp.listEmployees() ) {
	 					total += e.calculateSalary();

	 				}
	 				total+=comp.getCeo().calculateSalary();
	 				System.out.println("El total es "+total);
	 			break;

	 			case '9':
	 				

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