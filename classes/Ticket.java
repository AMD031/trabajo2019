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
	private String id;
	private Flight flight;

	public Ticket(Client client, Seat seat, Flight flight){
		this.client = client;
		this.seat = seat;
		this.id = generatorId();
		this.flight = flight;
	}

	 private String generatorId(){
	 	StringBuilder code = new StringBuilder();
	 	code.append(flight.getCode());
	 	//to do


	 	return code.toString();
	 }

}