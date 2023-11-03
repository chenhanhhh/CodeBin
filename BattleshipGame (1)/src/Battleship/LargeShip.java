package Battleship;
public class LargeShip extends Ship{

	static int size = 3;
	static int num = 1;
	int row1, row2, column1, column2, row3, column3;


	public LargeShip(int row1, int column1, int row2, int column2, int row3, int column3){

		shipType="Large Ship";
		this.column1=column1; this.column2=column2; this.column3=column3; this.row1=row1; this.row2=row2; this.row3=row3;
		hp=3;
		isSunk=false;
	}
	
}
