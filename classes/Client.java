package classes;
import java.util.GregorianCalendar;
import java.util.regex.Pattern;
/**
	Client.class
	permite crear objetos de tipo cliente que seran
	usados en una en una compañia aerea.
	@author Antonio Martinez Diaz
*/
public class Client{
	private String dni;
	private String name;
	private String subName;
	private String Natinality;
	private GregorianCalendar birthDate;

	public Client(String dni, String name,String subName,
	GregorianCalendar birthDate, String Natinality)throws Exception{
		setDni(dni);
		this.name = new String(name);
		this.subName = new String(subName);
		this.birthDate = birthDate;
		this.Natinality = new String(Natinality);
	}

	/**
	* 
	* El metodo comprueba si el formato y letra son validos  
	* @author Antonio Martinez Diaz
	* @param String dni: es el dni a comprobar
	* @return devuelve true si el dni es correcto.
	* 
	*/
	private boolean checkDni(String dni){
	    boolean valid = false;
		String patternDni = "\\d{8}[A-HJ-NP-TV-Za-hj-np-tv-z]$";
		String patternDni2 = "^[X-Z]\\d{7}[A-HJ-NP-TV-Za-hj-np-tv-z]$";
	
	    if(Pattern.matches(patternDni, dni)==true || Pattern.matches(patternDni2, dni)==true){
			char lastLetter = Character.toUpperCase(dni.charAt(dni.length()-1));
			char firstLetter = Character.toUpperCase(dni.charAt(0));
			
			if(firstLetter == 'X'  ){
				dni = dni.replaceFirst("X", "0");
				dni = dni.replaceFirst("x", "0");
			}else if(firstLetter == 'Y' ){
				dni = dni.replaceFirst("Y", "1");
				dni = dni.replaceFirst("y", "1");	
			}else if(firstLetter == 'Z' ){
				dni = dni.replaceFirst("Z", "2");
				dni = dni.replaceFirst("z", "2");
			}

			String numbersString = " ";
			int numbersInt = 0;
			int rest =0;
			
			char[] letters = {'T', 'R', 'W','A','G','M','Y','F','P','D','X','B',
							 'N','J','Z','S','Q','V','H','L','C','K','E'};

			 numbersString = dni.substring(0,dni.length()-1);
			 numbersInt = Integer.valueOf(numbersString);
			 rest = numbersInt%23;

			if(lastLetter == letters[rest]){
				valid = true;
			}
	 	}
		return valid;

	}

	//setter
	/**
		Cambia el valor del dni en la variable del objeto si el dni es valido
		@exception Exception si el dni no es valido.
		
	*/
	public void setDni(String dni)throws Exception{
		if(checkDni(dni)){
			this.dni = new String(dni);
		}else{
			throw new Exception("Dni no valido");
		}
	}

	public void setName(String name){
		this.name = new String(name);
	}

	public void subName(String subName){
		this.subName = new String(subName);
	}

	public void setBirthDate(GregorianCalendar birthDate){
		this.birthDate = birthDate;
	}

	public void setNatinality(String Natinality){
		this.Natinality = Natinality;
	}

	//getter
	public String getDni(){
		return this.dni;
	}

	public String getName(){
		return this.name;
	}

	public String getSubname(){
		return this.subName;
	}

	public String getNatinality(){
		return this.Natinality;
	}

	public GregorianCalendar getBirthDate(){
		return this.birthDate;
	}

	public String toString(){
		return "Name: "+this.name+"\n Subname: "+this.subName+" Dni: "+this.dni+
		" Natinality: "+this.Natinality+" Birth date: "+this.birthDate.toString();
	}

}