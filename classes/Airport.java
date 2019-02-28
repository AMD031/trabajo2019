package classes;
import java.util.ArrayList;
/**
	*Airport.class
	*Clase aeropuerto, de la cual parten los diferentes aviones.
	 Cada aeropuerto ofrece diferentes servicios.
	*@author Samuel Hermosilla Aguilera
*/
public class Airport{
	private String acronym;
	private String name;
	private String cityName;
	private String country;
	private ArrayList<String> services;

	public Airport(String acronym, String name, String cityName, String country, ArrayList<String> services){
		this.acronym=acronym;
		this.name=name;
		this.cityName=cityName;
		this.country=country;
		setServices(services);
	}

	//Getters
	public String getAcronym(){
		return this.acronym;
	}

	public String getName(){
		return this.name;
	}

	public String getcityName(){
		return this.cityName;
	}

	public String getCountry(){
		return this.country;
	}

	public ArrayList<String> getServices(){
		return this.services;
	}

	//Setters

	public void setAcronym(String acronym){
		this.acronym=acronym;
	}

	public void setName(String name){
		this.name=name;
	}

	public void setCityName(String cityname){
		this.cityName=cityname;
	}

	public void setCountry(String country){
		this.country=country;
	}

	public void setServices(ArrayList<String> services){
		if(services!=null){
			for(int i=0; i<services.size(); i++){
				this.services.add(services.get(i));
			}
		}	
	}

	/*this.acronym=acronym;
		this.name=name;
		this.cityName=cityName;
		this.country=country;*/
	
	public String toString(){
		StringBuilder services = new StringBuilder();
		for (int i =0;i<this.services.size();i++ ) {
			services.append(" "+this.services.get(i));
		}


		return "\n Acronimo: "+this.acronym+"\n nombre: "+this.name+"\n ciudad: "+this.cityName+
		"\n pais "+this.country+"\n servicios: "+services.toString();
	}


}