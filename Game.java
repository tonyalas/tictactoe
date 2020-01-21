/**
 * contains a game board and two players, playerX and playerO. It manages the iteration with the players. 
 * First by getting the player names, does a coin toss to decide the turn and allows each player to take a turn and make a move. 
 * It finally announces the winner/draw when the game ends.
 * @author Tony Alas
 * @version 1.0 - November 19, 2018
 * Student ID: 104754179
 */
import java.util.Scanner;
import java.util.Random;
import java.lang.Math;
import java.util.concurrent.TimeUnit;

public class Game {
    // attributes:

    /** this makes use of class composition to get a player */
    Player playerX;
    /** this is another player */
    Player playerO;
    /** this is the gameboard that makes up the game */
    Board gameboard;

    // methods:

    /** default constructor */
    public Game() {
        playerX = new HumanPlayer();
        playerO = new HumanPlayer("O", "player 2");
        gameboard = new Board();
    }

    /** this will start up the game */
    public void start() {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("\n*************************\n");
        System.out.println("Welcome to Tic-Tac-Toe!");
        System.out.println("\n*************************\n");
        System.out.println("How many (human) players are there? (1 or 2): ");
        int numOfPlayers = keyboard.nextInt();
        //if there are two players then make the game around 2 human players
        if(numOfPlayers == 2) {
            String junk = keyboard.nextLine();
            System.out.println("What is the name of the first player?");
            String player1Name = keyboard.nextLine();
            System.out.println("What is the name of the second player?");
            String player2Name = keyboard.nextLine();
            playerX = new HumanPlayer("x", player1Name);
            playerO = new HumanPlayer("o", player2Name);
            //this will flip a coin to see who goes first
            double randNum = 0.0;
            randNum = Math.random();
            //this will assign who goes first and store who it is
            int firstTurn = 0;
            //this will assign the first player
            if(randNum < 0.5) {
                System.out.println("\n" + player1Name + " you have been assigned x, and go first.\n");
                firstTurn = 1;
            }
            else {
                System.out.println("\n" + player2Name + " you have been assigned o, and go first.\n");
                firstTurn = 2;
            }
            //this will print the current state of the board as it is currently EMPTY
            gameboard.getState();

            //this will keep track of who's turn it is
            int currentPlayer = 0; // 1 = playerX, 2 = playerO

            //this will allow the player to make a move

            //if playerX goes first then let them go first
            if(firstTurn == 1) {
                playerX.play(gameboard);
                currentPlayer = 2;
            }
            //if playerO got chosen to go first then let them go first
            else if(firstTurn == 2) {
                playerO.play(gameboard);
                currentPlayer = 1;
            }
            //after the initial play, change the board state to IN GAME since it is no longer EMPTY
            gameboard.setState("IN GAME");
            //after the initial play, enter a loop to keep playing the game.
            while(gameboard.getState().equals("IN GAME")) {
                //now it will simply rotate between players
                if(currentPlayer == 1) {
                    playerX.play(gameboard);
                }
                else if(currentPlayer == 2) {
                    playerO.play(gameboard);
                }
                //reassign the new current player using the tertiary if/else statement
                currentPlayer = (currentPlayer == 1) ? 2 : 1;
            }
            //if the game is a draw
            if(gameboard.getState2().equals("DRAW")) {
                System.out.println("It's a DRAW!");
            }
            //if playerX wins the game
            else if(gameboard.getState2().equals("X")) {
                System.out.println("PlayerX, " + player1Name + ", wins the game!");
            }
            //if playerO wins the game
            else if(gameboard.getState2().equals("O")) {
                System.out.println("PlayerO, " + player2Name + ", wins the game!");
            }

        }
        //if there is only one player, create an AI player
        else if(numOfPlayers == 1) {
            String junk = keyboard.nextLine();
            System.out.println("What is the name of the first player?");
            String player1Name = keyboard.nextLine();
            System.out.println("\nYou are going to play against an AI player.\n");
            playerX = new HumanPlayer("x", player1Name);
            playerO = new AIPlayer();
            System.out.println("Welcome to the game " + player1Name + ", my name is " + playerO.name + ". Let's see if you can defeat me! (hint: I'm not very intelligent, so probably).\n");

            //this will flip a coin to see who goes first
            double randNum = 0.0;
            randNum = Math.random();
            //this will assign who goes first and store who it is
            int firstTurn = 0;
            //this will assign the first player
            if(randNum < 0.5) {
                System.out.println("\n" + player1Name + " you have been assigned x, and go first.\n");
                firstTurn = 1;
            }
            else {
                System.out.println("\n" + playerO.name + " you have been assigned o, and go first.\n");
                System.out.println("HA. I knew I would go first. After all, I am the AI controlling this ga-...err I mean...we must save Halo!\n");
                //this will simply pause the game for a brief moment so a giant wall of text isn't thrown at the user
                try        
                {
                    Thread.sleep(3000);
                } 
                catch(InterruptedException ex) 
                {
                    Thread.currentThread().interrupt();
                }
                firstTurn = 2;
            }
            //this will print the current state of the board as it is currently EMPTY
            gameboard.getState();

            //this will keep track of who's turn it is
            int currentPlayer = 0; // 1 = playerX, 2 = playerO

            //if playerX goes first then let them go first
            if(firstTurn == 1) {
                playerX.play(gameboard);
                currentPlayer = 2;
            }
            //if playerO got chosen to go first then let them go first
            else if(firstTurn == 2) {
                playerO.play(gameboard);
                currentPlayer = 1;
            }

            //after the initial play, change the board state to IN GAME since it is no longer EMPTY
            gameboard.setState("IN GAME");
            //after the initial play, enter a loop to keep playing the game.
            while(gameboard.getState().equals("IN GAME")) {
                //now it will simply rotate between players
                if(currentPlayer == 1) {
                    playerX.play(gameboard);
                }
                else if(currentPlayer == 2) {
                    playerO.play(gameboard);
                }
                //reassign the new current player using the tertiary if/else statement
                currentPlayer = (currentPlayer == 1) ? 2 : 1;
            }
            //if the game is a draw
            if(gameboard.getState2().equals("DRAW")) {
                System.out.println("It's a DRAW!");
                int copy = 169;
                char copyright = (char)copy;
                System.out.println("Huh, I guess we both aren't very good at this game. Let's go play some Halo 3 " + copyright + " Slayer like the good old days!");
            }
            //if playerX wins the game
            else if(gameboard.getState2().equals("X")) {
                System.out.println("PlayerX, " + player1Name + ", wins the game!");
                System.out.println("You may have bested me this time, but I will come back stronger than ever with my good pal Master Chief next time!");
            }
            //if playerO wins the game
            else if(gameboard.getState2().equals("O")) {
                System.out.println("PlayerO, " + playerO.name + ", wins the game!");
                System.out.println("I guess as they say, it sucks to suck! Hahahaha. Maybe you'll do better next time champ.");
            }
        }
    }
}