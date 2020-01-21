/**
 * extends player, a type of player that implements a simple computer player. 
 * The simplest strategy is to play a valid random move. Feel free to design more difficult or "intelligent" game players.
 * @author Tony Alas
 * @version 1.0 - November 19, 2018
 * Student ID: 104754179
 */
import java.util.Random;

public class AIPlayer extends Player {
    // methods: 

    /** default constructor */
    public AIPlayer() {
        symbol = "o";
        name = "Guilty Spark";
    }

    /** overloaded constructor 
     * @param String symbol - the given symbol to assign the bot
     * @param String name - the given name of the bot
    */
    public AIPlayer(String symbol, String name) {
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
        System.out.println(name + " ("+ symbol + "), it is your turn to play: ");
        System.out.println("Pfft, child's play. Even a grunt can do this.");
        Random randR = new Random();
        Random randC = new Random();
        //generate a random number between 0-2
        int randomRow = randR.nextInt((2-0) + 1) + 0;
        int randomCol = randC.nextInt((2-0) + 1) + 0;
        int randRowTemp = randomRow;
        int randColTemp = randomCol;
        //to make it seem more realistic, print the numbers that the ai came up with
        System.out.print(randRowTemp + " ");
        System.out.println(randColTemp);
        //if the play cannot be made the AI will try again
        while(gameboard.makeMove(randomRow, randomCol, symbol) != 0) {
            System.out.println("Dang it! Let me try again.");
            System.out.println(name + " ("+ symbol + "), it is your turn to play: ");
            randomRow = randR.nextInt((2-0) + 1) + 0;
            randomCol = randC.nextInt((2-0) + 1) + 0;
            randRowTemp = randomRow;
            randColTemp = randomCol;
            System.out.print(randRowTemp + " ");
            System.out.println(randColTemp);
        }

    }

}