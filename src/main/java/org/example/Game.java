package org.example;
import java.util.Scanner;
import java.util.Random;

public class Game {
    private Player player1;
    private Player player2;
    private Player currentPlayer;
    final Scanner scanner;

    //Constructor
    public Game () {
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        System.out.println("Welcome to Pig!");
        System.out.print("Enter your name, player 1: ");
        String playerName = scanner.nextLine();
        player1 = new Player(playerName);
        System.out.print("Enter your name, player 2: ");
        playerName = scanner.nextLine();
        player2 = new Player(playerName);
        //player1 starts
        currentPlayer = player1;
        do {
           playTurn();

        } while (player1.playerScore() < 100 && player2.playerScore() < 100);
    }

    private void playTurn(){
        System.out.println("It's " + currentPlayer + "'s time to play");
        System.out.print("Press Y to role the dice or N to let your opponent play");

    }

    public int rollTheDice(){
        Random random = new Random();

        return random.nextInt(6) +1;
    }

}
