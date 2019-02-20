package classes;
import java.util.GregorianCalendar;
/**
  Flight.class
  permite instaciar objetos de tipo vuelo.
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
	 	return "";
	 }







	
}