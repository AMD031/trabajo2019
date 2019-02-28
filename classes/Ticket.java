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
	
	/**
	Genera un codigo a partir del codigo de vuelo y la posicion del asiento.
	@return devuelve un String con un id.
	*/	
	 private String generatorId(){
	 	StringBuilder code = new StringBuilder();
	 	code.append(flight.getCode());
	 	code.append(seat.getRow());
	 	code.append(seat.getColumn());
	 	return code.toString();
	 }
	 //getters
	 public Client getClient(){
	 	return this.client;
	 }

	 public Seat getSeat(){
	 	return this.seat;
	 }

	 public String getId(){
	 	return this.id;
	 }

	 public Flight getFlight(){
	 	return this.flight;
	 	
	 }

	 //setters
	 public void setSeat(Seat seat){
	 	if(seat!=null){
	 		this.seat = seat;
	 		generatorId();
	 	}else{
	 		seat = null;
	 	}
	 }

	 public void setflight(Flight f){
	 	if(f!=null){
		 	this.flight = f;
		 	generatorId();
		 }else{
		 	f= null;
		 }	
	 }

	 public void setClient(Client c){
	 	if(c!=null){
	 		this.client = c;
	 	}else{
	 		c=null;
	 	}

	 }

	 public void setId(String id){
	 	this.id = id;
	 }

	 @Override
	 public String toString(){
	 	return this.id+" "+client.getDni();
	 }









}