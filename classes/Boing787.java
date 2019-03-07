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
	private static final int ROWS=50;
	private static final int COLUMNS =7;
	private static final int AMOUNTVIP=10;

	public Boing787(String idPlane, GregorianCalendar acquisitionDate)throws Exception{

		/*Plane(String idPlane, GregorianCalendar acquisitionDate,int Nvip, 
		int rows, int columns )*/

		super(idPlane, acquisitionDate,AMOUNTVIP,ROWS,COLUMNS,CONSUMTIOM);
		Plane.incrementPlane();
	}




	@Override
	public String toString(){
		return super.toString()+" \n Boing787, avion con "+this.AUTONOMY+" \n km de autonomia, capacidad de "+this.CAPACITY+" \n pasajeros "+
		" \n con un consumo de "+this.CONSUMTIOM+" \n L/min y un precio de "+this.PRICE;
	}

	@Override
	public boolean equals(Object obj){
		boolean igual=false;
		if(obj instanceof Boing787){
			Boing787 tmp=(Boing787) obj;
			if(super.equals(obj)&& 
			   this.AUTONOMY==AUTONOMY&&
			   this.CAPACITY==CAPACITY&&
			   this.CONSUMTIOM==CONSUMTIOM&&
			   this.PRICE==PRICE){
					igual=true;
			}
		}
		return igual;
	}
	
}