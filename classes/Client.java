package classes;
import java.util.GregorianCalendar;
import java.util.regex.Pattern;
/**
	Client.class
	permite crear objetos de tipo cliente que seran
	usados en una en una compañia aerea.
	@author Antonio Martinez Diaz
*/
public class Client extends Person{
	
	public Client(String dni, String name,String subName,
	GregorianCalendar birthDate, String Natinality)throws Exception{
		super(dni,name,subName,birthDate,Natinality);
	}

	public Client()throws Exception{}
}