package classes;
import java.util.GregorianCalendar;
/**
	*Boing787.class hija de Plane.class
	*Avion de tipo Boing787 con las caracteristicas del padre:
		public Plane(String idPlane, GregorianCalendar acquisitionDate, Double price)
	*@author Samuel Hermosilla Aguilera
*/

public class Boing787 extends Plane{
	private static final int AUTONOMY=8000;
	private static final int CAPACITY=300;
	private static final int CONSUMTIOM=160;
	private static final int PRICE=280000000;
	public static final int ROWS=50;
	public static final String[] COLUMNS={"A", "B", "C", "D", "E", "F", "G"};

	public Boing787(String idPlane, GregorianCalendar acquisitionDate)throws Exception{
		super(idPlane, acquisitionDate);
		Plane.incrementPlane();	
	}


	
}