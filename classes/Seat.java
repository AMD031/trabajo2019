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
	public String codeSeat;

	//Este constructor es para un asiento VIP.
	public Seat(String codeSeat, boolean vip){
		this.codeSeat=codeSeat;
	}

	//Este constructor es para un asiento NO VIP.
	public Seat(String codeSeat){
		this.codeSeat=codeSeat;
	}

	/*Metodo para comprobar que el asiento esta reservado.
	public boolean reservedSeat(){

	}
	*/
}