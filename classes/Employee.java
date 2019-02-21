package classes;
abstract public class Employee{
	private final static String DNI_DEF="";
	private final static int NEmployee_DEF=0;
	private final static String NAME_DEF="";
	private final static String SUBNAME_DEF="";
	private final static GregorianCalendar BIRTHDATE_DEF=;
	private final static String NATIONALY_DEF="";

	protected String DNI;
	protected int NEmployee;
	protected String Name;
	protected String Subname;
	protected GregorianCalendar Birthdate;
	protected String Nationaly;
	protected String[] Lenguages;
	protected int Quantity;

	public Employee(){
		this(DNI_DEF,NEmployee_DEF,NAME_DEF,SUBNAME_DEF,BIRTHDATE_DEF,
		NATIONALY_DEF);
	}

	public Employee(String DNI, int NEmployee, String Name, String Subname,
	 GregorianCalendar Birthdate, String Nationaly,int quantity,String[] Lenguages){
		 this.DNI=DNI;
		 this.NEmployee=NEmployee;
		 this.Name=Name;
		 this.Subname=Subname;
		 this.Birthdate=Birthdate;
		 this.Nationaly=Nationaly;
		 this.Quantity=quantity;
		 this.Lenguages=new String[Quantity];


	 }

	 abstract public double calculateSalary(){

	 }
}
