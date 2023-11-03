package Battleship;
public class SmallShip extends Ship {

	static int size = 1;
	static int num = 3;
	public int row;
	public int column;
	
	public SmallShip(int row, int column){
		shipType="Small Ship";
		this.row=row; this.column=column;
		hp=1;
		isSunk=false;
	
	}
	
}
