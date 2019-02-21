package classes;
//import interfaces.IAirCompany;
import java.util.GregorianCalendar;
public class AirCompany{
	private String name;
	private char charcode[];
	private String ceo;
	private GregorianCalendar foundationDate;


	public AirCompany(String name, char[] charcode, 
					  String ceo, GregorianCalendar foundationDate){
		this.name = name;
		this.charcode = charcode;
		this.ceo = ceo;
		this.foundationDate = foundationDate;
	}


	//setters
	public void setCeo(String ceo){
		this.ceo = ceo;
	}

	public void setCharcode(char[] charcode){
		if(charcode.length==3){
			for (int i =0;i<charcode.length;i++){
				 this.charcode[i] = charcode[i];
				}
			}
		}

	public void setName(String name){
		this.name = name;
		
	}

	public void setFoundationDate(int year, int month, int dayOfMonth){
		this.foundationDate.set(year,month,dayOfMonth);
	}

	//getters
	public String getCeo(){
		return this.ceo;
	}
	public String getName(){
		return name;
	}
	public char[] getCharcode(){
		return charcode;
	}

	public GregorianCalendar getFoundationDate(){
		return foundationDate;
	}

}


