package interfaces;
import java.util.ArrayList;
import classes.*;

public interface IAirCompany{
	public boolean hireEmployee(Employee e)throws Exception;
	public boolean fireEmployee(String dni, int NEmployee);
	public ArrayList<Employee>listEmployees();
	public Employee searchEMployee(String name,String dni, int NEmployee);
	public double totalSalary();
	public boolean addPlane(Plane p)throws Exception;
	public ArrayList<Plane>listPlanes();
	public boolean removePlane(String idPlane);
	public Plane searchPlane(String idPlane);
	public boolean addFlight(Flight f)throws Exception;
	public ArrayList<Flight> listFlight();
	public ArrayList<Flight> searchFlight(String destinationAirport
	, String originAirport);
	public boolean removeFlight(String code);
	public boolean buyTicket(Ticket t);
	public boolean removeTicket(String dni, String id);
	public Ticket searchTicket(String dni, String id);
	public boolean addClient(Client client)throws Exception;
	public ArrayList<Client> listClients();
	public Client searchClient(String dni);
	public boolean removeClient(String dni);	
}