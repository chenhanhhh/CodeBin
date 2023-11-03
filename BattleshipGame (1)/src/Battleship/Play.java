package Battleship;
import java.util.Scanner;
import java.io.IOException;


public class Play {
    public static void main(String[] args){

        //initialize
        Board newBoard = new Board();
        int[] score = {0,0};
        Scanner input = new Scanner(System.in);

        //Game Start
        System.out.println("Game Start!!!!!");

        //play in turn
        for(int round = 1; round <=200; round++){
            if(newBoard.checkGameOver()){
                break;
            }
            String a = newBoard.toString();
            System.out.println(a);
            System.out.println(newBoard.aliveLargeShip+ " large ship  "+newBoard.aliveMediumShip+" medium ship  "+newBoard.aliveSmallShip+" small ship alive");
            System.out.println("Scores: player1:  "+score[0]+"     player2:  "+score[1]);
            System.out.println("player"+((round+1)%2+1)+" please choose square to attack");
                        
            int r,c;
            
            // check if input is integer; Check of integer's scale is in the Board.attackSquare();
            System.out.println("input your chosen ROW number:");
            if(input.hasNextInt()) {
            	r = input.nextInt()-1;
            }
            else {
            	 System.out.println("invalid input, turn to next palyer");
            	 String InputBin = input.next();
            	 continue;
            }
         
            System.out.println("input your chosen COLUMN number:");
            if(input.hasNextInt()) {
            	c = input.nextInt()-1;
            }
            else {
            	 System.out.println("invalid input, turn to next palyer");
            	 String InputBin = input.next();
            	 continue;
            }
           

            int roundScore = newBoard.attackSquare(r,c);
            if(roundScore==0){
                System.out.println("you have no score this round");
            }
            else{
                score[(round+1)%2]+=roundScore;
                System.out.println("you got 1 score!");
            }



        }
        input.close();
        
        String a = newBoard.toString();
        System.out.println(a);
        System.out.println("Game End!!!");
        System.out.println("Scores: player1:"+score[0]+"  player2:"+score[1]);
        if(score[0]>score[1]){System.out.println("player1 wins!!!");}
        else if(score[0]<score[1]){System.out.println("player2 wins!!!");}
        else{System.out.println("A Dead Hit!!!");}
     

    }
}