package Battleship;
public class Ship {
	
protected int hp;
protected boolean isSunk;
protected String shipType;


public Ship() {
	
}

protected void beSunk(){
	isSunk=true;
	System.out.println("One " + shipType + " Ship Has Been Sunk! ");

}

protected int beHit() {
	hp-=1;
	if (hp==0) {this.beSunk(); return 1;}
	System.out.println("you have Hit a target!  HP-1 ");
	return 0;
	// return 0 or 1 stands for whether this attack scores.
}



}
