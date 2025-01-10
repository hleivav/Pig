package org.example;
import java.util.Scanner;
import java.util.Random;

public class Game {
    private Player player1;
    private Player player2;
    private Player currentPlayer;
    final Scanner scanner;
    // ANSI escape-koder för färger
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    //Constructor
    public Game () {
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        GameHelper.print("Welcome to Pig!");
        GameHelper.print("Enter your name, player 1: ");
        String player = scanner.nextLine();
        player1 = new Player(player, true);
        GameHelper.print("Enter your name, player 2: ");
        player = scanner.nextLine();
        player2 = new Player(player, false);
        currentPlayer = player1;
        do {
           playTurn();

        } while (player1.playerScore() < 100 && player2.playerScore() < 100);
        GameHelper.print(ANSI_YELLOW + "And the winner is... " + currentPlayer.getName() + " with " + currentPlayer.playerScore() + " points");
    }

    private void playTurn(){
        int diceResult ;
        GameHelper.print(ANSI_BLUE + "The score is: " );
        GameHelper.print(player1.getName() + " : " + player1.playerScore() + " - " + player2.getName() + " : " + player2.playerScore());
        GameHelper.print(ANSI_PURPLE + "It's " + currentPlayer.name + "'s time to play");
        GameHelper.print("Press Y to role the dice or N to let your opponent play");
        String pTurn = scanner.nextLine();
        if (pTurn.equalsIgnoreCase("Y")){
            diceResult = rollTheDice();
            GameHelper.print(ANSI_YELLOW + "The Dice shows: " + diceResult);
            if (diceResult == 1){
                GameHelper.print(ANSI_RED + "You got an 1 and lose all your points. ");
                currentPlayer.emptyScore();
                currentPlayer =  GameHelper.playerChange(player1, player2);

            } else {
                currentPlayer.increaseScore(diceResult);
            }

        } else if (pTurn.equalsIgnoreCase("N")) {
            currentPlayer = GameHelper.playerChange(player1, player2);
        } else {
            GameHelper.print("Press Y to role the dice or N to let your opponent play");
        }
    }

    public int rollTheDice(){
        Random random = new Random();
        return random.nextInt(6) +1;
    }

    public static  class GameHelper{

        public static Player playerChange(Player player1, Player player2){
            Player currentPlayer = player1;
            if (player1.playerStatus()){
                player1.changeStatusToFalse();
                player2.changeStatusToTrue();
                currentPlayer = player2;
            } else {
                player1.changeStatusToTrue();
                player2.changeStatusToFalse();
            }
            return currentPlayer;
        }
        public static void print(String stringToPrint){
            System.out.println(stringToPrint);
        }
        public static void print(int intToPrint){
            System.out.println(intToPrint);
        }
    }
}
