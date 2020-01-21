/**
 * is an abstract class that maintains a design that every player has a symbol (X or O), 
 * a name, and an abstract play(board gameboard) method. It also maintains a reference to 
 * the game board for players to examine and make their move.
 * @author Tony Alas
 * @version 1.0 - November 19, 2018
 * Student ID: 104754179
 */
public abstract class Player {
    //attributes: 

    /** makes sure that every player maintains a symbol (X or O) */
    protected String symbol;

    /** the name of the player */
    protected String name;

    // methods: 

    /** this will make a play by the user
     * @param Board gameboard - takes as input the current board
     */
    protected abstract void play(Board gameboard);
}