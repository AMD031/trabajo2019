package classes;
import java.util.GregorianCalendar;

/**
	*AirBusA320.class hija de Plane.class
	*Avion de tipo AirBusA320 con las caracteristicas del padre:
		public Plane(String idPlane, GregorianCalendar acquisitionDate, double price)
	*@author Samuel Hermosilla Aguilera
*/

public class AirBusA320 extends Plane{
	private static final int AUTONOMY=4000;
	private static final int CAPACITY=80;
	private static final int CONSUMTIOM=140;
	private static final int PRICE=80000000;
	public static final int ROWS=20;
	public static final String[] COLUMNS={"A", "B", "C", "D"};

	

	public AirBusA320(String idPlane, GregorianCalendar acquisitionDate)throws Exception{
		super(idPlane, acquisitionDate);
		Plane.incrementPlane();
	}


	//Metodo para inicializar la matriz de asientos
	/*public void initializeSeats(){
		for(int i=0;i<ROWS;i++){
			for(int j=0;i<COLUMNS.length;j++){
				this.seats[i][j]=new Seat();
			}
		}
	}
	*/
}