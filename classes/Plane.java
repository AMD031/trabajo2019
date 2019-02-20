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
	private String idPlane;
	private GregorianCalendar acquisitionDate;
	private Double price;

	public Plane(String idPlane, GregorianCalendar acquisitionDate, Double price){
		setIDPlane(idPlane);
		this.acquisitionDate=acquisitionDate;
		this.price=price;
	}

	/**
		*Metodo que prueba si la cadena idPlane es un patron correcto.
		@author Samuel Hermosilla Aguilera.
		@param String idPlane: es la matricula del avion.
		@return true si, y solo si, la secuencia completa coincide con el patrón.
	*/
	public boolean checkIDPlane(String idPlane){
		String patternIDPlane="^\\d{4}[ -]?[[B-Z]&&[^QEIOU]]{3}$";
		return patternIDPlane.matches(idPlane);
	}

	
	//Setters

	//Cambia el valor de la matricula si la matricula del avion es valida
	public void setIDPlane(String idPlane){
		if(checkIDPlane(idPlane)){
			this.idPlane=new String(idPlane);
		}
	}

	public void setAcquisitionDate(GregorianCalendar acquisitionDate){
		this.acquisitionDate=acquisitionDate;
	}

	public void setPrice(Double price){
		this.price=price;
	}

	//Getters
	public String getIDPlane(){
		return this.idPlane;
	}

	public GregorianCalendar getAcquisitionDate(){
		return this.acquisitionDate;
	}

	public Double getPrice(){
		return this.price;
	}

}