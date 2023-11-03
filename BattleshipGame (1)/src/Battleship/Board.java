package Battleship;
import java.util.Random;

public class Board {

	private Square[][] board;
	private LargeShip[] largeShips = new LargeShip[LargeShip.num];
	private MediumShip[] mediumShips = new MediumShip[MediumShip.num];
	private SmallShip[] smallships = new SmallShip[SmallShip.num];
	private boolean gameOver;
	public int aliveSmallShip, aliveMediumShip, aliveLargeShip;



	public Board() {
		board = new Square[10][10];
		for (int r = 0; r < 10; r++) {
			for (int c = 0; c < 10; c++) {
				board[r][c] = new Square();
			}
		}
		this.generateSmallShip();
		this.generateMediumShip();
		this.generateLargeShip();
		gameOver=false;



	}

	private void generateSmallShip() {
		Random rand = new Random();
		int smallShipCount = 0;
		do {
			int randR = rand.nextInt(10);
			int randC = rand.nextInt(10);
			if (board[randR][randC].getHaveShip() == false) {
				board[randR][randC] = new Square("small");
				smallships[smallShipCount]= new SmallShip(randR, randC);
				smallShipCount += 1;
			}
		} while (smallShipCount < SmallShip.num);
		aliveSmallShip=SmallShip.num;
	}

	private void generateMediumShip() {
		Random rand = new Random();
		int mediumShipCount = 0;
		do {
			boolean randDirection = rand.nextBoolean();
			if (!randDirection) {
				int randR = rand.nextInt(10);
				int randC = rand.nextInt(9);
				if (board[randR][randC].getHaveShip() == false && board[randR][randC + 1].getHaveShip() == false) {
					board[randR][randC] = new Square("medium");
					board[randR][randC + 1] = new Square("medium");
					mediumShips[mediumShipCount]=new MediumShip(randR, randC, randR, randC+1);
					mediumShipCount += 1;
				}
			}
			if (randDirection) {
				int randR = rand.nextInt(9);
				int randC = rand.nextInt(10);
				if (board[randR][randC].getHaveShip() == false && board[randR + 1][randC].getHaveShip() == false) {
					board[randR][randC] = new Square("medium");
					board[randR + 1][randC] = new Square("medium");
					mediumShips[mediumShipCount]=new MediumShip(randR, randC, randR+1, randC);
					mediumShipCount += 1;
				}
			}
		} while (mediumShipCount < MediumShip.num);
		aliveMediumShip=MediumShip.num;
	}

	private void generateLargeShip() {
		Random rand = new Random();
		int largeShipCount = 0;
		do {
			boolean randDirection = rand.nextBoolean();
			if (!randDirection) {
				int randR = rand.nextInt(10);
				int randC = rand.nextInt(8);
				if (board[randR][randC].getHaveShip() == false && board[randR][randC + 1].getHaveShip() == false
						&& board[randR][randC + 2].getHaveShip() == false) {
					board[randR][randC] = new Square("large");
					board[randR][randC + 1] = new Square("large");
					board[randR][randC + 2] = new Square("large");
					largeShips[largeShipCount]= new LargeShip(randR, randC, randR, randC+1, randR, randC+2);
					largeShipCount += 1;
				}
			}
			if (randDirection) {
				int randR = rand.nextInt(8);
				int randC = rand.nextInt(10);
				if (board[randR][randC].getHaveShip() == false && board[randR + 1][randC].getHaveShip() == false
						&& board[randR + 2][randC].getHaveShip() == false) {
					board[randR][randC] = new Square("large");
					board[randR + 1][randC] = new Square("large");
					board[randR + 2][randC] = new Square("large");
					largeShips[largeShipCount]= new LargeShip(randR, randC, randR+1, randC, randR+2, randC);
					largeShipCount += 1;
				}
			}
		} while (largeShipCount < LargeShip.num);
		aliveLargeShip=LargeShip.num;
	}

	public int attackSquare(int r, int c){
		
		if(r>=10||r<0||c>=10||c<0) {
			System.out.println("outOfBounder!!!!   Turn to next player!");
			return 0;
		}
		if(board[r][c].getIsAttacked()==true){
			System.out.println("This square has been attacked, turn to next player.");
			return 0;

		}else if(board[r][c].getHaveShip()==false){
			System.out.println("You missed, turn to next player.");
			board[r][c].beAttacked();
			return 0;
		}
		else if(board[r][c].getShipType()=="small"){
			for(int i = 0; i < SmallShip.num; i++){
				if(smallships[i].row==r && smallships[i].column==c){
					board[r][c].beAttacked();

					return smallships[i].beHit();
				}
			}
		}else if(board[r][c].getShipType()=="medium"){
			for(int i = 0; i < MediumShip.num; i++){
				if((mediumShips[i].row1==r && mediumShips[i].column1==c) || (mediumShips[i].row2==r && mediumShips[i].column2==c)){
					board[r][c].beAttacked();
					return mediumShips[i].beHit();
				}
			}
		}else if(board[r][c].getShipType()=="large"){
			for(int i = 0; i < LargeShip.num; i++){
				if((largeShips[i].row1==r && largeShips[i].column1==c) || (largeShips[i].row2==r && largeShips[i].column2==c) || (largeShips[i].row3==r && largeShips[i].column3==c)){
					board[r][c].beAttacked();
					return largeShips[0].beHit();
				}
			}
		}
		
		return 0;
	}

	public String toString() {
		String output = "";
		for (int r = 0; r < 10; r++) {
			for (int c = 0; c < 10; c++) {
				if (!board[r][c].getIsAttacked()) {
					output += String.format("%-3s", "-");
				} else if(board[r][c].getHaveShip()){
					output += String.format("%-3s", "x");
				} else{
					output += String.format("%-3s", "o");
				}
			}
			output += "\n";
		}
		return output;
	}

	public void renewAliveShip(){
		int small=0, medium=0, large=0;
		for(int i=0; i<SmallShip.num; i++){
			if(smallships[i].isSunk==false){
				small+=1;
			}
		}
		aliveSmallShip=small;
		for(int i=0; i<MediumShip.num; i++){
			if(mediumShips[i].isSunk==false){
				medium+=1;
			}
		}
		aliveMediumShip=medium;
		for(int i=0; i<LargeShip.num; i++){
			if(largeShips[i].isSunk==false){
				large+=1;
			}
		}
		aliveLargeShip=large;

	}

	public boolean checkGameOver(){
		renewAliveShip();
		if((aliveLargeShip+aliveMediumShip+aliveSmallShip)==0){
			gameOver=true;
		}
		
		return gameOver;
	}
	

}