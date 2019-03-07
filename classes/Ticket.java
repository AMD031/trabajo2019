package classes;
import java.util.GregorianCalendar;
import java.util.Calendar;
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
	private GregorianCalendar dateBuy; 

	public Ticket(Client client, Seat seat, Flight flight){
		this.client = client;
		this.seat = seat;
		this.flight = flight;
	    this.id = generatorId();
		this.dateBuy = new GregorianCalendar();
	}
	
	/**
	Genera un codigo a partir del codigo de vuelo y la posicion del asiento.
	@return devuelve un String con un id.
	*/	
	 private String generatorId(){
	 	StringBuilder code = new StringBuilder();
	 	code.append(this.flight.getCode());
	 	code.append(this.seat.getRow());
	 	code.append(this.seat.getColumn());
	 	code.append("_");
	 	code.append(this.flight.getDateAndTime().get(Calendar.YEAR));
	 	code.append("/");
	 	code.append(this.flight.getDateAndTime().get(Calendar.MONTH)+1);
	 	code.append("/");
	 	code.append(this.flight.getDateAndTime().get(Calendar.DAY_OF_MONTH)); 	
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
	 public GregorianCalendar getDateBuy(){
	 	return this.dateBuy;
	 }

	 //setters
	 public void setSeat(Seat seat){
	 	if(seat!=null){
	 		this.seat = seat;
	 		generatorId();
	 	}else{
	 		this.seat = null;
	 	}
	 }

	 public void setflight(Flight f){
	 	if(f!=null){
		 	this.flight = f;
		 	generatorId();
		 }else{
		 	this.flight= null;
		 }	
	 }

	 public void setClient(Client c){
	 	if(c!=null){
	 		this.client = c;
	 	}else{
	 		this.client=null;
	 	}

	 }

	 public void setId(String id){
	 	this.id = id;
	 }

	 public void setDateBuy(GregorianCalendar dateBuy){
	 	this.dateBuy = dateBuy;
	 }

	 @Override
	 public String toString(){
	 	return "id: "+this.id+" comprado a nombre de: "+this.client.getName()+" "+this.client.getSubname();
	 }









}