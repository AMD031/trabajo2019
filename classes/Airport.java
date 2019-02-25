package classes;
/**
	*Airport.class
	*Clase aeropuerto.
	*@author Samuel Hermosilla Aguilera
*/
public class Airport{
	public String acronym;
	public String name;
	public String cityName;
	public String country;
	public String[] services={"reting car", "coffeshop", "restaurant", "lost objects"};

	public Airport(String acronym, String name, String cityName, String country, String[] services){
		this.acronym=acronym;
		this.name=name;
		this.cityName=cityName;
		this.country=country;
		//array
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
	
}