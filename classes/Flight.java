package classes;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.Calendar;
/**
  Flight.class
  permite instaciar objetos de tipo Flight.
  contiene informacion sobre: la compañia, aeropuerto destino y origen,
  fecha del vuelo en un objeto del tipo GregorianCalendar, tiempo estimado del vuelo,
  avion y codiogo del vuelo.
  @author Antonio Martinez Diaz
*/
public class Flight{

private AirCompany aircompany;
private Airport destinationAirport;
private Airport originAirport;
private GregorianCalendar dateAndTime;
private double estimatedDuration;
private Plane plane;
private String code;
private ArrayList<Seat> SeatsFlight;
private Pilot[] pilotSeats;
private Crew[] CrewSeats;
private double price;

public Flight(AirCompany aircompany, Airport destinationAirport, 
			  Airport originAirport,Plane plane, GregorianCalendar dateAndTime,
			  double estimatedDuration, double price)throws Exception{
			this.aircompany = aircompany;
			this.destinationAirport = destinationAirport;
			this.originAirport = originAirport;
			this.dateAndTime = dateAndTime;//fecha y hora del vuelo
			this.estimatedDuration = estimatedDuration;
			this.plane = plane;
			this.price = price;
			this.code = generateCode();
			this.initializeSeats(plane);
			this.CrewSeats = new Crew[(int)(Math.ceil( (plane.getRows()*plane.getColumns())*0.02))];
			this.pilotSeats = new Pilot[2];
}	 
	/**
		genera un codigo apartir des nombre de la empresa de vuelos,
		la hora y el acronimo del aeropuerto destino.
		@return devuelve un codigo que identifica a un vuelo
	*/
	 private String generateCode(){
			String comp = aircompany.getName();
			String letters = comp.substring(0,2);
			StringBuilder tmpcode = new StringBuilder();
			tmpcode.append(letters);
			String hour = Integer.toString(dateAndTime.get(Calendar.HOUR));
			 if(hour.length()<2){
			 	tmpcode.append("0");
			 }	 
			tmpcode.append(hour);
			String minute = Integer.toString(dateAndTime.get(Calendar.MINUTE));
			 if(minute.length()<2){
			 	tmpcode.append("0");
			 }
			tmpcode.append(minute);
			tmpcode.append(destinationAirport.getAcronym());
 		 return tmpcode.toString();
	 }

	 public int freeSeats(){
	 	int amount =0;
	 	for (int i =0;i<this.SeatsFlight.size();i++) {
	 		if(this.SeatsFlight.get(i).getReserved()==false){
	 			amount++;
	 		}
	 	}
	 	return amount ;
	 }




	 /**
	 	busca un objeto de tipo piloto por id y nombre
	 	y si lo encuentra lo pone null en el array pilotSeats y decrementa en uno
	 	la cantidad de vuelos asignados.
		@param dni objeto de tipo String que contine un dni a buscar. 
		@param id numero de id del objeto de tipo piloto que se quiere borrar.
		@return devuelve true si ha encontrado y puesto a null al piloto indicado
	 */
	 public boolean removePilot(String dni, int id){
	 	boolean found = false;
	 	for (int i =0;i<this.pilotSeats.length && !found;i++) {	
	 		if(this.pilotSeats[i].getDni().equals(dni) && 
	 		   this.pilotSeats[i].getNEmployee()== id){
	 		   this.pilotSeats[i].decrementAssignedFlight();	
	 		   this.pilotSeats[i] = null;
	 		   found = true;
	 		}

	 	}
	 	return found;
	 }


		/**
	 	busca un objeto de tipo crew por id y nombre
	 	y si lo encuentra lo pone null en el array CrewSeats y decrementa en uno la cantidad de vuelos
	 	asignado.
		@param dni objeto de tipo String que contine un dni a buscar. 
		@param id numero de id.
		@return devuelve true si ha encontrado y puesto a null al crew indicado.
		 */

	  public boolean removeCrew(String dni, int id){
	 	boolean found = false;
	 	for (int i =0;i<this.CrewSeats.length && !found;i++) {	
	 		if(this.CrewSeats[i].getDni().equals(dni) && 
	 		   this.CrewSeats[i].getNEmployee()== id){
	 		   this.CrewSeats[i].decrementAssignedFlight();	
	 		   this.CrewSeats[i] = null;
	 		   found = true;
	 		}
	 	}
	 	return found;
	 }



	 //getter
	 public String getDestinationAirport(){
	 	return this.destinationAirport.getName();
	 }
	  public String getOriginAirport(){
	 	return this.originAirport.getName();
	 }

	 public String getCode(){
	 	return this.code;
	 }

	 public double getPrice(){
	 	return this.price;
	 }

	 public Plane getPlane(){
	 	return this.plane;
	 } 

	 public Pilot[] getPilotSeats(){
	 	return this.pilotSeats;
	 }

	 public Crew[] getCrewSeats(){
	 	return this.CrewSeats;
	 }

	 //setters

	  public void setPilots(Pilot[] pilots){
	 	for(int i =0; i< this.pilotSeats.length;i++){	
	 		this.setPilot(pilots[i]);
	 	}
	 }


	   public void setPilot(Pilot pilot){
	   	boolean stop = false;
	 	for(int i =0; i<this.pilotSeats.length && !stop;i++){
	 		if(this.pilotSeats[i]==null){
	 			this.pilotSeats[i]=pilot;
	 			double newtimeFly =  this.pilotSeats[i].getFlytime()+this.estimatedDuration;
	 			this.pilotSeats[i].setFlytime(newtimeFly);
	 			this.pilotSeats[i].incrementAssignedFlight();
	 			stop=true;
	 		}
	 	}
	 }

	 public void setCrew(Crew crew){
	 	boolean stop = false;
	 	for(int i =0; i<this.CrewSeats.length && !stop;i++){
	 		if(this.CrewSeats[i]==null){
	 			this.CrewSeats[i]=crew;

	 			this.CrewSeats[i].incrementAssignedFlight();
	 			stop = true;
	 		}
	 	}
	 }

	  public void setCrews(Crew[] crews){
	 	for(int i =0; i<this.CrewSeats.length;i++){
	 		this.setCrew(crews[i]);
	 	}
	 }


	

	 public double setPrice( double price){
	 	return this.price = price;
	 }

	 public void setPlane(Plane p)throws Exception{
	 	if(p!=null){
	 		int oldPlaneTam = plane.getRows()*plane.getColumns();
	 		int newPlaneTam = p.getRows()*p.getColumns();
	 		if(oldPlaneTam == newPlaneTam ){
	 			 this.plane = p;
	 		}else if(p==null){
	 			this.plane =null;
	 		}else{
	 			throw new Exception("Los aviones no son del mismo tamaño no se puede transferir las plazas.");
	 		}


	 	}
	 }


	 /**
	 	metodo que rellena las posiones de un ArrayList con 
		@param plane objeto de tipo plane del que se obtiene la cantidad de asientos.
	 */
	 private void initializeSeats(Plane plane)throws NullPointerException{
		 	SeatsFlight = new ArrayList<Seat>();
		 	int Nvip = plane.getNVip();//numero de filas vip
		 	boolean vip = false;
		 	//boolean re = true;
		 	char CharC = 'A';//letra de la columna
		 	int Nrow = 0;
		 	for (int i =0;i<plane.getRows()*plane.getColumns();i++ ) {
	 			Nrow++;
	 			if(Nrow>plane.getRows()){
	 				Nrow=1;
	 				CharC = (char)((int)CharC+1);
	 			}
	 		   if(Nrow<Nvip){
	 			  vip = true;
	 		   }
			   SeatsFlight.add(new Seat(vip,Nrow,CharC));
	 		vip = false;
 		}
	 }
	 @Override
	 public String toString(){
	 	return "Flight: "+this.code;
	 }

}