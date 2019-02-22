package classes;

/**
	*Boing787.class hija de Plane.class
	*Avion de tipo Boing787 con las caracteristicas del padre:
		public Plane(String idPlane, GregorianCalendar acquisitionDate, Double price)
	*@author Samuel Hermosilla Aguilera
*/

public class Boing787 extends Plane{
	static final int AUTONOMY=8000;
	static final int CAPACITY=300;
	static final int CONSUMTIOM=160;
	public static final int PRICE=280000000;
	public static final int ROWS=50;
	private static final String[] COLUMNS={"A", "B", "C", "D", "E", "F", "G"};

	public Boing787(String idPlane, GregorianCalendar acquisitionDate){
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