package classes;
/**
	*Seat.class
	*Permite crear objetos de tipo Seat, con dos constructores
	uno para los asientos vip y otro para los no vip.
	*@author Samuel Hermosilla Aguilera.
*/
public class Seat{
	private final static int PRICE_DEF=50;
	private boolean vip;
	private boolean reserved;
	private String codeSeat;
	private int row;
	private char column;
	private int price;



	public Seat(boolean vip, int row, char column, boolean reserved, int price){
		this.vip=vip;
		this.row=row;
		this.column=column;
		this.reserved=reserved;
		setPrice(price);
		
	}

	public Seat(boolean vip, int row, char column){
		this(vip,row,column,false,PRICE_DEF);
	}


	//Getters
	public boolean getVip(){
		return this.vip;
	}

	public boolean getReserved(){
		return this.reserved;
	}

	public String getCodeSeat(){
		return codeSeat;
	}

	public int getRow(){
		return this.row;
	}

	public char getColumn(){
		return this.column;
	}

	public int getPrice(){
		return this.price;
	}

	//Setters
	public void setVip(boolean vip){
		this.vip=vip;
	}

	public void setReserved(boolean reserved){
		this.reserved=reserved;
	}

	public void setCodeSeat(String codeseat){
		this.codeSeat=codeseat;
	}

	public void setRow(int row){
		this.row=row;
	}

	public void setColumn(char column){
		this.column=column;
	}

	public void setPrice(int price){
		if(this.vip=true){
			this.price=(price*1.2);
		}else{
			this.price=price;
		}
	}


	@Override
	public String toString(){
		return " vip: "+this.vip+" fila: "+this.row+" columna: "
		+this.column+" reservado: "+this.reserved;
	}

}