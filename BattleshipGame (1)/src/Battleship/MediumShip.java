package Battleship;
public class MediumShip extends Ship{
	
	static int size = 2;
	static int num = 2;
	int row1,row2,column1,column2;

	public MediumShip(int row1, int column1, int row2, int column2){
		shipType="Meidum Ship";
		this.column1=column1; this.column2=column2; this.row1=row1; this.row2=row2;
		hp=2;
		isSunk=false;
	}

}
