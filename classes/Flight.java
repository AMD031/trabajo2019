package classes;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Iterator;
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
private ArrayList<Seat> SeatsFlight;

public Flight(AirCompany aircompany, Airport destinationAirport, 
			  Airport originAirport, GregorianCalendar dateAndTime,
			  int estimatedDuration, Plane plane)throws Exception{
			this.aircompany = aircompany;
			this.destinationAirport = destinationAirport;
			this.originAirport = originAirport;
			this.dateAndTime = dateAndTime;//fecha y hora del vuelo
			this.estimatedDuration = estimatedDuration;
			this.plane = plane;
			this.code = generateCode();
			this.initializeSeats(plane);
			for (Seat a : SeatsFlight ) {
				System.out.println(a);
			}

}	 

	 private String generateCode(){
	 		
			String comp = aircompany.getName();
			String letters = comp.substring(0,2);
			StringBuilder tmpcode = new StringBuilder();
	
			tmpcode.append(letters);
			 int hour = Integer.toString(int);
			 if(hour.length()<1){
			 	tmpcode(0);
			 }
			tmpcode.append(hour);
			tmpcode.append(dateAndTime.MINUTE);
			tmpcode.append(destinationAirport.getAcronym());
 		 return tmpcode.toString();
	 }



	 public String getCode(){
	 	return this.code;
	 }

	 public Plane getPlane(){
	 	return this.plane;
	 } 

	 public void setPlane(Plane p)throws Exception{
	 	if(p!=null){
	 		int oldPlaneTam = plane.getRows()*plane.getColumns();
	 		int newPlaneTam = p.getRows()*p.getColumns();
	 		if(oldPlaneTam == newPlaneTam ){
	 			 this.plane = p;
	 		}else{
	 			throw new Exception("No se puede transferir todas las reservas al nuevo avion.");
	 		}
	 	}
	 }

	 private void initializeSeats(Plane plane)throws NullPointerException{
		 	SeatsFlight = new ArrayList<Seat>();
		 	int Nvip = plane.getNVip();//numero de filas vip
		 	boolean vip = false;
		 	boolean re = true;
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
}