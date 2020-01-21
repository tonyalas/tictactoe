/**
 * extends player, a type of player that requests its input from the user and submit the move (or play) to the gameboard.
 * @author Tony Alas
 * @version 1.0 - November 19, 2018
 * Student ID: 104754179
 */
import java.util.Scanner;

public class HumanPlayer extends Player {
    
    //methods:

    /** default constructor */
    public HumanPlayer() {
        symbol = "x";
        name = "player 1";
    }

    /** overloaded constructor 
     * @param String symbol - the given symbol to assign the player
     * @param String name - the given name of the player
    */
    public HumanPlayer(String symbol, String name) {
        this();
        this.symbol = symbol;
        setName(name);
    }

    /**
     * This will set the name of the player
     * @param name the name to set
     */
    public void setName(String name) {
        //checks to make sure the author is not blank
        if(name.length() > 0) {
            this.name = name;
        }
    }

    /** the overridden method of play from Player 
     * @param Board gameboard - the gameboard that will be affected by the inputs
    */
    public void play(Board gameboard) {
        Scanner keyboard = new Scanner(System.in);
        System.out.println(name + " ("+ symbol + "), enter your move (row [0-2] column [0-2]): ");
        int rowChoice = keyboard.nextInt();
        int columnChoice = keyboard.nextInt();
        while(gameboard.makeMove(rowChoice, columnChoice, symbol) != 0) {
            System.out.println(name + " ("+ symbol + "), enter your move (row [0-2] column [0-2]): ");
            rowChoice = keyboard.nextInt();
            columnChoice = keyboard.nextInt();
        }
    }
}