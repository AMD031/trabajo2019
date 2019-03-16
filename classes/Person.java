package classes;
import java.util.GregorianCalendar;
import java.util.Calendar;
import java.util.regex.Pattern;
/**
	Person.class
	clase que permite instaciar objetos de tipo persona con
	los datos dni, nombre, apellido y nacionalidad de tipo String
	y una fecha de tipo gregorian calendar.
	@author Antonio Martinez Diaz
*/
public class Person{

	protected String dni;
	protected String name;
	protected String subName;
	protected String Natinality;
	protected GregorianCalendar birthDate;

	protected final static String DNIDEF = "30151277W";
	protected final static String NAMEDEF ="";
	protected final static String SUBNAMEDEF ="";
	protected final static String NATINALITYDEF="";
	protected final static GregorianCalendar BRITHDATEDEF= new GregorianCalendar(1999,Calendar.MARCH,3);

	private static final String [] months={"Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio","Agosto","Septiembre","Octubre",
	"Noviembre","Diciembre"};

	protected Person(String dni, String name, String subName,
		             GregorianCalendar birthDate,  String Natinality)throws Exception{
		this.setDni(dni);
		this.setName(name);
		this.setSubName(subName);
		this.setNatinality(Natinality);
		this.birthDate = birthDate;

	}

	protected Person()throws Exception{
		this(DNIDEF,NAMEDEF,SUBNAMEDEF,BRITHDATEDEF,NATINALITYDEF);
	}


    /**
	* El metodo comprueba si el formato y letra son validos
	* @author Antonio Martinez Diaz
	* @param dni String : es el dni a comprobar
	* @return devuelve true si el dni es correcto.
	*/
	public static boolean checkDni(String dni){
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

	/**
		Metodo que comprueba si es mayor de la edad indicada.
		@param date fecha de nacimiento de la persona
		@param age edad que se quiere verificar con la fecha.
		@return devuelve true si es mayor de la edad indicada
	*/
	public boolean checkAge(GregorianCalendar date,int age){
		GregorianCalendar rightNow = new GregorianCalendar();
		rightNow.add(Calendar.YEAR,-age);
		return date.before(rightNow);
	}
 	//setter
	/**
		Cambia el valor del dni en la variable del objeto si el dni es valido
		@param dni valor de tipo String que contedra el dni.
		@exception Exception si el dni no es valido.

	*/
	public void setDni(String dni)throws Exception{
		if(Person.checkDni(dni)){
	
			this.dni = new String(dni);
		}else{
			throw new Exception("Dni no valido: "+dni);
		}
	}

	/**
	 Método que comprueba que el nombre no tenga numeros.		
	 @param name nombre a comprobar.
	 @throws Exception devuelve un mesaje si el nombre contiene números.
	*/
	public void setName(String name)throws Exception{
		for(int i =0;i<name.length();i++){
			if(Character.isDigit(name.charAt(i))){
				throw new Exception("Los nombre de persona no puede contener numeros.");
			}
		}
		this.name = new String(name);
	
	}
    
    /**
	 Método que comprueba que el apellido no tenga numeros.		
	 @param subName apellido a comprobar.
	 @throws Exception devuelve un mesaje si el apellido contiene números.
	*/
	public void setSubName(String subName)throws Exception{
		for(int i =0;i<subName.length();i++){
		 if(Character.isDigit(subName.charAt(i))){
				throw new Exception("Los apellidos de persona no puede contener numeros.");		
		}
	  }
		this.subName = new String(subName);
		
	}

	public void setBirthDate(int year, int month, int dayOfMonth){
		this.birthDate.set(year,month,dayOfMonth) ;

	}

	public void setNatinality(String Natinality)throws Exception{
		for(int i =0;i<Natinality.length();i++){
			if(Character.isDigit(Natinality.charAt(i))){
				throw new Exception("La nacionalidad no puede contener numeros.");
			}
		}
		this.Natinality = new String(Natinality);
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

	public String getBirthDate(){
		return "Fecha nacimiento: "+" a\u00f1o: "+birthDate.get(Calendar.YEAR)+
		" Mes: "+months[birthDate.get(Calendar.MONTH)]+
		" D\u00eda: "+birthDate.get(Calendar.DAY_OF_MONTH);
	}
	public GregorianCalendar getBirthDateGregorian(){
		return this.birthDate;
	}

	@Override
	public String toString(){
		return "Nombre: "+this.name+"\n Apellido: "+this.subName+"\n Dni: "+this.dni+
		"\n Nacionalidad: "+this.Natinality+"\n Fecha nacimiento: "+this.getBirthDate();
	}

	@Override
	public boolean equals(Object obj){
		boolean match = false;
		if(obj instanceof Person){
			Person tmp = (Person)obj;
			if(this.getDni().equals(tmp.getDni())){
			   match =true;
			}
		}
		return match;
	}


}
