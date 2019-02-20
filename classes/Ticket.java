package classes;
	/**
		Ticket.class
		Permite crear objetos de tipo Ticket que guarda informacion del 
		vuelo y el cliente. 
		@author Antonio Martinez Diaz
	*/


public class Ticket{
	private Client client;
	private Seat seat;
	private static int id;
	private Flight flight;

	public Ticket(Client client, Seat seat, Flight flight){
		this.client = client;
		this.seat = seat;
		Ticket.id++;
		this.flight = flight;
	}

}