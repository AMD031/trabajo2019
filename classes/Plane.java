package classes;
import java.util.GregorianCalendar;
import java.util.regex.Pattern;
/**
	*Plane.class
	*Permite crear objetos de tipo avion, 
	 que se utilizaran en los vuelos de una compañia aerea.
	*@author Samuel Hermosilla Aguilera
*/

public class Plane{
	public static int planeCounter=0;
	protected String idPlane;
	protected GregorianCalendar acquisitionDate;
	protected Seat[][] seats;

	public Plane(String idPlane, GregorianCalendar acquisitionDate)throws Exception{
		setIDPlane(idPlane);
		this.acquisitionDate=acquisitionDate;
	}

	/**
		*Metodo que prueba si la cadena idPlane es un patron correcto.
		@author Samuel Hermosilla Aguilera.
		@param String idPlane: es la matricula del avion.
		@return true si, y solo si, la secuencia completa coincide con el patrón.
	*/
	private boolean checkIDPlane(String idPlane){
		String patternIDPlane="^\\[0-9]{4}[A-Z]{3}$";
		return patternIDPlane.matches(idPlane);
	}

	
	//Setters

	//Cambia el valor de la matricula si la matricula del avion es valida
	public void setIDPlane(String idPlane)throws Exception{
		if(checkIDPlane(idPlane)){
			this.idPlane=new String(idPlane);
		}else{
			throw new Exception("Matricula no valida");
		}
	}

	public void setAcquisitionDate(GregorianCalendar acquisitionDate){
		this.acquisitionDate=acquisitionDate;
	}


	//Getters
	public String getIDPlane(){
		return this.idPlane;
	}

	public GregorianCalendar getAcquisitionDate(){
		return this.acquisitionDate;
	}

	public static int incrementPlane(){
		return Plane.planeCounter++;
	}

	public static int decrementPlanea(){
		return Plane.planeCounter--;
	}
}