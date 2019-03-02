package classes;
/**
	*Seat.class
	*Permite crear objetos de tipo Seat, con dos constructores
	uno para los asientos vip y otro para los no vip.
	*@author Samuel Hermosilla Aguilera.
*/
public class Seat{
	private boolean vip;
	private boolean reserved;
	private String codeSeat;
	private int row;
	private char column;
	private double price;



	public Seat(boolean vip, int row, char column, boolean reserved){
		this.vip=vip;
		this.row=row;
		this.column=column;
		this.reserved=reserved;	
	}

	public Seat(boolean vip, int row, char column){
		this(vip,row,column,false);
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




	@Override
	public String toString(){
		String vip = "";
		String assigned = "";
		if(this.vip){
			vip="Y";
		}else{vip="N";};

		return "vip: "+vip +" "+this.row+""+this.column;
	}

}