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
	private static final int ROWS=20;
	private static final int COLUMNS=4;
	private static final int AMOUNTVIP=5;

	public AirBusA320(String idPlane, GregorianCalendar acquisitionDate)throws Exception{
		super(idPlane, acquisitionDate,AMOUNTVIP,ROWS,COLUMNS,CONSUMTIOM);
		Plane.incrementPlane();
	}

	@Override
	public String toString(){
		return " \n AirBusA320, avion con "+this.AUTONOMY+"\n km de autonomia, capacidad de "+this.CAPACITY+"\n pasajeros"+
		" con un consumo de "+this.CONSUMTIOM+"\n L/min y un precio de "+this.PRICE;
	}

	@Override
	public boolean equals(Object obj){
		boolean igual=false;
		if(obj instanceof AirBusA320){
			AirBusA320 tmp=(AirBusA320) obj;
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