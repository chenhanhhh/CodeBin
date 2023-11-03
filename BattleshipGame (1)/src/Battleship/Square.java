package Battleship;
public class Square {

	private String shipType = "null";
	private boolean isAttacked;
	private boolean haveShip;

	public Square(String shipType ) {
		this.shipType = shipType;
		isAttacked = false;
		haveShip = true;
	}

	public Square(){
		isAttacked = false;
		haveShip = false;
	}

	public void beAttacked(){
		isAttacked=true;
	}

	public String getShipType(){
		return shipType;
	}

	public boolean getHaveShip(){
		return haveShip;
	}

	public boolean getIsAttacked(){
		return isAttacked;
	}



}
