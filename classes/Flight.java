package classes;

import java.util.GregorianCalendar;
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
private int estimatedDuration;
private Plane plane;
private String code;

public Flight(AirCompany aircompany, Airport destinationAirport, 
			  Airport originAirport, GregorianCalendar dateAndTime,
			  int estimatedDuration, Plane plane){
			this.aircompany = aircompany;
			this.destinationAirport = destinationAirport;
			this.originAirport = originAirport;
			//fecha y hora del vuelo
			this.dateAndTime = dateAndTime;
			this.estimatedDuration = estimatedDuration;
			this.plane = plane;
			this.code = generateCode();
}	 

	 private String generateCode(){
	 		
			String comp = aircompany.getName();
			String letters = comp.substring(0,2);
			StringBuilder tmpcode = new StringBuilder();
	
			tmpcode.append(letters);
			tmpcode.append(dateAndTime.HOUR);
			tmpcode.append(dateAndTime.MINUTE);
			tmpcode.append("SVQ");//destinationAirport.getAcronym();
			 
		 return tmpcode.toString();
	 }

	 public String getCode(){
	 	return this.code;
	 }







	
}