package classes;

/**
	*AirBusA320.class hija de Plane.class
	*Avion de tipo AirBusA320 con las caracteristicas del padre:
		public Plane(String idPlane, GregorianCalendar acquisitionDate, double price)
	*@author Samuel Hermosilla Aguilera
*/

public class AirBusA320 extends Plane{
	public static final int AUTONOMY=4000;
	public static final int CAPACITY=80;
	public static final int CONSUMTIOM=140;
	public static final int PRICE=80000000;
	private static final int ROWS=20;
	private static final String[] COLUMNS={"A", "B", "C", "D"};

	

	public AirBusA320(String idPlane, GregorianCalendar acquisitionDate){
		super(idPlane, acquisitionDate);
		Plane.planeCounter++;
		this.initializeSeats();
	}

	//Metodo para inicializar la matriz de asientos
	public void initializeSeats(){
		for(int i=0;i<ROWS;i++){
			for(int j=0;i<COLUMNS.length;j++){
				this.seats[i][j]=new Seat();
			}
		}
	}

}