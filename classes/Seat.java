package classes;
/**
	*Seat.class
	*Permite crear objetos de tipo Seat, con dos constructores
	uno para los asientos vip y otro para los no vip.
	*@author Samuel Hermosilla Aguilera.
*/
public class Seat{
	public boolean vip;
	public boolean reserved=false;
	//Esta compuesto por un numero y una letra que establece la posicion del asiento.
	public String codeSeat;
	public int row;
	public char column;

	
	public Seat(String codeSeat, boolean vip, int row, char column){
		this.codeSeat=codeSeat;
		this.vip=vip;
		this.row=row;
		this.column=column;
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



	/*Metodo para comprobar que el asiento esta reservado.
	public boolean reservedSeat(){

	}
	*/
}