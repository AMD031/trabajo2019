package interfaces;
import java.util.ArrayList;
import classes.*;

public interface IAirCompany{
	public boolean hireEmployee(Employee e);
	public boolean fireEmployee(String dni, String NEmployee);
	public ArrayList<Employee>listEmployee();
	public boolean searchEMployee(String name,String dni, String NEmployee);
	public double totalSalary();
	public boolean addPlane(Plane p);
	public ArrayList<Plane>listPlane();
	public boolean removePlane(String idPlane);
	public Plane searchPlane(String idPlane);
	public boolean addFlight(Flight f);
	public ArrayList<Flight> listFlight();
	public boolean serachFlight(String destinationAirpor
	, String originAirport);
	public boolean removeFlight(String code);
	public boolean buyTicket(String codeFlight);
	public boolean removeTicket();
	public Ticket searchTicket(String dni, String id);
	public boolean addClient(Client client);
	public ArrayList<Client> listClient();
	public Client searchClient(String dni);
	public boolean removeClient(String dni);	
}