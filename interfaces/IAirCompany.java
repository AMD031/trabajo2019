package interfaces;

public interface IAirCompany{
	public boolean hireEmployee(Employee e);
	public boolean fireEmployee(String dni, String NEmployee);
	public void listEmployee();
	public boolean searchEMployee(String name,String dni, String NEmployee);
	public double totalSalary();
	public boolean addPlane(Plane p);
	public void listPlane();
	public boolean removePlane(String idPlane);
	public boolean searchPlane(String idPlane);
	public boolean addFlight(Flight f);
	public boolean listFlight();
	public boolean serachFlight(String destinationAirpor
	, String originAirport);
	public boolean removeFlight(String code);
	public boolean buyTicket(String codeFlight);
	public boolean removeTicket();
	public boolean searchTiket(String dni, String id);
	public boolean addClient(Client client);
	public void listClient();
	public boolean searchClient(String dni);
	public boolean removeClient(String dni);	
}