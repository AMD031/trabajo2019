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
private static final String [] months={"Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio","Agosto","Septiembre","Octubre",
"Noviembre","Diciembre"};
private AirCompany aircompany;
private Airport destinationAirport;
private Airport originAirport;
private GregorianCalendar dateAndTime;
private int estimatedDuration;
private Plane plane;
private String code;
private ArrayList<Seat> SeatsFlight;
private Pilot[] pilotSeats;
private Crew[] CrewSeats;
private double price;

public Flight(AirCompany aircompany, Airport destinationAirport, 
			  Airport originAirport,Plane plane, GregorianCalendar dateAndTime,
			  int estimatedDuration, double price)throws Exception{
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
	Método que calcula la rentabilidad.
	@return devuelve el calculculo de la rentabilidad, en caso de que 
	sea mayor a uno o igual el vuelo será rentable.

	*/
	public double calculateProfitability(){
		double benefit =0;
		double expense = this.estimatedDuration*this.plane.getConsumtiom();
		double profitability=0;
		for (Seat s :SeatsFlight){
			if(s.getReserved()){
				if(s.getVip()){
				   benefit+=this.price*1.20;
				}else{
				   benefit+=this.price;
				}	
			}	
		}
		profitability = benefit/expense;

	 return profitability;
	}

	/**
		Genera un codigo apartir des nombre de la empresa de vuelos,
		la hora y el acronimo del aeropuerto destino.
		@return devuelve un codigo que identifica a un vuelo
	*/
	 private String generateCode(){
			String comp = aircompany.getName();
			String letters = comp.substring(0,3);
			StringBuilder tmpcode = new StringBuilder();
			tmpcode.append(letters);
			String hour = Integer.toString(dateAndTime.get(Calendar.HOUR_OF_DAY));
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


	 /**
		@return Método que devuelve la cantidad de asientos libres.
	 */
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
	 		if(this.pilotSeats[i].getDni().equalsIgnoreCase(dni) && 
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
	 		if(this.CrewSeats[i].getDni().equalsIgnoreCase(dni) && 
	 		   this.CrewSeats[i].getNEmployee()== id){
	 		   this.CrewSeats[i].decrementAssignedFlight();	
	 		   this.CrewSeats[i] = null;
	 		   found = true;
	 		}
	 	}
	 	return found;
	 }

	 	 /**
		pone todos los tripulantes a null.
	 */
	 public void removeCrews(){
	 	for(Crew c :CrewSeats){
	 		if(c!=null && c.getAssignedFlight()>0){
	 		 c.decrementAssignedFlight();	
	 		 c = null;
	 		}
	 	}
	 }
	 /**
		pone todos los pilotos a null.
	 */
	 public void removePilots(){
	 	for(Pilot p :pilotSeats){
	 		if(p!=null && p.getAssignedFlight()>0){	
	 		 p.decrementAssignedFlight();	
	 		 p = null;
	 		}
	 	}
	 }


	 //getter

	 public String getDestinationAirport(){
	 	return this.destinationAirport.getName();
	 }
	  public String getOriginAirport(){
	 	return this.originAirport.getName();
	 }

	 public Airport getObjectDestinationAirport(){
	 	return this.destinationAirport;
	 }
	  public Airport getObjectOriginAirport(){
	 	return this.originAirport;
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

	 public ArrayList<Seat>getSeatsFlight(){
	 	return this.SeatsFlight;
	 }

	public GregorianCalendar getDateAndTime(){
		return this.dateAndTime;
	}

	 //setters

	 /**
		Añade una lista de pilostos a la clase.
		@param pilots array de pilos a añadir a la clase Flight.
	 */	
	  public void setPilots(Pilot[] pilots){
	  	if(pilots.length>0){
		 	for(int i =0; i< this.pilotSeats.length;i++){	
		 		this.setPilot(pilots[i]);
		 	}
	 	}
	 }


	 /**
		Añade un objeto de tipo pilot a la clase.		
		@param pilot pilot a añadir al array pilots.
		@return si se añadido correctamente devuelve true en caso contrario false.
	 */
	 public boolean setPilot(Pilot pilot){
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
	 	return stop;
	 }

	 	 /**
	     Añade un objeto de tipo crew a la clase.		
		@param crew tripulante a añadir al array crews.
		@return si se añadido correctamente devuelve true en caso contrario false.
	 */	

	 public boolean setCrew(Crew crew){
	 	boolean stop = false;
	 	for(int i =0; i<this.CrewSeats.length && !stop;i++){
	 		if(this.CrewSeats[i]==null){
	 			this.CrewSeats[i]=crew;
	 			this.CrewSeats[i].incrementAssignedFlight();
	 			stop = true;
	 		}
	 	}
	 	return stop;
	 }

	  /**
		Añade una lista de tripulantes a la clase.
		@param crews array de tripulantes a añadir a la clase Flight.
	 */	

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
		 	char CharC = 'A';//letra de la columna
		 	int Nrow = 0;
		 	for (int i =0;i<plane.getRows()*plane.getColumns();i++ ) {
	 			Nrow++;
	 			if(Nrow>plane.getRows()){
	 				Nrow=1;
	 				CharC = (char)((int)CharC+1);
	 			}
	 		   if(Nrow<=Nvip){
	 			  vip = true;
	 		   }
			   SeatsFlight.add(new Seat(vip,Nrow,CharC));
	 		vip = false;
 		}
	 }

	 /**
	 	Comprueba si un número es de dos cifras. Si es de una 
	 	añade un cero delante del número.
	 	@param a parametro de tipo int a comprobar.
		@return devuelve un String con un numero de dos cifras
	 */
	 private String twoDigit(int a){
	 	StringBuilder d = new StringBuilder();
	 	String digit = Integer.toString(a);
	 	if(digit.length()<2){
			d.append(0);
	 	}
	 	d.append(a);
	 	return d.toString();
	 }


	 @Override
	 public String toString(){
	 	GregorianCalendar tmp = new GregorianCalendar(this.dateAndTime.get(Calendar.YEAR),this.dateAndTime.get(Calendar.MONTH),
	 		this.dateAndTime.get(Calendar.DAY_OF_MONTH),this.dateAndTime.get(Calendar.HOUR_OF_DAY),this.dateAndTime.get(Calendar.MINUTE));
	  
	  	tmp.add(Calendar.MINUTE,this.estimatedDuration);

	 	return "Vuelo: "+this.code+" Aeropuerto origen "+this.originAirport.getName()+"("+this.originAirport.getCountry()+")"+
	 		    " Aeropuerto destino: "+this.destinationAirport.getName()+"("+this.destinationAirport.getCountry()+")"+
	 		    "\n Fecha vuelo: "+this.dateAndTime.get(Calendar.YEAR)+" "+this.months[this.dateAndTime.get(Calendar.MONTH)]+" "+
	 		    this.dateAndTime.get(Calendar.DAY_OF_MONTH)+" "+this.dateAndTime.get(Calendar.HOUR_OF_DAY)+":"
	 		    +this.twoDigit(this.dateAndTime.get(Calendar.MINUTE))+".\n"+
	 		    " LLegada D\u00eda: "+tmp.get(Calendar.DAY_OF_MONTH)+" Hora: "+tmp.get(Calendar.HOUR_OF_DAY)+":"
	 		    +this.twoDigit(tmp.get(Calendar.MINUTE))+"( Asientos libres: " +this.freeSeats() +").";
	 		   
	 }

}