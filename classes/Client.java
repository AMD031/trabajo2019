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

	
	private int nBuys =0;
	private int nRefund =0;
	
	public Client(String dni, String name,String subName,
	GregorianCalendar birthDate, String Natinality)throws Exception{
		super(dni,name,subName,birthDate,Natinality);
	}

	public Client()throws Exception{}

	/**
	  incrementa en uno la cantidad de compras.
	*/
	public void incrementNbuys(){
	   this.nBuys++;
	}

	/**
	 incrementa en uno la cantidad de devoluciones
	*/
	public void incrementNrefund(){
		this.nRefund++;
	}

	/**
	   @return devuleve la cantidad de devoluciones
	*/
	public int getrefundTickticket(){
	   return this.nRefund;
	}

	/**
	 @return devuleve la cantidad de compras.
	*/
	public int getNbuy(){
		return this.nBuys;
	}

    @Override
	public String toString(){
		return super.toString()+"\n Billetes comprados: "+this.nBuys+"\n Boletos devueltos "+this.nRefund;
	}


}


